package com.taylor.LinkedList.test;



import com.taylor.LinkedList.Entity.Celebrity;
import com.taylor.LinkedList.Entity.People;
import com.taylor.LinkedList.List.LinkedPeopleList;

import java.io.IOException;

public class LinkedPeopleListTest {
    public static void main(String[] args) {
        LinkedPeopleList<People> list=new LinkedPeopleList<>();
        list.add(new People(1,3,"A"));
        list.add(new People(3,2,"C"));
        list.add(new People(2,5,"B"));
        list.add(new Celebrity(4,2,"D","d"));
        list.show();
        System.out.println("---------------------------");
        LinkedPeopleList<Celebrity> list1=new LinkedPeopleList<>();
        list1.add(new Celebrity(16,19,"Taylor Davis","DongDong"));
        list1.add(new Celebrity(8,27,"Selena Gomez","傻脸娜"));
        list1.add(new Celebrity(13,30,"Taylor Swift","TayTay"));
        list1.add(new Celebrity(4,37,"Ariana Grande","A Sister"));
        list1.add(new Celebrity(9,39,"Mariah Carey","E=MC2"));
        list1.add(new Celebrity(10,9,"A","a"));
        list1.add(new Celebrity(0,"JayChou","Jay"));
        list1.add(new Celebrity(1,17,"Katy Perry","Fruit Sister"));
        list1.add(new Celebrity());
        list1.show();
        System.out.println("---------------------------");
        System.out.println("Array!");
        Celebrity[] array=new Celebrity[9];
        array=list1.toArray(array);
        for (Celebrity celebrity : array) {
            System.out.println(celebrity);
        }
        System.out.println("---------------------------");
        LinkedPeopleList<Celebrity> list2=new LinkedPeopleList<>();
        list2.add(new Celebrity(2,12,"Apple","果果"));
        list2.add(new Celebrity(3,11,"HUAWEI","阿为"));
        list2.add(new Celebrity(5,10,"Samsung","3 stars"));
        try {
            list1.addAll(list2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        list1.show();
        list2.show();
        System.out.println("---------------------------");
//        list2.remove(3);
//        list2.remove("Samsung");
//        System.out.println(list2.get(2));
//        System.out.println(list2.get("Apple"));
//        System.out.println(list2.get());
//        list2.remove();
//        list2.show();
//        System.out.println("---------------------------");
    }
}
