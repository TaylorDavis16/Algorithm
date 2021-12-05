package com.taylor.Test;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        
        int[][] a=new int[3][3];
        System.out.println(a[1][2]);
        Object[][] objects=new Object[1][2];
        objects[0][0]=16;
        objects[0][1]=26;
        Double[][] doubles=(Double[][]) objects;
        System.out.println(doubles[0][0]);
        System.out.println(doubles[0][1]);
    }
}
