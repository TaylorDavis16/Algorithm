package com.taylor.ArraySearching.Test;



import com.taylor.ArraySearching.BinarySearch;
import com.taylor.ArraySorting.UnsortedArrays;
import com.taylor.LinkedList.Entity.Celebrity;

import java.util.Arrays;

public class BinarySearchTest {
    public static void main(String[] args) {
        Integer[] integers= UnsortedArrays.integers;
        Integer[] integers1={1,8,10,89,89,800,600,2000,14,15,15,1000,1000,1234};
        Celebrity[] celebrities=UnsortedArrays.celebrities;
        Arrays.sort(celebrities);
        Arrays.sort(integers);
        BinarySearch<Integer> integerBinarySearch=new BinarySearch<>(integers);
        BinarySearch<Celebrity> celebrityBinarySearch=new BinarySearch<>(celebrities);
        BinarySearch<Integer> integerBinarySearch1=new BinarySearch<>();
        Arrays.sort(integers1);
        integerBinarySearch1.setArray(integers1);
        System.out.println(Arrays.toString(integers1));
        System.out.println(integerBinarySearch.binarySearch(integers,0, integers.length-1,1));
        System.out.println(integerBinarySearch.binarySearch(integers,0,integers.length-1,12));
        System.out.println(integerBinarySearch.binarySearch(integers,0,integers.length-1,16));
        System.out.println(integerBinarySearch.binarySearch(integers,0,integers.length-1,23));
        System.out.println(integerBinarySearch.binarySearch(integers,0,integers.length-1,44));
        System.out.println(integerBinarySearch.binarySearch(integers,0,integers.length-1,54));
        System.out.println(integerBinarySearch.binarySearch(integers,0,integers.length-1,58));
        System.out.println(integerBinarySearch.binarySearch(integers,0,integers.length-1,78));
        System.out.println(integerBinarySearch.binarySearch(integers,0,integers.length-1,90));
        System.out.println(integerBinarySearch.binarySearch(integers1,0,integers1.length-1,1000));
        celebrityBinarySearch.binarySearchAll(0, celebrities.length, UnsortedArrays.Katy);
        celebrityBinarySearch.getMap().forEach((id,value)-> System.out.println("["+id+", "+value+"]"));
        integerBinarySearch.binarySearchAll(0, integers.length - 1, 23);
        System.out.println(integerBinarySearch.getMap());
        integerBinarySearch1.binarySearchAll(0, integers1.length - 1, 1000);
        System.out.println(integerBinarySearch1.getMap());
        integerBinarySearch1.binarySearchAll(0, integers1.length - 1, 15);
        System.out.println(integerBinarySearch1.getMap());
        integerBinarySearch1.setSaveResult(false);
        integerBinarySearch1.binarySearchAll(0, integers1.length - 1, 89);
        System.out.println(integerBinarySearch1.getMap());
        integerBinarySearch1.binarySearchAll(0, integers1.length - 1, 800);
        System.out.println(integerBinarySearch1.getMap());


    }
}
