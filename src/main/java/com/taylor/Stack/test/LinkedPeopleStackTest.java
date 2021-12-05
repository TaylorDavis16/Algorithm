package com.taylor.Stack.test;


import com.taylor.LinkedList.Entity.Celebrity;
import com.taylor.Stack.stack.LinkedPeopleStack;

public class LinkedPeopleStackTest {
    public static void main(String[] args) {
        LinkedPeopleStack<Celebrity> peopleStack=new LinkedPeopleStack<Celebrity>();
        peopleStack.push(new Celebrity("Taylor Davis","DongDong"));
        peopleStack.push(new Celebrity("Selena Gomez","傻脸娜"));
        peopleStack.push(new Celebrity());
        peopleStack.push(new Celebrity("Taylor Swift","TayTay"));
        System.out.println(peopleStack.pop()+" "+peopleStack.size());
        System.out.println(peopleStack.pop()+" "+peopleStack.size());
        System.out.println(peopleStack.peek());
        System.out.println(peopleStack.pop()+" "+peopleStack.size());
        System.out.println(peopleStack.pop()+" "+peopleStack.size());
        System.out.println(peopleStack.peek());
        System.out.println(peopleStack.pop());

    }
}
