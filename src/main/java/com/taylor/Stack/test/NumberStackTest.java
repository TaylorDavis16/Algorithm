package com.taylor.Stack.test;


import com.taylor.Stack.stack.NumberStack;

public class NumberStackTest {
    public static void main(String[] args) {
        NumberStack numberStack=new NumberStack();
        System.out.println("Empty: "+numberStack.isEmpty()+" Full: "+numberStack.isFull()+" Size: "+numberStack.size());
        numberStack.push(1);
        numberStack.push(2);
        numberStack.push(3);
        numberStack.push(4);
        numberStack.push(15);
        System.out.println("Peek: "+numberStack.peek());
        System.out.println("----------------------------------");
        while (!numberStack.isEmpty()) System.out.println(numberStack.pop());
    }
}
