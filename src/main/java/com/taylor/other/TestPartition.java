package com.taylor.other;

import java.util.Arrays;

public class TestPartition {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4},8)));
    }
    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        partition(arr, k, 0, arr.length - 1);
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    private static void partition(int[] arr, int k, int i, int j){
        int pivot = arr[i + ((j - i) >> 1)];
        int start = i, end = j;
        while(start < end){
            while(arr[start] < pivot) start++;
            while(arr[end] > pivot) end--;
            if(start == end) break;
            else if(arr[start] == arr[end]) start++;
            else {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        if(start == k) return;
        if(start < k) partition(arr, k, start + 1, j);
        else partition(arr, k, i, start - 1);
    }
}
