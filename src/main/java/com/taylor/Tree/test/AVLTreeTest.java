package com.taylor.Tree.test;


import com.taylor.Tree.AVLTree;

public class AVLTreeTest {
    public static void main(String[] args) {
        AVLTree<Integer> integerAVLTree= new AVLTree<Integer>();
        Integer[] integers={2,5,6,8,3,9,7,0,12,10,6};
        integerAVLTree.add(integers);
//        integerAVLTree.remove(9);
//        integerAVLTree.remove(10);
//        integerAVLTree.remove(12);
//        integerAVLTree.remove(6);
        integerAVLTree.remove(3);
        integerAVLTree.remove(6);
        integerAVLTree.remove(2);
//        integerAVLTree.remove(5);
//        integerAVLTree.remove(7);
//        integerAVLTree.remove(6);
//        integerAVLTree.remove(8);
//        integerAVLTree.remove(0);
        integerAVLTree.infixOrderTraverse();
        System.out.println("Root: "+integerAVLTree.getRoot());
        System.out.println("The height of tree is: "+integerAVLTree.height());
        System.out.println("The height of left tree is: "+integerAVLTree.leftHeight());
        System.out.println("The height of right tree is: "+integerAVLTree.rightHeight());
        integerAVLTree.levelOrderTraverse();
        System.out.println("-------------------------");
        AVLTree<Integer> integerAVLTree1= new AVLTree<Integer>();
        Integer[] integers1={10,11,7,6,8,9};
        integerAVLTree1.add(integers1);
        integerAVLTree1.infixOrderTraverse();
        System.out.println("Root: "+integerAVLTree1.getRoot());
        System.out.println("The height of tree is: "+integerAVLTree1.height());
        System.out.println("The height of left tree is: "+integerAVLTree1.leftHeight());
        System.out.println("The height of right tree is: "+integerAVLTree1.rightHeight());
        integerAVLTree1.levelOrderTraverse();
        System.out.println("-------------------------");
        AVLTree<Integer> integerAVLTree2= new AVLTree<Integer>();
        integerAVLTree2.setAdjust(false);
        Integer[] integers2={16,1,20,0,3,20,26,13,20,27};
        integerAVLTree2.add(integers2);
        integerAVLTree2.infixOrderTraverse();
        System.out.println("Root: "+integerAVLTree2.getRoot());
        System.out.println("The height of tree is: "+integerAVLTree2.height());
        System.out.println("The height of left tree is: "+integerAVLTree2.leftHeight());
        System.out.println("The height of right tree is: "+integerAVLTree2.rightHeight());
        integerAVLTree2.preOrderTraverse();
        integerAVLTree2.levelOrderTraverse();
    }
}
