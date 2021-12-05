package com.taylor.ArraySorting;

import java.util.Arrays;

public class MergeSortIntArray {
    public static void main(String[] args) {
        int[] integers={503,87,512,61,908,170,897,275,653,462};
        int[] array={1,78,23,90,54,44,58,23,16,12,7,2,3,6,67,4,0,31,13,8,66,22,11,79,64,58,720,33,99,66,21,14,17,89};
        mergeSort(integers);
        System.out.println(Arrays.toString(integers));
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void mergeSort(int[] array) {
        if (array != null && array.length > 1) {
            int[] temp = new int[array.length];
            divideThenSort(array, 0, array.length - 1, temp);
        }
    }

    public static void divideThenSort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            divideThenSort(array, left, mid, temp);
            divideThenSort(array, mid + 1, right, temp);
            merge(array, left, mid, right, temp);
        }
    }

    public static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }
//        while (i<=mid) temp[k++]=array[i++];
        if (i<=mid) System.arraycopy(array,i,temp,k,mid-i+1);
//        while (j<=right) temp[k++]=array[j++];
        if (j<=right) System.arraycopy(array,j,temp,k,right-j+1);
        System.arraycopy(temp,0,array,left,right-left+1);
    }
}
