package com.taylor.Queue.queue;

import java.util.Arrays;

//是一个循环队列
public class ArrayAutoQueue implements Queue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] content;

    public ArrayAutoQueue() {
        this(16);
    }

    public ArrayAutoQueue(int maxSize) {
        this.maxSize = maxSize+1;
        this.front=0;
        this.rear=0;
        content=new int[this.maxSize];
    }

    @Override
    public boolean isEmpty(){
        return rear==front;
    }

    @Override
    public void add(int value) throws QueueFullException {
        if ((rear+1)%maxSize==front)
            throw new QueueFullException();
        content[++rear%maxSize]=value;
    }

    @Override
    public int get(){
        if (isEmpty())
            throw new RuntimeException("This queue is empty!");
        return content[++front%maxSize];
    }

    @Override
    public int peek(){
        if (isEmpty())
            throw new RuntimeException("This queue is empty!");
        return content[(front+1)%maxSize];
    }

    @Override
    public int count(){
        System.out.println("Rear:"+rear+" Front:"+front);
        return (rear-front)%maxSize;
    }

    @Override
    public void show() {
        int tempRear=rear;
        int tempFront=front;
        System.out.print("[");
        while (tempFront!=tempRear){
            int i=++tempFront%maxSize;
            if (tempFront!=tempRear)
            System.out.print(content[i]+",");
            else System.out.print(content[i]);
        }
        System.out.println("]");
        System.out.println(Arrays.toString(content));
    }

}
