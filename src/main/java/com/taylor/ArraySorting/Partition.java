package com.taylor.ArraySorting;

import java.util.Arrays;

public class Partition {
    public static int[] ints={1,78,23,90,54,44,58,23,16,23};
    public static int[] colors={2,0,2,1,1,0};
    public static int[] colors2={1,4,2,5,7,2,3,8,12,23,43,564,78,23,90,54,1,33,55,66,2,0,1,44,58,23,16,23};
    public static int[] colors3={1,2};
    public static void main(String[] args) {
//        partition(ints,0,ints.length-1,30);
        partition2(ints,0,ints.length-1,17);
        partition2(colors,0,colors.length-1,1);
        partition(colors2,0,colors2.length-1,3);
    }
    public static void partition(int[] array,int l,int r,int num){
        int less=l;
        int more=r;
        int cur=0;
        while (cur<=more){
            if (array[cur]<num){
                swap(array,cur++,less++);
            }
            else if (array[cur]>num){
                swap(array,cur,more--);
            }
            else cur++;
        }
        System.out.println(Arrays.toString(array));
    }
    
    //单纯是将数组分开,失败
    public static void partition2(int[] array,int l,int r,int num){
        int i=l;
        while (i<=r){
            if (array[i]<=num){
                i++;
            }
            else swap(array,i,r--);
        }
        System.out.println(Arrays.toString(array));
    }

    public static void swap(int[] array,int i, int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
