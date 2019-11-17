package com.softvision.test_proj.stringoperations;

import java.io.*;
import java.util.*;

public class KMPAlgorithm {

    public int[] createTempArray(String pattern) {
        //Case when pattern is empty
        if(pattern == null || pattern.length() == 0)
            return null;

        int[] a = new int[pattern.length()];

        //Case when pattern has only one element
        if(pattern.length() == 1) {
            return a;
        }

        char[] pat = pattern.toCharArray();

        //Normal case
        int index = 0;
        a[0] = 0;

        for(int i = 1; i < pattern.length(); ) {
            //When characters at i and j are equal
            if(pat[index] == pat[i]) {
                a[i] = index + 1;
                index++;
                i++;
            }
            else {
                if(index == 0) {
                    a[i] = 0;
                    i++;
                }
                else {
                    index = a[index-1];
                }
            }
        }

        return a;

    }


    public boolean KMP(String string, String pattern) {
        int[] a = createTempArray(pattern);

        int i = 0;
        int j = 0;
        while(i < string.length() && j < pattern.length()) {

            if(string.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            else {
                if(j != 0) {
                    j = a[j-1];
                }
                else {
                    i++;
                }
            }
        }

        if(j == pattern.length()) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        KMPAlgorithm driver = new KMPAlgorithm();
        boolean res = driver.KMP("abcxabcdabcdabcya","abcdabcy");
        System.out.println(res);
    }
}

