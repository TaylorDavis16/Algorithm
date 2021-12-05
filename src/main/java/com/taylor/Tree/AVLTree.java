package com.taylor.Tree;

import java.util.Arrays;

public class AVLTree<E extends Comparable<E>> extends BinarySearchTree<E> {

    private boolean adjust=true;

    public void createWithArray(E[] array){
        Arrays.sort(array);
        setRoot(BSCreate(array,0,array.length-1));
    }

    private Node<E> BSCreate(E[] array,int start,int end){
        Node<E> node=null;
        if (start<=end){
            int mid=(start+end)/2;
            node=new Node<>(array[mid]);
            node.left=BSCreate(array,start,mid-1);
            node.right=BSCreate(array,mid+1,end);
        }
        return node;
    }
    
    private Node<E> bsCreate(E[] array, int start, int end){
        Node<E> node =null;
        if (start<=end){
            int mid = start + (end - start)/2;
            node = new Node<>(array[mid]);
            node.left = bsCreate(array,0,mid-1);
            node.right = bsCreate(array,mid+1,end);
        }
        return node;
    }

    @Override
    public void add(E[] array) {
        super.add(array);
        if (adjust) adjust();
    }

    @Override
    protected void add(E value, Node<E> node) {
        super.add(value, node);//添加完成
        if (adjust) adjust();
    }

    private void leftRotate(Node<E> root){
        Node<E> newNode= new Node<>(root.data);
        newNode.left=root.left;
        newNode.right=root.right.left;
        root.data=root.right.data;
        root.right=root.right.right;
        root.left=newNode;
    }

    private void rightRotate(Node<E> root){
        Node<E> newNode=new Node<>(root.data);
        newNode.right=root.right;
        newNode.left=root.left.right;
        root.data=root.left.data;
        root.left=root.left.left;
        root.right=newNode;
    }

    @Override
    public void remove(E value) {
        super.remove(value);//删除完成
        adjust();
    }

    private void adjust(){
        //需要向左旋转
        if (rightHeight(getRoot())-leftHeight(getRoot())>1){
            if (leftHeight(getRoot().right)>rightHeight(getRoot().right)){
                rightRotate(getRoot().right);
            }
            leftRotate(getRoot());
        }//需要向右旋转
        else if (leftHeight(getRoot())-rightHeight(getRoot())>1){
            if (leftHeight(getRoot().left)<rightHeight(getRoot().left)){
                leftRotate(getRoot().left);
            }
            rightRotate(getRoot());
        }
    }

    public void setAdjust(boolean adjust) {
        this.adjust = adjust;
    }
}
