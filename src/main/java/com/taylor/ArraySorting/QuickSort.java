package com.taylor.ArraySorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
//        quickSort(UnsortedArrays.integers,0,UnsortedArrays.integers.length-1);
//        quickSort(UnsortedArrays.floats,0,UnsortedArrays.floats.length-1);
//        quickSort(UnsortedArrays.doubles,0,UnsortedArrays.doubles.length-1);
//        quickSort(UnsortedArrays.strings,0,UnsortedArrays.strings.length-1);
//        quickSort(UnsortedArrays.people,0,UnsortedArrays.people.length-1);
//        quickSort(UnsortedArrays.celebrities,0,UnsortedArrays.celebrities.length-1);
//        UnsortedArrays.print();
//        UnsortedArrays.testSpeed(30000000,UnsortedArrays.QUICK_SORT);
//        It only takes 5 seconds to sort 6666666 numbers, 6,7 secs to sort 10000000 numbers and 96 secs yo sort 66666666 numbers!
        System.out.println("----------------------------------------------------------------------");
//        quickSort2(UnsortedArrays.integers,0,UnsortedArrays.integers.length-1);
//        quickSort2(UnsortedArrays.floats,0,UnsortedArrays.floats.length-1);
//        quickSort2(UnsortedArrays.doubles,0,UnsortedArrays.doubles.length-1);
//        quickSort2(UnsortedArrays.strings,0,UnsortedArrays.strings.length-1);
//        quickSort2(UnsortedArrays.people,0,UnsortedArrays.people.length-1);
//        quickSort2(UnsortedArrays.celebrities,0,UnsortedArrays.celebrities.length-1);
//        UnsortedArrays.print();
        UnsortedArrays.testSpeed(30000,UnsortedArrays.QUICK_SORT);
        System.out.println(UnsortedArrays.testOrder(UnsortedArrays.sortedArray));
        Integer[] integers = {10, 2, 1, 7};
        quickSort2(integers,0,3);
        System.out.println(Arrays.toString(integers));
        //30000000,24 seconds new computer: 16
//        Integer[] array={1,78,23,90,54,44,58,23,16,12,7,2,3,6,67,4,0,31,13,8,66,22,11,79,64,58,720,33,99,66,21,14,17,89};
//        quickSort2(array,0,array.length-1);
//        System.out.println(Arrays.toString(array));
    }
    public static <T extends Comparable<? super T>> void quickSort(T[] array, int start, int end){
        T pivot=array[start];
        int l=start,r=end;
        while (l<r){//The nearest condition for going out this loop is l==r
            while (l<r && array[l].compareTo(pivot)<0){//Trying to find one greater than pivot, but it is possible that it equals pivot
                l++;//Actually, the l<r condition in here is redundant
            }
            while (l<r && array[r].compareTo(pivot)>0){//Trying to find one less than pivot, but it is possible that it equals pivot
                r--;//Actually, the l<r condition in here is redundant
            }
            if (l<r && array[l].compareTo(array[r])==0)//Find both(l<r) but unfortunately they have same value(array[l].compareTo(array[r])==0)
                l++;//Keep looking for them
                //If it enter else {}:
            else {//Case 1: Did not find anything(l==r), it will go out of the loop later
                  //Case 2: Find both (l<r but array[l]>array[r]), it will go back to the loop, continue to search
                  //×××Case 3: (Impossible) l==r but array[l].compareTo(array[r])>0
                if (l<r){//case 2
                    T temp=array[l];
                    array[l]=array[r];
                    array[r]=temp;
                }

            }
        }//At this time, l and r are in a very delicate situation, because l=r
        //Imagine a extreme condition, the array's length is 1, then l=r=0. Don't forget that start and end are the range
        //of this array that need to be sorted! No matter what, start from 'start' and end at 'end'
        //              new range   l r  new range  l=r=4
        //For example: [2  5  4  3]  6  [8  7  9] start=0, end=7
        //If(l-1>start){there are more then one element in its left} If(r+1<end){there are more then one element in its right}
        //When it ready to get into recursion again, the value of the pivot will be neglected
        //Before it go, it should check the new array's length, if the length is 1, then do not need to sort
        if (l-1>start)
            quickSort(array,start,l-1);
        if (r+1<end)
            quickSort(array,r+1,end);
    }
    //This version is not that efficient as the first one(Maybe is emotional, I don't know)
    public static <T extends Comparable<? super T>> void quickSort2(T[] array, int start, int end){
        int mid = (start+end)/2;
        T pivot=array[mid];
        int i=start;
        int j=end;
        while (i<j){
            while (array[i].compareTo(pivot)<0){
                i++;
            }
            while (array[j].compareTo(pivot)>0){
                j--;
            }
            if (i==j){//i==j说明找不到了，否则必是i<j的两种情况
                break;
            }
            else if (array[i].compareTo(array[j])==0) {//i<j,值相同，没必要交换
                i++;
            }
            else {
                T temp=array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }
        if (i-1>start)
            quickSort2(array,start,i-1);
        if (j+1<end)
            quickSort2(array,j+1,end);
    }

    //Failed, never used!
    public static <T extends Comparable<? super T>> void parallelQuickSort(T[] array, int start, int end){
        Thread sortThread = new Thread(() -> parallelQuickSort0(array, start, end));
        sortThread.start();
        try {
            sortThread.join();
            System.out.println("End");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //Failed, never used!
    private static <T extends Comparable<? super T>> void parallelQuickSort0(T[] array, int start, int end){
        int mid = (start+end)/2;
        T pivot=array[mid];
        int i=start;
        int j=end;
        while (i<j){
            while (array[i].compareTo(pivot)<0){
//                if (i==j) break;
                i++;
            }
            while (array[j].compareTo(pivot)>0){
//                if (i==j) break;
                j--;
            }
            if (i==j){//i==j说明找不到了，否则必是i<j的两种情况
                break;
            }
            else if (array[i].compareTo(array[j])==0) {//i<j,值相同，没必要交换
                i++;
            }
            else {
                T temp=array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }
        Thread t1=null;
        Thread t2=null;
        if (i-1>start) {
            int finalI = i;
            t1 = new Thread(() -> parallelQuickSort0(array, start, finalI - 1));
            t1.start();
        }
            
        if (j+1<end) {
            int finalJ = j;
            t2 = new Thread(() -> parallelQuickSort0(array, finalJ + 1, end));
            t2.start();
        }
        if (t1!=null){
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (t2!=null){
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
