package com.taylor.Test;

import java.util.Arrays;

public class ArrayCopyTest {
    public static void main(String[] args) {
        int a[]={0,1,2,3,4,5,6,7,8,9};
        System.arraycopy(a,1,a,2,8);
        System.out.println(Arrays.toString(a));
    }
}
