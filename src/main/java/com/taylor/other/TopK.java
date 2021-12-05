package com.taylor.other;

import java.util.Arrays;

public class TopK {
    static void findKMax(int[] arr, int left, int right, int k) {
        int temp = partition(arr, left, right);
        if (temp == k - 1) {
            System.out.println(arr[temp]);
        } else if (temp > k - 1) {
            findKMax(arr, left, temp - 1, k);
        } else {
            findKMax(arr, temp + 1, right, k - temp);
        }
    }

    static int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        while (left < right) {
            while (temp >= arr[right] && left < right) --right;
            arr[left] = arr[right];
            while (temp <= arr[left] && left < right) ++left;
            arr[right] = arr[left];
        }

        arr[right] = temp;
        return right;
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 12, 23, 2, 3, 2, 432, 43, 534, 5, 345, 3453, 53, 43 };
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        findKMax(arr,0,arr.length - 1,4  );
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
