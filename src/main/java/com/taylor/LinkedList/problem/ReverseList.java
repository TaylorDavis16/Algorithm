package com.taylor.LinkedList.problem;

import java.util.Stack;

public class ReverseList {
    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        Node temp=list.head;
        for (int i=1;i<10;i++){
            temp.next=new Node();
            temp.next.value=i;
            temp=temp.next;
        }
        list.show();
//        LinkedList reverseList=ReverseList.reverse(list);
//        LinkedList reverseList=ReverseList.reverseByStack(list);
        LinkedList reverseList=ReverseList.reverse(list,3,8);
        reverseList.show();
//        list.show();
    }

    public static LinkedList reverse(LinkedList list){
        if (list.head==null || list.head.next==null)
            return list;
        Node current=list.head.next;
        LinkedList result=new LinkedList();

        while (current!=null){
            Node temp=result.head.next;
            result.head.next=current;
            current=current.next;   
            result.head.next.next=temp;
        }
        return result;
    }

    public static LinkedList reverseByStack(LinkedList list){
        if (list.head==null || list.head.next==null)
            return list;
        Stack<Integer> stack=new Stack<>();
        Node temp=list.head.next;
        while (temp!=null){
            stack.push(temp.value);
            temp=temp.next;
        }
        LinkedList result=new LinkedList();
        temp=result.head;
        while (!stack.empty()){
            temp.next=new Node();
            temp.next.value=stack.pop();
            temp=temp.next;
        }
        return result;
    }

    /**
     * Reverse list from a certain range of the list
     * Check start and end are valid before reversion! Checking process is neglected!
     * @param list original list
     * @param start from 1 to list.size-1
     * @param end from start+1 to list.size
     * @return the reverse list
     */
    public static LinkedList reverse(LinkedList list,int start,int end){
        if (list.head==null || list.head.next==null)
            return list;
        Node temp=list.head;
        int i=0;
        while (temp.next!=null && i<start){
            temp=temp.next;
            i++;
        }
        Node startNode=temp;
        while (temp.next!=null && i<end){
            temp=temp.next;
            i++;
        }
        Node endNode=temp;
        endNode.next=null;//Set the end of the endNode null so recursion can stop
        //We have a partial list from original list which without head node
        list.head.next= reverse(startNode);
        return list;
    }

    private static Node reverse(Node node){
        if (node==null || node.next==null)
            return node;
        Node nextNode=node.next;
        node.next=null;
        Node result = reverse(nextNode);
        nextNode.next=node;
        return result;
    }
}

class Node{
    int value;
    Node next;
}

class LinkedList{
    Node head;
    public LinkedList() {
        this.head = new Node();
    }

    public void show(){
        Node temp=head.next;
        while (temp!=null){
            System.out.print(temp.value+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}
