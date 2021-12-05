package com.taylor.Stack.stack;


import com.taylor.LinkedList.Entity.People;
import com.taylor.LinkedList.List.LinkedPeopleList;

public class LinkedPeopleStack<E extends People> implements Stack<E> {
    private int maxSize;
    private int size;
    private LinkedPeopleList<E> list;

    public LinkedPeopleStack() {
        this(16);
    }

    public LinkedPeopleStack(int maxSize) {
        list=new LinkedPeopleList<>();
        this.maxSize = maxSize;
        this.size=0;
    }

    @Override
    public void push(E person) {
        if (isFull())
            this.maxSize*=2;
        list.add(person);
    }

    @Override
    public E pop() {
        return list.remove();
    }

    @Override
    public E peek() {
        return list.get();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size==maxSize;
    }
}
