package com.taylor.ArraySorting;

import java.util.Arrays;

public class MergeSort {
    private static int time = 0;

    public static void main(String[] args) {

        Integer[] integers = {503, 87, 512, 61, 908, 170, 897, 275, 653, 462};
        System.out.println(UnsortedArrays.testOrder(integers));
        mergeSort(integers, 0, integers.length - 1);
        System.out.println(Arrays.toString(integers));
        System.out.println(UnsortedArrays.testOrder(integers));
        System.out.println(time);
//        mergeSort(UnsortedArrays.integers,0,UnsortedArrays.integers.length-1);
//        mergeSort(UnsortedArrays.floats,0,UnsortedArrays.floats.length-1);
//        mergeSort(UnsortedArrays.doubles,0,UnsortedArrays.doubles.length-1);
//        mergeSort(UnsortedArrays.strings,0,UnsortedArrays.strings.length-1);
//        mergeSort(UnsortedArrays.people,0,UnsortedArrays.people.length-1);
//        mergeSort(UnsortedArrays.celebrities,0,UnsortedArrays.celebrities.length-1);
//        UnsortedArrays.print();
        UnsortedArrays.testSpeed(30000000, UnsortedArrays.MERGE_SORT);
        //30000000, 22secs
    }

    @SuppressWarnings("all")
    public static <T extends Comparable<? super T>> void mergeSort(T[] array, int start, int end) {
        if (array.length > 1) {
            T[] temp = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), array.length);
            divideThenSort(array, start, end, temp);
        }
    }

    private static <T extends Comparable<? super T>> void divideThenSort(T[] array, int left, int right, T[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            divideThenSort(array, left, mid, temp);
            divideThenSort(array, mid + 1, right, temp);
            sortAndMerge(array, left, mid, right, temp);
        }
    }

    private static <T extends Comparable<? super T>> void sortAndMerge(T[] array, int left, int mid, int right, T[] temp) {
        int i = left, j = mid + 1, t = 0;
        //Take values to temporary array by order
        while (i <= mid && j <= right) {
//            System.out.println(Arrays.toString(array));
            if (array[i].compareTo(array[j]) <= 0) {
                temp[t++] = array[i++];
            } else temp[t++] = array[j++];
        }
        //Take the rest of the value into temporary array
//        if (i<=mid) System.arraycopy(array,i,temp,t,mid-i+1);
        while (i <= mid) {
            temp[t++] = array[i++];
        }
//        if (j<=right) System.arraycopy(array,j,temp,t,right-j+1);
        while (j <= right) {
            temp[t++] = array[j++];
        }
        //Copy the value back from temp
        //But it is not that simple, because temp is refreshing, which mean it is being reuse over and over again!
        //And you do not need to copy all of the values from temp, handle your range is ok
//        for (int k=0;left<=right;left++,k++){
//            array[left]=temp[k];
//        }
//        System.out.println("temp: "+Arrays.toString(temp));
        System.arraycopy(temp, 0, array, left, right - left + 1);
//        time++;
//        System.out.println(time+": "+Arrays.toString(array));
    }


    private static <T extends Comparable<? super T>> void sortAndMerge2(T[] array, int start, int mid, int end, T[] temp) {
        int left = start, right = mid + 1, k = 0;
        while (left <= mid && right <= end) {
            temp[k++] = array[left].compareTo(array[right]) <= 0 ? array[left++] : array[right++];
        }
        if (left <= mid) System.arraycopy(array, left, temp, k, mid - left + 1);
        if (right <= end) System.arraycopy(array, right, temp, k, end - right + 1);
        System.arraycopy(temp, 0, array, start, end - start + 1);
    }

}
