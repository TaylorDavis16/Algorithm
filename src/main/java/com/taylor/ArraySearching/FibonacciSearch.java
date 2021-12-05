package com.taylor.ArraySearching;

import java.util.Arrays;

public class FibonacciSearch {
    private static int k=0;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFibonacciArray(20)));
        int[] ints={1,8,10,89,89,800,600,2000,14,15,15,1000,1000,1234};
        int[] ints2={1,2,3,3,4,5,5,6,6,7,7,8,9,10,11,11,12,13,14,14,14,15,16};
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
        System.out.println(fibonacciSearch(ints,0,ints.length-1,600));
        System.out.println(fibonacciSearch(ints2, 0, ints2.length - 1, 16));
    }

    public static int fibonacciSearch(int[] array,int start,int end,int value){
        int[] F=getFibonacciArray(20);
        while (end>F[k]-1){
            k++;
        }
        int[] temp = Arrays.copyOf(array, F[k]);
        for (int i=end+1;i<temp.length;i++){
            temp[i]=array[end];
        }
        while (start<=end){
            int mid=start+F[k-1]-1;
            if (value<temp[mid]){
                end=mid-1;
                k--;
            }
            else if (value>temp[mid]){
                start=mid+1;
                k-=2;
            }
            else {
                return Math.min(mid, end);
            }
        }
        return -1;
    }
    private static int[] getFibonacciArray(int n){
        int[] array=new int[n];
        array[0]=1;
        if (n==1){
            return array;
        }
        array[1]=1;
        for (int i=2;i<n;i++)
            array[i]=array[i-1]+array[i-2];
        return array;
    }
}
