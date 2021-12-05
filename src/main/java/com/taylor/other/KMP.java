package com.taylor.other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KMP {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(kmpNext("ABCDABD")));
    }

    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        Set<String> preStringSet = new HashSet<>();
        int time=0;
        for (int i = 1; i < dest.length(); i++) {
            String substring = dest.substring(0, i);
            System.out.println(i+","+substring);
            for (int j = substring.length()-1; j > 0; j--) {
                if (preStringSet.contains(substring.substring(j))){
                    time++;
                }
            }
            preStringSet.add(substring);
            next[i-1]=time;
        }
        System.out.println(preStringSet);
        return next;
    }
}
