package com.taylor.LinkedList.Entity;

public class PeopleBox {
    public static People p1=new People(1,3,"A");
    public static People p2=new People(3,2,"C");
    public static People p3=new People(2,5,"B");
    public static People p4=new People(5,7,"E");
    public static People p5=new People(7,16,"F");
    public static People p6=new People(6,15,"G");

    public static Celebrity TaylorDavis=new Celebrity(16,19,"Taylor Davis","DongDong");
    public static Celebrity Selena=new Celebrity(8,27,"Selena Gomez","傻脸娜");
    public static Celebrity TaylorSwift=new Celebrity(13,30,"Taylor Swift","TayTay");
    public static Celebrity ArianaGrande=new Celebrity(4,37,"Ariana Grande","A Sister");
    public static Celebrity MariahCarey=new Celebrity(9,39,"Mariah Carey","E=MC2");
    public static Celebrity JayChou=new Celebrity(0,"JayChou","Jay");
    public static Celebrity KatyPerry=new Celebrity(1,17,"Katy Perry","Fruit Sister");
    public static Celebrity Somebody=new Celebrity(12);

    public static Customer c1=new Customer(3);
    public static Customer c2=new Customer(7,20,"Amy");
    public static Customer c3=new Customer("Taylor");
    public static Customer c4=new Customer(34,89,"Aunt Rebecca");
    public static Customer c5=new Customer(10);

    public static People[] peopleBox={p1,p2,p3,p4,p5,p6};
    public static Celebrity[] celebrityBox={TaylorDavis,Selena,TaylorSwift,ArianaGrande,MariahCarey,JayChou,KatyPerry,Somebody};
    public static Customer[] customerBox={c1,c2,c3,c4,c5};

}
