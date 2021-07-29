package com.comprog.ds.heap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryMaxHeapTest {

    private static List<Integer> itemList;

    @BeforeAll
    public static void init() {
        itemList = new ArrayList<>();
        itemList.add(2);
        itemList.add(4);
        itemList.add(6);
        itemList.add(1);
        itemList.add(15);
        itemList.add(12);
    }

    @Test
    void addTest() {
        BinaryMaxHeap heap = new BinaryMaxHeap();
        itemList.forEach((item) -> {
            heap.add(item);
        });
        assertEquals(heap.peek(), 15);
    }

    @Test
    void pollTest() {
        BinaryMaxHeap heap = new BinaryMaxHeap();
        itemList.forEach((item) -> {
            heap.add(item);
        });
        int polled = heap.poll();
        assertEquals(polled, 15);
        int peek = heap.peek();
        assertEquals(peek, 12);
    }

    @Test
    void pollEmptyTest() {
        BinaryMaxHeap heap = new BinaryMaxHeap();
        Integer polled = heap.poll();

        assertEquals(polled, null);
    }

}