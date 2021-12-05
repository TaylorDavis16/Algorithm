package com.taylor.Test;


import com.taylor.ArraySorting.UnsortedArrays;

public class TestInsertionSort {
    public static void main(String[] args) {
//        UnsortedArrays.testSpeed(100000,UnsortedArrays.INSERTION_SORT);
//        UnsortedArrays.testSortedArray(UnsortedArrays.INSERTION_SORT);
        UnsortedArrays.testSpeed(200000,UnsortedArrays.INSERTION_SORT3);
        UnsortedArrays.testSortedArray(UnsortedArrays.INSERTION_SORT3);
    }
}
