package com.comprog.stringoperations;

public class ReverseWordsInString {

    String reverseWords(String s) {

        //If string is empty
        if(s == null || s.length() == 0)
            return s;

        //If string is not empty
        String[] str = s.split("\\.");
        String res = "";

        for(int i = str.length - 1; i >= 0; i--) {
            res = res + str[i] + ".";
        }
        return res.substring(0, res.length() - 1);

    }

    void reverse(char[] a, int start, int end) {
        if(start < end) {
            int s = start, mid = (end + start) / 2, e = end;

            while(s <= mid) {
                char temp = a[s];
                a[s++] = a[e];
                a[e--] = temp;
            }
        }
    }

    String reverseWordsManually(String s) {
        if(s == null || s.length() == 0)
            return s;

        char[] arr = s.toCharArray();

        //Index for word start
        int idxStart = 0;

        //Traverse through each character
        for(int i = 0; i < arr.length; i++) {

            //If word end has been encountered
            if(arr[i] == '.') {

                //Reverse the word
                reverse(arr, idxStart, i-1);

                //Reset the start index
                idxStart = i + 1;
            }
        }

        //Last word is yet to be reversed
        reverse(arr, idxStart, arr.length - 1);

        //Reverse the whole string
        reverse(arr, 0, arr.length - 1);

        return new String(arr);

    }

    public static void main(String[] args) {

        ReverseWordsInString driver = new ReverseWordsInString();
        String res = driver.reverseWords("i.like.this.program.very.much");

        //System.out.println(res);

        String res2 = driver.reverseWordsManually("i.like.this.program.very.much");

        System.out.println(res2);
    }
}
