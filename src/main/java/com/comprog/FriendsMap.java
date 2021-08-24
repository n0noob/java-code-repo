package com.comprog;

/*
Friends Map
--------------
1 <-> 2
4 <-> 2
5 <-> 17
8 <-> 2
11 <-> 12
12 <-> 8
2 <-> 5
22 <-> 7
16 <-> 22
31 <-> 71
21 <-> 8



 */


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FriendsMap {

    Map<Integer, Set<Integer>> map;

    public FriendsMap() {
        map = new HashMap<>();
    }

    public void createMap(Map<Integer, Integer> input) {

        input.entrySet().stream().forEach(entry -> {

            //If map contains key
            if(map.containsKey(entry.getKey())) {
                map.get(entry.getKey()).add(entry.getValue());
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(entry.getValue());
                map.put(entry.getKey(), set);
            }

            map.put(entry.getValue(), map.get(entry.getKey()));

            //If map contains value
//            if(map.containsKey(entry.getValue())) {
//                map.get(entry.getValue()).add(entry.getKey());
//            } else {
//                Set<Integer> set = new HashSet<>();
//                set.add(entry.getKey());
//                map.put(entry.getValue(), set);
//            }
        });
    }

    public void printMap() {
        map.entrySet().stream().forEach(entry -> {
            System.out.print(entry.getKey() + " > ");
            entry.getValue().forEach(i -> {
                System.out.print(i + " ");
            });
            //entry.getValue().stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",", "[", "]"));
            System.out.println();
        });
    }

    public static void main(String[] args) {
        FriendsMap friendsMap = new FriendsMap();

        Map<Integer, Integer> input = new HashMap<>();

        input.put(1, 2);
        input.put(4, 2);
        input.put(5, 17);
        input.put(8, 2);
        input.put(11, 12);
        input.put(12, 8);
        input.put(2, 5);
        input.put(22, 7);
        input.put(16, 22);
        input.put(31, 71);
        input.put(21, 8);

        friendsMap.createMap(input);

        friendsMap.printMap();

    }

}
