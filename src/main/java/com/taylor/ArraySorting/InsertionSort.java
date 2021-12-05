package com.taylor.ArraySorting;

import java.util.Arrays;

public class InsertionSort {
    private static int time=0;
    public static void main(String[] args) {
//        insertionSort(UnsortedArrays.integers);
//        insertionSort(UnsortedArrays.floats);
//        insertionSort(UnsortedArrays.doubles);
//        insertionSort(UnsortedArrays.strings);
//        insertionSort(UnsortedArrays.people);
//        insertionSort(UnsortedArrays.celebrities);
//        UnsortedArrays.print();
//        UnsortedArrays.testSpeed(66666,UnsortedArrays.INSERTION_SORT4);
//        UnsortedArrays.testSpeed(66666,UnsortedArrays.INSERTION_SORT);
//        System.out.println(UnsortedArrays.testOrder(UnsortedArrays.sortedArray));
        Integer[] array={1,78,23,90,54,44,58,23,16,12,7,2,3,6,67,4,0,31,13,8,66,22,11,79,64,58,720,33,99,66,21,14,17,89};
//        Integer[] array2={1,2,3,4,5,6,7,8,10,12,14,16,10};
//        Integer[] array3={1,78,23};
//        insertionSort4(array);
        insertionSort(array);
        System.out.println(Arrays.toString(array));

        
        //1st:3secs 2td: 2secs 3tr:3secs
        //Improved version: To test if it is necessary to compare the previous array
        //See if the adjustment will be beneficial for a sorting for 200000
        //Previous version:1st:21secs 2td:20secs 3tr: 21secs
        //Adjusted version:1st:20secs 2td:21secs 3tr: 20secs
        //So it does not that fascinating at all!
    }
    //j grows from 0 to i, which is favorable for the scenario that it is completely a inverted sequence
    //However, if the sequence is perfect, it still have to go on searching for many times
    //Although you choose to decline j from i-1 to 0, it still has to go over the previous part of
    // array to find out the smallest
    public static <T extends Comparable<? super T>> void insertionSort(T[] array){
        for (int i=1;i<array.length;i++){
//            if (array[i].compareTo(array[i-1])>0)
//                continue;
//            time++;
            for (int j=0;j<i;j++){
                if (array[i].compareTo(array[j])<0){
                    T temp=array[i];
                    System.arraycopy(array,j,array,j+1,i-j);
//                    for (int k=i;k>j;k--){
//                        array[k]=array[k-1];
//                    }
                    array[j]=temp;
                    break;
                }
            }
        }
    }

    //最垃圾的版本,没有arraycopy的copy优化
    public static <T extends Comparable<? super T>> void insertionSort2(T[] array){
        for (int i=1;i<array.length;i++){
            T temp=array[i];
            for (int j=i;j>0;j--){
                if (temp.compareTo(array[j-1])<0){
                    array[j]=array[j-1];
                }
                else{
                    array[j]=temp;
                    break;
                }
            }
        }
    }

    //Performance does not improved very much for a random array
    //根据数据经验进行调整，如果数组只是倾向于个别无序，则性能有很大提升
    //否则一般情况下，和第一种方式差不多
    //在最坏情况下，第一种有可以忽略的略微优势
    public static <T extends Comparable<? super T>> void insertionSort3(T[] array){
        for (int i=1;i<array.length;i++) {
            if (array[i].compareTo(array[i - 1]) < 0) {
                for (int j = 0; j < i; j++) {
                    if (array[i].compareTo(array[j]) < 0) {
                        T temp = array[i];
                        System.arraycopy(array, j, array, j + 1, i - j);
                        array[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    //运用了二分法进行查找，相比3来说性能有非常大的提高
    //因为二分查找效率极高，因此没有必要初始判断邻位元素是否小于待插入元素
    public static <T extends Comparable<? super T>> void insertionSort4(T[] array){
        for (int i=1;i<array.length;i++) {
            int index=findIndex(array,array[i],i-1);
            T temp=array[i];
            System.arraycopy(array, index, array, index + 1, i - index);
            array[index]=temp;
        }
    }
    
    public static <T extends Comparable<? super T>> int findIndex(T[] array, T value, int high){
        int low=0;
        while (low<=high){
            int middle=(low+high)/2;
            if (array[middle].compareTo(value)<=0){
                low=middle+1;
            }
            else {
                high=middle-1;
            }
        }
        return high+1;//low 和 high+1都可
    }
}
