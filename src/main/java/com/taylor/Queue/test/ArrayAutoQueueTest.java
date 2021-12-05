package com.taylor.Queue.test;


import com.taylor.Queue.queue.ArrayAutoQueue;

public class ArrayAutoQueueTest {
    public static void main(String[] args) {
        ArrayAutoQueue queue=new ArrayAutoQueue(0);
        while (true){
            Method.act(queue);
        }
    }

}
