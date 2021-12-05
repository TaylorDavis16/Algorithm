package com.taylor.Queue.queue;

public class PriorityQueue<T extends Comparable<T>> {
    private Node<T> head;
    static class Node<T>{
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
    
    private void push(T value){
        if (head == null) head = new Node<>(value);
        else {
            
        }
    }
}
