package com.taylor.ArraySearching;

import java.util.Arrays;

public class ArrayMethod {
    private static Integer[] arr1;
    public static void main(String[] args) {
        arr1 = new Integer[9];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i;
        }
        show(arr1);
        reverse(arr1);
        show(arr1);
        
    }

    public static <T> void reverse(T[] array) {
        for (int i = 0; i < array.length/2; i++) {
            T temp = array[i];
            array[i]=array[array.length-i-1];
            array[array.length-i-1] = temp;
        }
    }
    
    public static <T> void show(T[] array){
        System.out.println(Arrays.toString(array));
    }
    
}
