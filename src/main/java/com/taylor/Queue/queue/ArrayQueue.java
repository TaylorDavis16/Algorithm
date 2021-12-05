package com.taylor.Queue.queue;

public class ArrayQueue implements Queue{
    private int maxSize;
    private int index;
    private int[] content;
    public ArrayQueue(){
        this(16);
    }
    public ArrayQueue(int maxSize) {
        this.maxSize=maxSize;
        index=-1;
        content=new int[maxSize];
    }
    public boolean isEmpty(){
        return index==-1;
    }


    @Override
    public void add(int value) throws QueueFullException {
        if (index+1==maxSize)
            throw new QueueFullException();
        content[++index]=value;
    }

    @Override
    public int get(){
        if (isEmpty())
            throw new RuntimeException("This queue is empty");
        int value=content[0];
        if (index >= 0) System.arraycopy(content, 1, content, 0, index);
        content[index]=0;
        index--;
        return value;
    }

    @Override
    public int peek(){
        if (isEmpty())
            throw new RuntimeException("This queue is empty!");
          return content[0];
    }

    @Override
    public int count(){
        return index+1;
    }

    @Override
    public void show() {
        System.out.print("[");
        for (int i=0;i<=index;i++) {
            if (i<index)
                System.out.print(content[i]+",");
            else{
                System.out.print(content[i]);
                break;
            }
        }
        System.out.println("]");
    }
}
