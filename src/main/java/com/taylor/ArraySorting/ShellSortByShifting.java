package com.taylor.ArraySorting;

public class ShellSortByShifting {
    public static void main(String[] args) {
        shellsSort(UnsortedArrays.integers);
        shellsSort(UnsortedArrays.floats);
        shellsSort(UnsortedArrays.doubles);
        shellsSort(UnsortedArrays.strings);
        shellsSort(UnsortedArrays.people);
        shellsSort(UnsortedArrays.celebrities);
        UnsortedArrays.print();
        UnsortedArrays.testSpeed(666666,UnsortedArrays.SHELLS_SORT_SHIFTING);
        //It only takes 20 seconds to sort 6666666 numbers!
        //1st: <1secs 2td:1secs 3tr:1secs
    }
    public static <T extends Comparable<? super T>> void shellsSort(T[] array){
        int span=array.length>>1;
        while (span>0){
            for (int i=span;i<array.length;i++){//Each time, starting from the span
                T temp=array[i];
                int j;//Keep the former value of i
                for (j=i;j-span>=0 && array[j-span].compareTo(temp)>0;j-=span){
                    array[j]=array[j-span];
                }
                array[j]=temp;
            }
            span>>=1;
        }
    }
    
    
}
