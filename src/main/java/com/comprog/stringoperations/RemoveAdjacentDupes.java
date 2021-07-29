package com.comprog.stringoperations;

public class RemoveAdjacentDupes {
    public String removeDuplicates(String str) {

        char[] chars = str.toCharArray();

        int k = 0;
        int i = 1;

        // Traverse the input string
        while(i < chars.length) {
            //System.out.println("Value of k : " + k);
            char prev = k < 0 ? ' ' : chars[k];

            // When current character is not equal to prev
            if(prev != chars[i]) {

                k++;
                chars[k] = chars[i];
                i++;

            } else {

                while(i < chars.length && chars[k] == chars[i]) {
                    i++;
                }
                --k;

            }

        }

        return new String(chars).substring(0, k + 1);
    }

    public static void main(String[] args) {

        RemoveAdjacentDupes driver = new RemoveAdjacentDupes();
        System.out.println(driver.removeDuplicates("abbaca"));

    }
}
