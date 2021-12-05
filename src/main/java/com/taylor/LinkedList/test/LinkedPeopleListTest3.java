package com.taylor.LinkedList.test;


import com.taylor.LinkedList.Entity.Celebrity;
import com.taylor.LinkedList.Entity.People;
import com.taylor.LinkedList.List.LinkedPeopleListPro;


import java.io.IOException;

public class LinkedPeopleListTest3 {
    public static void main(String[] args) {
        LinkedPeopleListPro<People> list1=new LinkedPeopleListPro<>();
        list1.add(new People(2,5,"B"));
        list1.add(new People(1,3,"A"));
        list1.add(new Celebrity(4,2,"D","d"));
        list1.add(new People(3,2,"C"));


        LinkedPeopleListPro<People> list2=new LinkedPeopleListPro<>();
        list2.add(new People(5,7,"E"));
        list2.add(new People(7,16,"F"));
        list2.add(new People(6,15,"G"));
        list2.add(new Celebrity());
        LinkedPeopleListPro<Celebrity> cList=new LinkedPeopleListPro<>();
        cList.add(new Celebrity(16,19,"Taylor Davis","DongDong"));
        cList.add(new Celebrity(8,27,"Selena Gomez","傻脸娜"));
        cList.add(new Celebrity(13,30,"Taylor Swift","TayTay"));
        cList.add(new Celebrity(4,37,"Ariana Grande","A Sister"));
        cList.add(new Celebrity(9,39,"Mariah Carey","E=MC2"));
        cList.add(new Celebrity(10,9,"A","a"));
        cList.add(new Celebrity(0,"JayChou","Jay"));
        cList.add(new Celebrity(1,17,"Katy Perry","Fruit Sister"));
        cList.add(new Celebrity());
        cList.add(new Celebrity(14));



//        list1.removeFirst();
//        list1.removeFirst();
//        list1.removeFirst();

        list1.show();
        list1.remove(4);
        System.out.println(list1.get());
        list1.remove(1);
        System.out.println(list1.get());
        list1.remove("B");
        System.out.println(list1.get());
        list1.removeFirst();
        System.out.println(list1.get());
//        list1.remove();
//        System.out.println(list1.getLast());
//        list1.remove();
//        System.out.println(list1.getLast());
        list1.show();

        //------------
        list2.reverse();
        list2.remove(null);
        list2.show();
        //------------
        cList.show();
        //------------
        try {
            LinkedPeopleListPro<Celebrity> copy = cList.copy();
            copy.remove();
            copy.remove(4);
            copy.remove(null);
            copy.removeFirst();
            copy.show();
            copy.reverse();
            copy.show();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
