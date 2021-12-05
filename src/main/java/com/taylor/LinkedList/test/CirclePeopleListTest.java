package com.taylor.LinkedList.test;


import com.taylor.LinkedList.List.CirclePeopleList;

public class CirclePeopleListTest {
    public static void main(String[] args) {
        int[] list1={1,2,3,4,5,6,7,8,9,10};
        int[] list2={1,2,3,4,5,6,7,8,9,10};
        int[] list3={1,2,3,4,5,6,7,8,9,10};
        int[] list4={1,2,3,4,5,6,7,8,9,10};
        int[] list5={1,2,3,4,5,6,7,8,9,10};
        CirclePeopleList circlePeopleList1=new CirclePeopleList(list1);
        circlePeopleList1.simulate(2,5);
        System.out.println("-------------------------------------");
        CirclePeopleList circlePeopleList2=new CirclePeopleList(list1);
        circlePeopleList2.simulate(7);
    }
}
