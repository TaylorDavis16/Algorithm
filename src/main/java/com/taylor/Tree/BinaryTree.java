package com.taylor.Tree;


import com.taylor.LinkedList.Entity.People;

public class BinaryTree<E extends People> {

    private Node<E> root;

    public BinaryTree() {
    }

    public BinaryTree(E e) {
        root= new Node<>(null, e, null);
    }

    public BinaryTree(Node<E> root) {
        this.root = root;
    }

    public static class Node<E>{
        E person;
        Node<E> left;
        Node<E> right;

        public Node(Node<E> left, E person, Node<E> right) {
            this.person = person;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "person=" + person +
                    '}';
        }
    }

    public Node<E> getRoot() {
        return root;
    }

    public void setRoot(Node<E> root) {
        if (this.root==null)
            this.root = root;
    }

    public void preOrderTraverse(){
        this.preOrderTraverse(root);
    }

    private void preOrderTraverse(Node<E> node){
        if (node==null)
            return;
        System.out.println(node.person);
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    public void infixOrderTraverse(){
        infixOrderTraverse(root);
    }

    private void infixOrderTraverse(Node<E> node){
        if (node==null)
            return;
        infixOrderTraverse(node.left);
        System.out.println(node.person);
        infixOrderTraverse(node.right);
    }

    public void postOrderTraverse(){
        postOrderTraverse(root);
    }

    private void postOrderTraverse(Node<E> node){
        if (node==null)
            return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.println(node.person);
    }

    public E preOrderSearch(int id,Node<E> start){
        if (start==null)
            return null;
        if (start.person.getId()==id)
            return start.person;
        E person;
        person=preOrderSearch(id,start.left);
        if (person!=null && person.getId()==id)
            return person;
        person=preOrderSearch(id,start.right);
        if (person!=null && person.getId()==id)
            return person;
        return null;
    }

    public E infixOrderSearch(int id,Node<E> start){
        if (start==null)
            return null;
        E person = infixOrderSearch(id, start.left);
        if (person!=null && person.getId()==id)
            return person;
        if (start.person.getId()==id)
            return start.person;
        person= infixOrderSearch(id,start.right);
        if (person!=null && person.getId()==id)
            return person;
        return null;
    }

    public E postOrderSearch(int id,Node<E> start){
        if (start==null)
            return null;
        E person = postOrderSearch(id, start.left);
        if (person!=null && person.getId()==id)
            return person;
        person=postOrderSearch(id,start.right);
        if (person!=null && person.getId()==id)
            return person;
        if (start.person.getId()==id)
            return start.person;
        return null;
    }

    public void preOrderSaveArray(E[] array){
        if (root==null)
            root=new Node<>(null,null,null);
        Node<E> temp=root;
        this.preOrderSaveArray(array,0,temp);
    }

    //顺序化储存二叉树,元素必须有序
    private void preOrderSaveArray(E[] array,int index,Node<E> node){
        if (array==null || array.length==0)
            throw new IllegalArgumentException("Array is null!");
        node.person=array[index];
        if (2*index+1<array.length){
            node.left=new Node<>(null,null,null);
            preOrderSaveArray(array,2*index+1,node.left);
        }
        if (2*index+2<array.length){
            node.right=new Node<>(null,null,null);
            preOrderSaveArray(array,2*index+2,node.right);
        }
    }

    public void infixOrderSaveArray(E[] array){
        if (root==null)
            root=new Node<>(null,null,null);
        Node<E> temp=root;
        this.infixOrderSaveArray(array,0,temp);
    }

    private void infixOrderSaveArray(E[] array,int index,Node<E> node){
        if (array==null || array.length==0)
            throw new IllegalArgumentException("Array is null!");
        if (2*index+1<array.length){
            node.left=new Node<>(null,array[2*index+1],null);
            infixOrderSaveArray(array,2*index+1,node.left);
        }
        node.person=array[index];
        if (2*index+2<array.length){
            node.right=new Node<>(null,null,null);
            infixOrderSaveArray(array,2*index+2,node.right);
        }
    }

    public void postOrderSaveArray(E[] array){
        if (root==null)
            root=new Node<>(null,null,null);
        Node<E> temp=root;
        this.postOrderSaveArray(array,0,temp);
    }

    private void postOrderSaveArray(E[] array,int index,Node<E> node){
        if (array==null||array.length==0)
            throw new IllegalArgumentException("Array is null!");
        if (2*index+1<array.length){
            node.left=new Node<>(null,array[2*index+1],null);
            postOrderSaveArray(array,2*index+1,node.left);
        }
        if (2*index+2<array.length){
            node.right=new Node<>(null,array[2*index+2],null);
            postOrderSaveArray(array,2*index+2,node.right);
        }
        node.person=array[index];
    }

}
