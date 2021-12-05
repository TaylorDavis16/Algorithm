package com.taylor.ArraySorting;

import java.util.Arrays;

public class HeapSort2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(UnsortedArrays.integers));
//        heapify(UnsortedArrays.integers,0);
//        buildHeap(UnsortedArrays.integers);
        heapSort(UnsortedArrays.integers);
        heapSort(UnsortedArrays.floats);
        heapSort(UnsortedArrays.doubles);
        heapSort(UnsortedArrays.strings);
        heapSort(UnsortedArrays.people);
        heapSort(UnsortedArrays.celebrities);
        UnsortedArrays.print();
        UnsortedArrays.testSpeed(6666666,UnsortedArrays.HEAP_SORT2);
        System.out.println(UnsortedArrays.testOrder(UnsortedArrays.sortedArray));
    }

    /**
     * If one of the child meet the requirements to swap and recur
     * It just go down following that child to heapify
     * It does not recur back to check other child (nodes)
     * @param array Array needed to be heapify
     * @param rootIndex the index of the root
     * @param <T> type
     */
    public static <T extends Comparable<T>> void heapify(T[] array,int rootIndex,int number){
        if (rootIndex<number){
            int l=rootIndex*2+1;
            int r=rootIndex*2+2;
            int root=rootIndex;
            if (l<number && array[root].compareTo(array[l])<0){
                root=l;
            }
            if (r<number && array[root].compareTo(array[r])<0){
                root=r;
            }
            if (root!=rootIndex){
                swap(array,rootIndex,root);
                heapify(array,root,number);
            }
        }
    }
    
    public static <T> void swap(T[] array,int i,int j){
        T temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    /**
     * heapify nodes from the last parents to root
     * @param array array
     * @param <T> type
     */
    public static <T extends Comparable<T>> void buildHeap(T[] array){
        int lastIndex=array.length-1;
        int parents=(lastIndex-1)/2;
        for (int i=parents;i>=0;i--){
            heapify(array,i,array.length);
        }
    }

    /**
     * Swap, then heapify partially, for the rest of the array is ordered
     * For there are only one elements change, so only one heapify is needed
     * @param array array
     * @param <T> type
     */
    public static <T extends Comparable<T>> void heapSort(T[] array){
        buildHeap(array);
        for (int i=array.length-1;i>=0;i--){
            //Putting the biggest number in tail
            swap(array,i,0);
            //Ordered array are ignored
            heapify(array,0,i);
        }
    }
}
