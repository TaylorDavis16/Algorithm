package com.taylor.Test;

public class TestFor {
    public static void main(String[] args) {
        int start=5;
        for (int i=start*2+1;i<100;i=i*2+1){
            if (i+1<100){
                start+=2;
                System.out.print(start+" ");
                System.out.println("i="+i);
            }
        }
    }
}
