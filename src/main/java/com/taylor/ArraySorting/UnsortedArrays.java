package com.taylor.ArraySorting;



import com.taylor.LinkedList.Entity.Celebrity;
import com.taylor.LinkedList.Entity.People;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
@Slf4j(topic = "c.UnsortedArrays")
public class UnsortedArrays {
    public final static int BUBBLE_SORT=1;
    public final static int SELECTION_SORT=2;
    public final static int INSERTION_SORT=3;
    public final static int INSERTION_SORT2=4;
    public final static int INSERTION_SORT3=5;
    public final static int INSERTION_SORT4=6;
    public final static int SHELLS_SORT_EXCHANGE=7;
    public final static int SHELLS_SORT_SHIFTING=8;
    public final static int QUICK_SORT=9;
    public final static int QUICK_SORT_MY_VERSION=10;
    public final static int QUICK_SORT_PARALLEL=11;
    public final static int MERGE_SORT=12;
    public final static int RADIX_SORT=13;
    public final static int HEAP_SORT=14;
    public final static int HEAP_SORT2=15;
    public final static int ARRAYS_SORT=16;
    public final static int ARRAYS_PARALLEL_SORT=17;
    public static Integer[] integers={1,78,23,90,54,44,58,23,16,12};
    public static Float[] floats={1.3f,4.7f,2.5f,687f,23.6f,16.0f,234.004f,4.3f,77.09f};
    public static Double[] doubles={1.2,2.4,1.4,7.8,3.9,16.0,5.6,0.7};
    public static String[] strings={"sad","happy","funny","terrific","creepy","floppy","crappy","lousy"};
    public static People person1=new People(1,3,"A");
    public static People person2=new People(3,2,"C");
    public static People person3=new People(2,2,"B");
    public static People person4=new People(8,2,"D");
    public static People person5=new People(6,2,"F");
    public static People person6=new People(3,2,"E");
    public static People person7=new People(2,16,"B");
    public static People person8=new People(4,4,"E");
    public static People[] people={person1,person2,person3,person4,person5,person6,person7,person8};
    public static Celebrity Taylor=new Celebrity(13,30,"Taylor Swift","TayTay");
    public static Celebrity Selena=new Celebrity(8,27,"Selena Gomez","傻脸娜");
    public static Celebrity Mariah=new Celebrity(9,39,"Mariah Carey","E=MC2");
    public static Celebrity Katy=new Celebrity(1,17,"Katy Perry","Fruit Sister");
    public static Celebrity Ariana=new Celebrity(4,37,"Ariana Grande","A Sister");
    public static Celebrity Britney=new Celebrity(2,45,"Britney Spears","sweetie");
    public static Celebrity Donald=new Celebrity(46,70,"Donald Trump","donald");
    public static Celebrity Hilary=new Celebrity(38,66,"Hilary Clinton","hilary");
    public static Celebrity[] celebrities={Taylor,Selena,Mariah,Katy,Ariana,Britney,Donald,Hilary};
    public static Integer[] sortedArray;

    public static void main(String[] args) {
        log.debug("{}",person1.compareTo(person2));
        log.debug("{}",Taylor.compareTo(Selena));
        log.debug("{}",person3.compareTo(Donald));
    }

    public static void print(){
        System.out.println(Arrays.toString(UnsortedArrays.integers));
        System.out.println(Arrays.toString(UnsortedArrays.floats));
        System.out.println(Arrays.toString(UnsortedArrays.doubles));
        System.out.println(Arrays.toString(UnsortedArrays.strings));
        System.out.println("---------------------------------------");
        for (People person : UnsortedArrays.people) {
            log.debug("{}",person);
        }
        System.out.println("---------------------------------------");
        for (Celebrity celebrity : UnsortedArrays.celebrities) {
            log.debug("{}",celebrity);
        }
        System.out.println("---------------------------------------");
    }

    public static void testSpeed(int number, int type){
        if (number<=1000){
            log.debug("This number is too small to test, which is senseless!");
            return;
        }
        Random random=new Random(System.currentTimeMillis());
        Integer[] randomArray=new Integer[number];
        //When you assign values for wrapper class array, you cannot using foreach, because each one of them is null
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i]=random.nextInt(number);
        }
        log.debug("Start:");
        long start = System.currentTimeMillis();
        selectTypeThenSort(type, randomArray);
        long end = System.currentTimeMillis();
        sortedArray=randomArray;
        log.debug("Finish:");
        log.debug("Take {} millis secs",(end-start));
        for (int i=0;i<20;i++){
            System.out.print(randomArray[i]+" ");
        }
        System.out.println("........");
        System.out.println(testOrder(randomArray));
    }
    
    public static void testSortedArray(int type){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String start = format.format(new Date());
        log.debug("Start: {}",start);
        selectTypeThenSort(type, sortedArray);
        String end = format.format(new Date());
        log.debug("End: {}",end);
        for (int i=0;i<20;i++){
            System.out.print(sortedArray[i]+" ");
        }
        log.debug("........");
    }
    
    public static <T extends Comparable<? super T>> boolean testOrder(T[] array){
        for (int i=1;i<array.length;i++){
            if (array[i-1].compareTo(array[i])>0){
                log.debug("Wrong order at {}",(i-1));
                return false;
            }
        }
        return true;
    }

    private static void selectTypeThenSort(int type, Integer[] array) {
        switch (type){
            case BUBBLE_SORT: BubbleSort.bubbleSort(array);
                break;
            case SELECTION_SORT: SelectionSort.selectSort(array);
                break;
            case INSERTION_SORT: InsertionSort.insertionSort(array);
                break;
            case INSERTION_SORT2: InsertionSort.insertionSort2(array);
                break;
            case INSERTION_SORT3: InsertionSort.insertionSort3(array);
                break;
            case INSERTION_SORT4: InsertionSort.insertionSort4(array);
                break;
            case SHELLS_SORT_EXCHANGE: ShellsSortByExchanging.shellsSort(array);
                break;
            case SHELLS_SORT_SHIFTING: ShellSortByShifting.shellsSort(array);
                break;
            case QUICK_SORT: QuickSort.quickSort(array,0, array.length-1);
                break;
            case QUICK_SORT_MY_VERSION: QuickSort.quickSort2(array,0, array.length-1);
                break;
            case QUICK_SORT_PARALLEL: QuickSort.parallelQuickSort(array,0, array.length-1);
                break;
            case MERGE_SORT: MergeSort.mergeSort(array,0, array.length-1);
                break;
            case RADIX_SORT: RadixSort.radixSort(array);
                break;
            case HEAP_SORT: HeapSort.heapSort(array);
                break;
            case HEAP_SORT2: HeapSort2.heapSort(array);
                break;
            case ARRAYS_SORT: Arrays.sort(array);
                break;
            case ARRAYS_PARALLEL_SORT: Arrays.parallelSort(array);
                break;
            default:
                log.debug("Input is invalid!");
        }
    }
}
