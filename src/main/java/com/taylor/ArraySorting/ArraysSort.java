package com.taylor.ArraySorting;

public class ArraysSort {
    public static void main(String[] args) {
//        UnsortedArrays.testSpeed(6666666,UnsortedArrays.ARRAYS_SORT);
//        UnsortedArrays.testSpeed(10000000,UnsortedArrays.ARRAYS_SORT);
        //10000000 1st: 6secs 2td:7secs 3tr:7secs
        //30000000 18,19
        UnsortedArrays.testSpeed(50000000,UnsortedArrays.ARRAYS_PARALLEL_SORT);
        //30000000 3s
        //50000000 5s
    }
}
