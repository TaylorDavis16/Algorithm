package com.taylor.Tree.test;


import com.taylor.Tree.AVLTree;

public class AVLTest2 {
    public static void main(String[] args) {
        Integer[] array1={4,1,7,0,2,5,8,3,9};
        Integer[] array2={6,3,0,9,1,7,2,5};
        Integer[] array3={3, 1, 0, 2, 6, 5, 7, 9};
        AVLTree<Integer> avlTree=new AVLTree<>();
        avlTree.createWithArray(array3);
        avlTree.add(10);
        avlTree.add(4);
        avlTree.add(6);
        avlTree.preOrderTraverse();
        System.out.println("-------------------------");
        avlTree.infixOrderTraverse();
        System.out.println("-------------------------");
        avlTree.postOrderTraverse();
        System.out.println("-------------------------");
        avlTree.levelOrderTraverse();
        System.out.println("-------------------------");
        System.out.println("Root: "+avlTree.getRoot());
        System.out.println("The height of tree is: "+avlTree.height());
        System.out.println("The height of left tree is: "+avlTree.leftHeight());
        System.out.println("The height of right tree is: "+avlTree.rightHeight());
    }
}
