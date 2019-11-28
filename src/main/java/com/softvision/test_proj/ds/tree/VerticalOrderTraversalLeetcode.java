package com.softvision.test_proj.ds.tree;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrderTraversalLeetcode {

    Map<Coordinate, Set<Coordinate>> map = new TreeMap<>((cor1, cor2) -> Integer.compare(cor1.x, cor2.x));

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        traversal(root, 0, 0);

        List<List<Integer>> res = new ArrayList<>();
        for(Map.Entry<Coordinate, Set<Coordinate>> e : map.entrySet()) {
            Set<Coordinate> temp = e.getValue();
            List<Integer> l = temp.stream()
                                .map((c) -> c.val)
                                .collect(Collectors.toList());
            res.add(l);
        }

        return res;
    }

    private void traversal(TreeNode node, int x, int y) {
        if(node == null)
            return;

        Coordinate curr = new Coordinate(node.val, x, y);

        //If map does not have any List for this
        if(!map.containsKey(curr)) {
            Set<Coordinate> set = new TreeSet<>((cor1, cor2) -> {
                if (cor1.x != cor2.x) {
                    return Integer.compare(cor1.x, cor2.x);
                }
                else if(cor1.y != cor2.y){
                    return Integer.compare(cor1.y, cor2.y);
                }
                else {
                    return Integer.compare(cor1.val, cor2.val);
                }
            });
            set.add(curr);
            map.put(curr, set);
        }
        //If map does have list of current coordinate
        else {
            map.get(curr).add(curr);
        }

        traversal(node.left, x-1, y+1);
        traversal(node.right, x+1, y+1);
    }

}

class Coordinate {
    int val, x, y;

    public Coordinate(int val, int x, int y) {
        this.val = val;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        Coordinate obj = (Coordinate) o;
        if(this.x != obj.x || this.y != obj.y)
            return false;
        else
            return true;
    }

    @Override
    public int hashCode() {
        String res = x + "" + y;
        return res.hashCode();
    }

    @Override
    public String toString() {
        return val + "";
    }
}
