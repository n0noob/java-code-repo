package com.comprog.arrayoperations;

import java.util.*;

class Result {

    /*
     * Complete the 'playlist' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY songs as parameter.
     */

    private static long res;

    private static Map<Integer, Integer> countMap;

    private static Map<Integer, Boolean> doneMultiples;

    static {
        countMap = new HashMap<>(1001);
        res = 0;
        doneMultiples = new HashMap<>();
    }

    public static long playlist(List<Integer> songs) {

        songs.sort(Comparator.naturalOrder());

        //Initialize map
        for(int i = 0; i < songs.size(); i++) {
            if(countMap.containsKey(songs.get(i))) {
                Integer curVal = countMap.get(songs.get(i));
                countMap.put(songs.get(i), curVal + 1);
            } else {
                countMap.put(songs.get(i), 1);
            }
        }

        //Special treatment for 30
        if(countMap.containsKey(30)) {
            res = res + calCombinations(countMap.get(30));
        }

        for(int i = 0; i < songs.size(); i++) {
            countPairs(songs, i);
        }

        return res;

    }

    public static void countPairs(List<Integer> songs, int i) {

        int curSongDur = songs.get(i);

        if(curSongDur != 30) {
            // Find the remainder
            int rem = songs.get(i) % 60;

            //Check if rem itself is not a multiple of 60
            if(rem > 0) {

                int durationToFind = 60 - rem;

                //Check if (60-rem) exists in array
                if (countMap.containsKey(durationToFind) && durationToFind < curSongDur) {
                    res = res + countMap.get(durationToFind);
                }
            } else if(!doneMultiples.containsKey(curSongDur)) {
                res = res + calCombinations(countMap.get(curSongDur));
                doneMultiples.put(curSongDur, true);
            }
        }
    }

    public static int calCombinations(int n) {
        if(n == 1)
            return 0;
        else if(n <= 2)
            return 1;
        return fact(n)/(fact(n-2)*fact(2));
    }

    public static int fact(int num){
        int fact=1, i;
        for(i=1; i<=num; i++){
            fact = fact*i;
        }
        return fact;
    }

}

public class SumMultipleOf60 {
    public static void main(String[] args) {

        long res = Result.playlist(Arrays.asList(4, 10, 50, 90, 30));

        System.out.println(res);

    }
}
