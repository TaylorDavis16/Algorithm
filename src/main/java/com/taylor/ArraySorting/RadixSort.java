package com.taylor.ArraySorting;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        Integer[] array={1,78,23,90,54,44,58,23,16,12,7,2,3,6,67,4,0,31,13,8,66,22,11,79,64,58,720,33,99,66,21,14,17,89};
        radixSort(array);
        System.out.println(Arrays.toString(array));
        UnsortedArrays.testSpeed(50000000,UnsortedArrays.RADIX_SORT);
        System.out.println(UnsortedArrays.testOrder(UnsortedArrays.sortedArray));
        //30000000,19,18,18seconds!
        //30000000,5seconds!
        //50000000,12seconds!
    }

    public static void radixSort(Integer[] array) {
        int[][] bucket=new int[10][array.length];
        int[] count=new int[10];
        int range= getDataRange(array);
        for (int i=1;i<=range;i*=10){
            for (Integer integer : array) {
                int digit = integer / i % 10;
                bucket[digit][count[digit]++] = integer;
            }
            int index=0;
            for (int j=0;j<10;j++){
                for (int k=0;k<count[j];k++)
                    array[index++]=bucket[j][k];
                count[j]=0;//Clear the count array so it can count next time
            }
        }
    }

    /**
     * Find the biggest number in the array
     * @param array the array
     * @return the biggest number
     */
    private static int getDataRange(Integer[] array){
        int value=array[0];
        for (int item : array) {
            if (value < item)
                value = item;
        }
        return (int) Math.pow(10,(value+"").length());
    }
}
