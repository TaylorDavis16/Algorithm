package com.taylor.ArraySearching;

import java.util.Arrays;
//Failed
public class InsertionSearchNoRecur {

    public static void main(String[] args) {
        int[] ints={1,8,10,89,89,800,600,2000,14,15,15,1000,1000,1234};
        int[] ints2={1,2,3,3,4,5,5,6,6,7,7,8,9,10,11,11,12,13,14,14,14,15,16};
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
//        System.out.println(insertionSearch(ints,1));
//        System.out.println("-----------");
//        System.out.println(insertionSearch(ints,10));
//        System.out.println("-----------");
//        System.out.println(insertionSearch(ints,15));
//        System.out.println("-----------");
//        System.out.println(insertionSearch(ints,89));
//        System.out.println("-----------");
        System.out.println(insertionSearch(ints,160));
        System.out.println("-----------");
//        System.out.println(insertionSearch(ints,1600));
//        System.out.println("-----------");
//        System.out.println(insertionSearch(ints,2000));
    }
    
    public static int insertionSearch(int[] arr,int value){
        return insertionSearch(arr,0,arr.length-1,value);
    }
    public static int insertionSearch(int[] arr,int start,int end, int value){
        while (start<=end){
            int pivot=start+(end-start)*(value-arr[start])/(arr[end]-arr[start]);
            System.out.println("Pivot: "+pivot);
            if (arr[pivot]>value){
                end = pivot-1;
            }else if (arr[pivot]<value){
                start=pivot+1;
            }else {
                return pivot;
            }
        }
        return -1;
    }
}
