package com.taylor.LinkedList.test;//package LinkedList.test;
//
//import LinkedList.Zip.Celebrity;
//import LinkedList.List.CelebrityList;
//
//import java.io.IOException;
//
//public class CelebrityListTest {
//    public static void main(String[] args) {
//        CelebrityList list=new CelebrityList();
//        System.out.println("List is empty? "+list.isEmpty()+" Number: "+list.size());
//        list.add(new Celebrity(10));
//        list.add(new Celebrity("QXJ"));
//        list.add(new Celebrity("7"));
//        list.add(new Celebrity("Tom","Tommy"));
//        list.add(new Celebrity(15,"Jerry","Jey"));
//        list.add(new Celebrity(16,19,"Taylor Davis","DongDong"));
//        list.add(new Celebrity(13,30,"Taylor Swift","TayTay"));
//        list.add(new Celebrity(8,27,"Selena Gomez","傻脸娜"));
//        list.add(new Celebrity(9,39,"Mariah Carey","E=MC2"));
//        list.add(new Celebrity(10,9,"A","a"));
//        list.add(new Celebrity(4,37,"Ariana Grande","A Sister"));
//        list.add(new Celebrity(1,17,"Katy Perry","Fruit Sister"));
//        list.add(new Celebrity(0,"JayChou","Jay"));
//        list.add(new Celebrity());
//        list.show();
//
//        System.out.println("You get a person: "+list.get(null));
//        System.out.println("You get a person: "+list.get(16));
//        System.out.println("You get a person: "+list.get("Selena Gomez"));
//        System.out.println("You get a person: "+list.get());
//        list.show();
//
//        System.out.println("You remove a person: "+list.remove(10));
//        System.out.println("You remove a person: "+list.remove(13));
//        System.out.println("You remove a person: "+list.remove(null));
//        System.out.println("You remove a person: "+list.remove("QXJ"));
//        System.out.println("You remove a person: "+list.remove());
//        list.show();
//
//        System.out.println("------------------------------");
//        System.out.println("The operated reverse list:");
//        list.reverse();
//        list.remove();
//        list.get().setAge(999);
//        list.show();
//        System.out.println("List is empty? "+list.isEmpty()+" Number: "+list.size());
//
//        System.out.println("------------------------------");
//        System.out.println("Contains 16? "+list.contains(16));
//        System.out.println("Contains \"7\"? "+list.contains("7"));
//        System.out.println("Contains \"null\"? "+list.contains(null));
//        System.out.println("------------------------------");
//        System.out.println("The array of list:");
//        Celebrity[] celebrities=list.toArray();
//        for (Celebrity celebrity : celebrities) {
//            celebrity.setAge(99);
//            System.out.println(celebrity);
//        }
//        System.out.println("------------------------------");
//        System.out.println("The list:");
//        list.show();
//        System.out.println("------------------------------");
//        CelebrityList list1=list.copy();
//        System.out.println("Reverse list");
//        list.show();
//        System.out.println("------------------------------");
//        System.out.println("Copy of reverse list");
//        list1.show();
//        System.out.println("------------------------------");
//        CelebrityList list2=new CelebrityList();
//        list2.add(new Celebrity(2,12,"Apple","果果"));
//        list2.add(new Celebrity(3,11,"HUAWEI","阿为"));
//        list2.add(new Celebrity(5,10,"Samsung","3 stars"));
//        System.out.println("List 2:");
//        list2.show();
//        System.out.println("------------------------------");
//        System.out.println("Merge list of list and list2:");
//        try {
//            list.addAll(list2);
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        list.show();
//        System.out.println("------------------------------");
//        System.out.println("List 2:");
//        list2.show();
//    }
//}
