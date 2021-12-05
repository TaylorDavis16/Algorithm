package com.taylor.DP;

/**
 * Plus with memorized searching
 */
public class Knapsack2 {
    private int[] weight;
    private int[] value;
    private int capacity;
    private int[][] memo;

    public Knapsack2(int[] weight, int[] value, int capacity) {
        this.weight = weight;
        this.value = value;
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        int[] weight={1,3,4};
        int[] value={1500,2000,3000};
        Knapsack2 knapsack=new Knapsack2(weight,value,10);
        System.out.println(knapsack.getMaxValue());
    }

    public int getMaxValue(){
        if (weight==null || value==null){
            return 0;
        }else if (weight.length!=value.length){
            if (weight.length>value.length){
                System.arraycopy(weight,0,weight,0,value.length);
            }
            if (weight.length<value.length){
                System.arraycopy(value,0,value,0,weight.length);
            }
        }
        int length=value.length;
        memo=new int[length][capacity+1];
        return maxValue(length-1,capacity);
    }
    /**
     * Calculate the max value that the knapsack can carry
     * The length of weight array must as same as the value array
     * @param index the index of the current item
     * @param capacity the capacity of the knapsack
     * @return the max value that the knapsack can carry
     */
    public int maxValue(int index,int capacity){
        if (index>=0 && capacity>0){
            if (memo[index][capacity]!=0)
                return memo[index][capacity];
            int preValue=maxValue(index-1,capacity);
            if (weight[index]<=capacity){
                preValue=Math.max(preValue,value[index]+maxValue( index-1, capacity-weight[index]));
            }
            memo[index][capacity]=preValue;
            return preValue;
        }
        return 0;
    }
}
