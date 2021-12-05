package com.taylor.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MeanderingArray {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-1, 1, 2, 3, -5,8));
        Collections.swap(list,1,5);
        System.out.println(list);
        System.out.println(meanderingArray(list));
    }
    public static List<Integer> meanderingArray(List<Integer> unsorted) {
        // Write your code here
        Collections.sort(unsorted);
        List<Integer> list = new ArrayList<>();
        int left = 0, right = unsorted.size()-1;
        while (left<right){
            list.add(unsorted.get(right--));
            list.add(unsorted.get(left++));
        }
        if (left==right) list.add(unsorted.get(left));
        return list;
    }

    //failed
    public static List<Integer> meanderingArray2(List<Integer> unsorted) {
        int left = 0, right = unsorted.size()-1;
        int temp = unsorted.get(left);
        while (left<right){
            unsorted.set(left+1,temp);
            unsorted.set(left,unsorted.get(right));
            temp = unsorted.get(left+1);
        }
        return unsorted;
    }
    
}
