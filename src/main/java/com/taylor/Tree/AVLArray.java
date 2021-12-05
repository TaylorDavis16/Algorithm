package com.taylor.Tree;


import java.util.Arrays;

// failure
public class AVLArray {
    public static Integer[] avlArray;
    static int index;

    public static void main(String[] args) {
        Integer[] array={2,4,1,3,5,6,7};
        Integer[] array1={0,8,5,1,2,3,7,4,9};
        Integer[] array2={6,3,0,9,1,7,2,5};
        adjustArray(array2);
        System.out.println(Arrays.toString(avlArray));
    }
    public static void adjustArray(Integer[] array){
        avlArray=new Integer[array.length];
        Arrays.sort(array);
        binarySearch(array,0,array.length-1);
    }

    public static void binarySearch(Integer[] array, int start, int end){
        if (start<=end){
            int index=(start+end)/2;
            avlArray[AVLArray.index++]= array[index];
            binarySearch(array,start,index-1);
            binarySearch(array,index+1,end);
        }
    }
}
