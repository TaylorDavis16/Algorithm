package com.taylor.LinkedList.test;


import com.taylor.LinkedList.Entity.Celebrity;
import com.taylor.LinkedList.Entity.People;
import com.taylor.LinkedList.List.LinkedPeopleList;

import java.io.IOException;

public class LinkedPeopleListTest2 {
    public static void main(String[] args) {
        LinkedPeopleList<People> list1=new LinkedPeopleList<>();
        list1.add(new People(1,3,"A"));
        list1.add(new Celebrity(4,2,"D","d"));
        list1.add(new People(3,2,"C"));
        list1.addFirst(new People(2,5,"B"));

        LinkedPeopleList<People> list2=new LinkedPeopleList<>();
        list2.add(new People(5,7,"E"));
        list2.add(new People(7,16,"F"));
        list2.add(new People(6,15,"G"));
        list2.add(new Celebrity());
        LinkedPeopleList<Celebrity> cList=new LinkedPeopleList<>();
        cList.add(new Celebrity(16,19,"Taylor Davis","DongDong"));
        cList.add(new Celebrity(8,27,"Selena Gomez","傻脸娜"));
        cList.add(new Celebrity(13,30,"Taylor Swift","TayTay"));
        cList.add(new Celebrity(4,37,"Ariana Grande","A Sister"));
        cList.add(new Celebrity(9,39,"Mariah Carey","E=MC2"));
        cList.add(new Celebrity(10,9,"A","a"));
        cList.add(new Celebrity(0,"JayChou","Jay"));
        cList.add(new Celebrity(1,17,"Katy Perry","Fruit Sister"));
        cList.add(new Celebrity());

        try {
            list1.addAll(list2);
            list1.addAll(cList);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        list1.remove(10);
        list1.remove(18);
        list1.remove("D");
        list1.remove("F");
        list1.remove();
        System.out.println(list1.get());
        System.out.println(list1.get(2));
        System.out.println(list1.get("Taylor Swift"));
        System.out.println("-------------------");
        list1.reverse();
        list1.show();
        list2.show();
        People[] people=new People[list1.size()];
        people=list1.toArray(people);
        System.out.println("Array!=============");
        for (People person : people) {
            System.out.println(person);
        }
//        LinkedList<Celebrity> linkedList=new LinkedList<>();
//        linkedList.


    }
}
