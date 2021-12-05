package com.taylor.Tree;

public class ThreadBinaryTree<E> {
    private Node<E> root;
    private Node<E> pre;

    public ThreadBinaryTree() {
    }

    public ThreadBinaryTree(E e) {
        root= new Node<>(null, e, null);
    }

    public ThreadBinaryTree(Node<E> root) {
        this.root = root;
    }

    static class Node<E>{
        E person;
        Node<E> left;
        Node<E> right;
        boolean leftType;
        boolean rightType;

        public Node(Node<E> left, E person,  Node<E> right) {
            this.person = person;
            this.left = left;
            this.right = right;
        }
    }

    public void infixOrderTraverse(){
        infixOrderTraverse(root);
    }

    private void infixOrderTraverse(Node<E> node){
        if (node==null)
            return;
        if (!node.leftType)
            infixOrderTraverse(node.left);
        System.out.println(node.person+", Left: "+(node.leftType ? "pre" : "left")+"|Right: "+(node.rightType ? "next" : "right"));
        if (!node.rightType)
            infixOrderTraverse(node.right);
    }

    private void threading(Node<E> node){
        if (node!=null){
            threading(node.left);
            if (node.left==null){
                node.left=pre;
                node.leftType=true;
            }
            if (pre!=null && pre.right==null){
                pre.right=node;
                pre.rightType=true;
            }
            pre=node;
            threading(node.right);
//This way cannot set the last one's left type, because the last one's right is null, so node.right cannot into this function
        }
    }

    public void infixOrderSaveArray(E[] array){
        if (root==null)
            root=new Node<>(null,null,null);
        this.infixOrderSaveArray(array,0,root);
        threading(root);
    }

    private void infixOrderSaveArray(E[] array, int index, Node<E> node){
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

    public Node<E> getRoot() {
        return root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    public Node<E> getPre() {
        return pre;
    }

    public void setPre(Node<E> pre) {
        this.pre = pre;
    }
}
