package com.taylor.ArraySorting;

public class ShellsSortByExchanging {
    public static void main(String[] args) {
        shellsSort(UnsortedArrays.integers);
        shellsSort(UnsortedArrays.floats);
        shellsSort(UnsortedArrays.doubles);
        shellsSort(UnsortedArrays.strings);
        shellsSort(UnsortedArrays.people);
        shellsSort(UnsortedArrays.celebrities);
        UnsortedArrays.print();
        UnsortedArrays.testSpeed(66666,UnsortedArrays.SHELLS_SORT_EXCHANGE);
        //1st: 24secs 2td:40secs 3tr:38secs
    }
    public static <T extends Comparable<? super T>> void shellsSort(T[] array){
        int span=array.length/2;
        while (span>0){
            for (int i=span;i<array.length;i++){
                for (int j=i-span;j>=0;j-=span){
                    if (array[j].compareTo(array[j+span])>0){
                        T temp=array[j];
                        array[j]=array[j+span];
                        array[j+span]=temp;
                    }
                }
            }
            span/=2;
        }
    }
}
