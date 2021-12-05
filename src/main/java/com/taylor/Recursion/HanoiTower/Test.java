package com.taylor.Recursion.HanoiTower;

public class Test {
    public static void main(String[] args) {
        Hanoi hanoi=new Hanoi(31);
        hanoi.move();
        System.out.println("Move time is "+hanoi.getMoveTime());
    }
}
