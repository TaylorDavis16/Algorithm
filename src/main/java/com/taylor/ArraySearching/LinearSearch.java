package com.taylor.ArraySearching;


import com.taylor.ArraySorting.UnsortedArrays;

public class LinearSearch {
    public static void main(String[] args) {
        System.out.println(linearSearch(UnsortedArrays.celebrities, UnsortedArrays.Katy));
        System.out.println(linearSearch(UnsortedArrays.integers, 24));
        System.out.println(linearSearch(UnsortedArrays.integers, 12));
    }
    public static <T extends Comparable<T>> int linearSearch(T[] array, T value){
        for (int i=0;i<array.length;i++) {
            if (array[i].compareTo(value)==0)
                return i;
        }
        return -1;
    }
}
