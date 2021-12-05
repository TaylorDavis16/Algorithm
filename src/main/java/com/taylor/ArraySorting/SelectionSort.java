package com.taylor.ArraySorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
//        selectSort(UnsortedArrays.integers);
//        selectSort(UnsortedArrays.floats);
//        selectSort(UnsortedArrays.doubles);
//        selectSort(UnsortedArrays.strings);
//        selectSort(UnsortedArrays.people);
//        selectSort(UnsortedArrays.celebrities);
//        UnsortedArrays.print();
//        UnsortedArrays.testSpeed(66666,UnsortedArrays.SELECTION_SORT);
        //1st: 18secs 2td:18secs 3tr:18secs
        //↑↑It is not testing under the real sorting process, because it was coming undone↑↑
        //1st: 6secs 2td:5secs 3tr:6secs

        Integer[] array={1,22,11,79,64,58,89,33,99,66,21,14,17,720};
        Integer[] array2={8,2,4,5,7,1,3,6};
        dualSelectSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(UnsortedArrays.testOrder(array));
    }

    public static <T extends Comparable<? super T>> void selectSort(T[] array){
        for (int i=0;i<array.length-1;i++){
            int detector=i;
            for (int j=i+1;j<array.length;j++){
                if (array[detector].compareTo(array[j])>0){
                    detector=j;
                }
            }
            T temp=array[i];
            array[i]=array[detector];
            array[detector]=temp;
        }
    }

    public static <T extends Comparable<? super T>> void dualSelectSortEven(T[] array){
        for (int i=0;i<array.length;i++){
            int start=i;
            int end=array.length-i-1;
            if (start<end){
                break;
            }
            for (int j=i+1;j<array.length-i-1;j++){
                if (array[start].compareTo(array[j])>0){
                    start=j;
                }
                if (array[end].compareTo(array[j])<0){
                    end=j;
                }
            }

            if (start!=i){
                T temp=array[i];
                array[i]=array[start];
                array[start]=temp;
            }
            if (end!=array.length-i-1){
                T temp=array[array.length-i-1];
                array[array.length-i-1]=array[end];
                array[end]=temp;
            }
        }
    }
    public static <T extends Comparable<? super T>> void dualSelectSort(T[] array){
        
        for (int i=0;i<array.length;i++){
            int start=i;
            int end=array.length-i-1;
            if (start>=end){
                break;
            }
            System.out.println(start+" "+end);
            for (int j=i+1;j<array.length-i-1;j++){
                if (array[start].compareTo(array[j])>0){
                    start=j;
                }
                if (array[end].compareTo(array[j])<0){
                    end=j;
                }
            }
            
            if (start!=i){
                T temp=array[i];
                array[i]=array[start];
                array[start]=temp;
            }
            if (end!=array.length-i-1){
                T temp=array[array.length-i-1];
                array[array.length-i-1]=array[end];
                array[end]=temp;
            }
        }
        
    }
}
