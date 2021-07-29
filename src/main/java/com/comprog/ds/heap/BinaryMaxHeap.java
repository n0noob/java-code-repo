package com.comprog.ds.heap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.BufferOverflowException;

public class BinaryMaxHeap {

    private static Logger log = LoggerFactory.getLogger(BinaryMaxHeap.class);

    private Integer[] a = {};
    private static final int DEFAULT_CAPACITY = 10;
    private int size;

    public BinaryMaxHeap() {
        a = new Integer[DEFAULT_CAPACITY];
    }

    public void add(int item) {

        //Check for overflow
        if(size + 1 > a.length) {
            throw new BufferOverflowException();
        }

        //Add element
        a[size] = item;
        bubbleUp(size++);
    }

    public Integer peek() {
        //Underflow
        if(size == 0) {
            log.warn("Empty heap returning null");
            return null;
        }
        //Normal
        return a[0];
    }

    public Integer poll() {
        //Underflow
        if(size == 0) {
            log.warn("Empty heap returning null");
            return null;
        }

        //Normal
        int res = a[0];
        // If heap has more than 1 element
        if(size > 1) {
            a[0] = a[size - 1];
            bubbleDown(0);
        }
        size--;
        return res;
    }

    private void bubbleUp(int pos) {
        while(pos > 0) {
            if(a[pos] > a[(pos + 1)/2 - 1])
                swap(pos, (pos + 1)/2 - 1);
            pos = (pos + 1)/2 - 1;
        }
    }

    private void bubbleDown(int pos) {

        int leftIdx = 2*(pos + 1) - 1;
        int rightIdx = 2*(pos + 1);
        int maxIdx;

        if(leftIdx < size) {
            maxIdx = maxValueIndex(pos, leftIdx);
            if(rightIdx < size) {
                maxIdx = maxValueIndex(maxIdx, rightIdx);
            }
            if(pos != maxIdx) {
                swap(pos, maxIdx);
                log.info("Bubbling down");
                bubbleDown(maxIdx);
            }
        }

    }

    private int maxValueIndex(int i, int j) {
        return a[i] > a[j] ? i : j;
    }

    private void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
