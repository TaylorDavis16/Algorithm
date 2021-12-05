package com.taylor.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class HuffmanTree<E extends Comparable<? super E>>{
    private Node<E> root;
    private E[] array;
    private Applicable<E> combiner;
    private int size;
    public HuffmanTree(E[] array, Applicable<E> combiner) {
        if (array==null || combiner==null)
            throw new NullPointerException();
        if (array.length==0)
            throw new IllegalArgumentException("Array is empty!");
        this.array=array;
        this.combiner=combiner;
    }

    public HuffmanTree() {
    }

    private static class Node<E extends Comparable<? super E>> implements Comparable<Node<E>>{
        E e;
        Node<E> left;
        Node<E> right;

        public Node(E e) {
            this.e = e;
        }

        @Override
        public int compareTo(Node<E> o) {
            return this.e.compareTo(o.e);
        }
    }

    public void preOrderTraverse(){
        this.preOrderTraverse(root);
        System.out.println("-----------------------------------------");
    }


    private void preOrderTraverse(Node<E> node) {
        if (node!=null){
            System.out.println(node.e);
            preOrderTraverse(node.left);
            preOrderTraverse(node.right);
        }
    }

    public ArrayList<String> preOrderSaveData(Predicate<E> standard,Consumer<E> action1,Consumer<E> action2){
        ArrayList<String> result=new ArrayList<>(this.size);
        saveData(root,standard,action1,action2,result);
        return result;
    }

    //在前序遍历的过程中，实现Predicate和两个Consumer接口，有选择的取出数据
    private void saveData(Node<E> node, Predicate<E> standard, Consumer<E> action1,Consumer<E> action2,ArrayList<String> arrayList){
        if (node!=null){
            if (standard.test(node.e)) {
                if (node.right==null && node.left==null)
                    arrayList.add(node.e.toString());
            }
            if (node.left!=null && standard.test(node.left.e))
                action1.accept(node.left.e);
            saveData(node.left,standard,action1,action2,arrayList);
            if (node.right!=null && standard.test(node.right.e))
                action2.accept(node.right.e);
            saveData(node.right,standard,action1,action2,arrayList);
        }
    }

    public void infixOrderTraverse(){
        this.infixOrderTraverse(root);
        System.out.println("-----------------------------------------");
    }

    private void infixOrderTraverse(Node<E> node) {
        if (node!=null){
            infixOrderTraverse(node.left);
            System.out.println(node.e);
            infixOrderTraverse(node.right);
        }
    }

    public void postOrderTraverse(){
        this.postOrderTraverse(root);
        System.out.println("-----------------------------------------");
    }

    private void postOrderTraverse(Node<E> node) {
        if (node!=null){
            postOrderTraverse(node.left);
            postOrderTraverse(node.right);
            System.out.println(node.e);
        }
    }

    public void build(){
        if (combiner==null)
            throw new UnsupportedOperationException("UnApplicable method for building a Huffman tree");
//        LinkedList<Node<E>> list=new LinkedList<>();
        ArrayList<Node<E>> list=new ArrayList<>();
        for (E e : array) {
            Node<E> node = new Node<>(e);
            list.add(node);
        }
        this.size=list.size();

        while (list.size()>1){
            Collections.sort(list);
            Node<E> node1 = list.remove(0);
            Node<E> node2 = list.remove(0);
            Node<E> newNode=new Node<>(combiner.apply(node1.e,node2.e));
            newNode.left=node1;
            newNode.right=node2;
            list.add(newNode);
            this.size++;
        }
        root=list.get(0);
    }



    public Node<E> getRoot() {
        return root;
    }

    public E[] getArray() {
        return array;
    }

    public void setArray(E[] array) {
        this.array = array;
    }

    public void setCombiner(Applicable<E> combiner) {
        this.combiner = combiner;
    }
}
