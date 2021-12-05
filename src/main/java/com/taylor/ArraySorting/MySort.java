package com.taylor.ArraySorting;

//It is a failure lol! It since I forget the concept of Shell sorting! Quiet funny
public class MySort {
    private static boolean lastSort=false;
    public static void main(String[] args) {
//        mySort(UnsortedArrays.integers);
//        mySort(UnsortedArrays.floats);
//        mySort(UnsortedArrays.doubles);
//        mySort(UnsortedArrays.strings);
//        mySort(UnsortedArrays.people);
//        mySort(UnsortedArrays.celebrities);
//        UnsortedArrays.print();
//        UnsortedArrays.testSpeed(66666,UnsortedArrays.MY_SORT);
    }

    public static <T extends Comparable<? super T>> void mySort(T[] array){
        int start=0;
        int length=array.length;
        recursiveSort(array,start,length);
    }

    private static <T extends Comparable<? super T>> void recursiveSort(T[] array,int start, int length){
        int span=length/2;
        if (span!=1) {
            recursiveSort(array, start, span);
            recursiveSort(array, span, length - span);
        }
        System.out.println("Start: "+start+"  Length: "+length);
    }

    private static <T extends Comparable<? super T>> void sortDivided(T[] array,int start, int i) {
        for (int j=start;j<i;j++){
            if (array[i].compareTo(array[j])<0){
                T temp=array[i];
                System.arraycopy(array,j,array,j+1,i-j);
                array[j]=temp;
                break;
            }
        }
    }
}
