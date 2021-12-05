package com.taylor.ArraySearching;

public class BinarySearchNoRecur {
    public static void main(String[] args) {
//        Integer[] integers1 = {1, 8, 10, 89, 89, 89, 89, 89, 89, 800, 600, 2000, 14, 15, 15, 1000, 1000, 1234};
//        Arrays.sort(integers1);
//        System.out.println(Arrays.toString(integers1));
//        System.out.println(binarySearch(integers1, 0, integers1.length - 1, 89));
//        System.out.println(binarySearchLeft(integers1, 0, integers1.length, 89));
//        System.out.println(binarySearchRight(integers1, 0, integers1.length, 89));
        System.out.println(bsIndex(new Integer[]{1,3},0,1,1));
        System.out.println(bsIndex(new Integer[]{1,3},0,1,2));
        System.out.println(bsIndex(new Integer[]{1,3},0,1,3));
        System.out.println(bsIndex(new Integer[]{1,3},0,1,4));
    }

    public static <T extends Comparable<T>> int bsIndex(T[] array, int start, int end, T value) {
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (array[mid].compareTo(value) == 0)
                return mid;
            else if (array[mid].compareTo(value) > 0) {
                end = mid - 1;
            } else start = mid + 1;
        }
        return mid;
    }

    public static <T extends Comparable<T>> int binarySearch(T[] array, int start, int end, T value) {
        //如果条件为<，那么终止条件为start=end，如果是[1,1]的话，算法就停止了，有可能出问题
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid].compareTo(value) == 0)
                return mid;
            else if (array[mid].compareTo(value) > 0) {
                end = mid - 1;
            } else start = mid + 1;
        }
        return -1;
    }

    //搜寻左侧边界
    public static <T extends Comparable<T>> int binarySearchLeft(T[] array, int start, int end, T value) {
        //left==right,算法终止
        int left = start, right = end;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid].compareTo(value) == 0) {
                right = mid;
            } else if (array[mid].compareTo(value) > 0) {
                right = mid - 1;
            } else if (array[mid].compareTo(value) < 0) {
                left = mid + 1;
            }
        }
        if (left == end - 1 || array[left].compareTo(value) != 0) return -1;
        return left;
    }

    //搜素右侧边界
    public static <T extends Comparable<T>> int binarySearchRight(T[] array, int start, int end, T value) {
        //left==right,算法终止
        int left = start, right = end;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid].compareTo(value) == 0) {
                left = mid + 1;
            } else if (array[mid].compareTo(value) < 0) {
                left = mid + 1;
            } else if (array[mid].compareTo(value) > 0) {
                right = mid;
            }
        }
        if (left == 0 || array[left - 1].compareTo(value) != 0) return -1;
        return left - 1;
    }
}
