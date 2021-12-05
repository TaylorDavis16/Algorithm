package com.taylor.ArraySorting;

public class HeapSort {
    public static void main(String[] args) {
        heapSort(UnsortedArrays.integers);
        heapSort(UnsortedArrays.floats);
        heapSort(UnsortedArrays.doubles);
        heapSort(UnsortedArrays.strings);
        heapSort(UnsortedArrays.people);
        heapSort(UnsortedArrays.celebrities);
        UnsortedArrays.print();
        UnsortedArrays.testSpeed(6666666,UnsortedArrays.HEAP_SORT);
        System.out.println(UnsortedArrays.testOrder(UnsortedArrays.sortedArray));
    }

    public static <T extends Comparable<? super T>> void heapSort(T[] array){
        //从最底下的节点开始，一直往上，有点回溯的感觉，最后形成一个大顶堆，再进行插入
        //其实本质上就是先找到最大值，放到堆顶，自下而上的设计，很多题目都是这样的，比如一年花费最小的问题
        //你不可能在第一天就知道怎么样花钱最少，因为你不知道你之后的行程是如何的
        //你必须开启上帝视角，从后往前以你的目标进行逻辑分析，分析到第一天的时候，就一定是最小值了
        //同理，对于二叉树，你必须自底向上分析，才能找到最大或者最小值
        for (int i=(array.length>>1) - 1;i>=0;i--){
            adjustHeap(array,i,array.length);//长度每次都为array.length感觉降低性能，其实不然，如果没有交换，就break了
        }
        //大顶堆的根节点一定是最大的，把它和数组末尾进行交换
        //交换过后又得重新调整了,因为交换完以后只有length-1个需要排序了，因为只有一个元素变化了（根节点)，所以只需要一次
        //自下而上的重新调整，就能保住下一次的堆的根节点也是最大的
        for (int i=array.length-1;i>0;i--){
            T temp=array[i];
            array[i]=array[0];
            array[0]=temp;
            adjustHeap(array,0,i);
        }
    }
    //每次默认选择左子节点先比较，因为有数学关系，如果不满足，可以再将其转为右节点

    /**
     * Adjust node
     * @param array array needed to be adjust
     * @param start the index of non-leaf node represents in array
     * @param length the length of heap
     * @param <T> element type
     */
    private static <T extends Comparable<? super T>> void adjustHeap(T[] array, int start,int length){
        //这是一次自上而下的调整，只有符合条件就调整，不回头，否则直接break
        //因此在上面的heapsort函数中，需要从
        T temp=array[start];//父节点的值
        for (int i=(start<<1)+1;i<length;i=(i<<1)+1){//先比较左右节点哪个大
            if (i+1<length && array[i].compareTo(array[i+1])<0){
                i++;
            }
            if (array[i].compareTo(temp)>0){//拿大的子节点和父节点的值比较
                array[start]=array[i];//把较大的值赋给当前的节点
                start=i;//不是交换，胜似交换，因为即使你没有交换，你也保留了下标。如果下一次进入，则会继续更新该节点，否则直接出去了，再换
            }
            else break;
        }
        //结束之后，我们已经将以i为父节点的树的的最大值，放到了根节点
        array[start]=temp;
    }
}
