package com.taylor.Stack.stack;

public class NumberStack implements Stack<Integer> {
    private int top=-1;
    private int maxSize;
    private int data[];
    private int size;

    public NumberStack() {
        this(16);
    }

    public NumberStack(int maxSize) {
        this.maxSize = maxSize;
        data=new int[this.maxSize];
        this.size=0;
    }

    @Override
    public void push(Integer integer) {
        if (!isFull()){
            data[++top]=integer;
            size++;
        }
    }

    @Override
    public Integer pop() {
        if (!isEmpty()){
            size--;
            return data[top--];
        }
        return null;
    }

    @Override
    public Integer peek() {
        return isEmpty() ? null :data[top];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return top==-1;
    }

    @Override
    public boolean isFull() {
        return top+1==maxSize;
    }
}
