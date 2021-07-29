package com.comprog.stringoperations;

public class Permutation2 {

    static int count = 0;

    private void swap(char[] arr, int i, int j) {
        if(i != j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    private void foo(char[] arr, int idx) {

        if(idx == arr.length - 1) {
            System.out.println(new String(arr));
            count++;
            return;
        }


        for(int i = idx; i < arr.length; i++) {
            swap(arr, i, idx);
            foo(arr, idx + 1);
            swap(arr, idx, i);
        }
    }

    public static void main(String[] args) {
        Permutation2 permutation2 = new Permutation2();
        permutation2.foo("Vijay".toCharArray(), 0);
        System.out.println("Count : " + count);
    }

}
