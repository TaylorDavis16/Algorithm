package com.taylor.ArraySearching;

import java.util.Arrays;

public class InsertionSearch {
    private static int time=0;
    public static void main(String[] args) {
        int[] ints={1,8,10,89,89,800,600,2000,14,15,15,1000,1000,1234};
        int[] ints2={1,2,3,3,4,5,5,6,6,7,7,8,9,10,11,11,12,13,14,14,14,15,16};
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
        System.out.println(insertionSearch(ints,0,ints.length-1,89));
        System.out.println("Time="+time);
        time=0;
        System.out.println("------------------------------");
        System.out.println(insertionSearch(ints2,0,ints2.length-1,15));
        System.out.println("Time="+time);
    }
    public static int insertionSearch(int[] array,int start,int end,int value){
        time++;
        if (start>end || value<array[start] || value>array[end]){
            return -1;
        }
        int pivot=start+(end-start)*(value-array[start])/(array[end]-array[start]);
        if (value==array[pivot])
            return pivot;
        else if (value<array[pivot])
            return insertionSearch(array,start,pivot-1,value);
        else return insertionSearch(array,pivot+1,end,value);
    }
}
