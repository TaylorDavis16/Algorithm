package com.taylor.ArraySearching;

import java.util.HashMap;

public class BinarySearch<E extends Comparable<? super E>> {
    private HashMap<Integer,E> map;
    private E[] array;
    private boolean saveResult=true;

    public BinarySearch() {
        this.map = new HashMap<>();
    }

    public BinarySearch(E[] array) {
        this.map = new HashMap<>();
        this.array=array;
    }
    /**
     *
     * @param array The array waited to be search
     * @param start Starting point
     * @param end Ended point
     * @param value The value you want to search
     * @return The index of the value in array if it existed, or -1 otherwise
     */
    public int binarySearch(E[] array, int start, int end, E value){
        if (start<=end){
            int index=(end+start)/2;
            if (array[index].compareTo(value)==0)
                return index;
            else if (array[index].compareTo(value)>0)
                return binarySearch(array,start,index-1,value);
            else return binarySearch(array,index+1,end,value);
        }
        return -1;
    }

    private void searchAll(int start, int end, E value){
        if (start>end){
            map.put(-1,value);
            return;
        }

        int index=(end+start)/2;
        if (array[index].compareTo(value)==0){
            map.put(index,value);
            int i=index-1;
            int j=index+1;
            while (i>=0 && array[i].compareTo(value)==0){
                map.put(i,value);
                i--;
            }
            while (j>=0 && array[j].compareTo(value)==0){
                map.put(j,value);
                j++;
            }
        }
        else if (array[index].compareTo(value)>0)
            searchAll(start,index-1,value);
        else searchAll(index+1,end,value);
    }

    public void binarySearchAll(int start, int end, E value){
        if (array==null)
            throw new RuntimeException("Array has not set up!");
        if (!saveResult)
        map.clear();
        searchAll(start,end,value);
    }

    public void setArray(E[] array) {
        this.array = array;
    }

    public HashMap<Integer, E> getMap() {
        return map;
    }

    public void setSaveResult(boolean saveResult) {
        this.saveResult = saveResult;
    }
}
