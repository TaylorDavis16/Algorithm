package com.taylor.ArraySorting;
//Stable
public class BubbleSort {
    public static void main(String[] args) {
        bubbleSort(UnsortedArrays.integers);
        bubbleSort(UnsortedArrays.floats);
        bubbleSort(UnsortedArrays.doubles);
        bubbleSort(UnsortedArrays.strings);
        bubbleSort(UnsortedArrays.people);
        bubbleSort(UnsortedArrays.celebrities);
        UnsortedArrays.print();
        UnsortedArrays.testSpeed(6666,UnsortedArrays.BUBBLE_SORT);
        //1st:21secs 2td: 22secs 3tr:23secs
    }
    //It takes longer than selection and insertion, simply for there are too many exchanges
    public static <T extends Comparable<? super T>> void bubbleSort(T[] array){//Generic works for collection
        boolean flag;
        int time=0;
        for (int i=array.length-1;i>0;i--){
            flag=false;
            for (int j=0;j<i;j++){
                if (array[j].compareTo(array[j+1])>0){
                    T temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    flag=true;
                }
            }
            time++;
            if (!flag)
                break;
        }
        System.out.println(array.getClass()+": "+time+"!");
    }
}
