package com.taylor.Tree.test;



import com.taylor.Tree.AVLArray;
import com.taylor.Tree.AVLTree;
import com.taylor.Tree.BinarySearchTree;

import java.util.Arrays;
import java.util.Random;

public class AVLArrayTest {
    public static void main(String[] args) {
        Integer[] temp={2, 3, 5, 8, 8, 12, 14, 16, 19, 27};
        Integer[] array=new Integer[10];
        Random random=new Random();
        for (int i=0;i<10;i++){
            array[i]=random.nextInt(30);
        }
        AVLArray.adjustArray(array);
        System.out.println("Before adjust:"+Arrays.toString(array));
        System.out.println("After adjust:"+Arrays.toString(AVLArray.avlArray));

        BinarySearchTree<Integer> bstTree=new BinarySearchTree<Integer>();
        AVLTree<Integer> avlTree=new AVLTree<Integer>();
        avlTree.setAdjust(false);

        avlTree.add(AVLArray.avlArray);
        Integer[] levelArray=new Integer[10];
        levelArray=avlTree.getLevelOrderAsArray(levelArray);
        System.out.println("LevelArray:"+Arrays.toString(levelArray));
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

        System.out.println("---------------------------------------------------------");

        bstTree.add(levelArray);
        bstTree.preOrderTraverse();
        System.out.println("-------------------------");
        bstTree.infixOrderTraverse();
        System.out.println("-------------------------");
        bstTree.postOrderTraverse();
        System.out.println("-------------------------");
        bstTree.levelOrderTraverse();
        System.out.println("-------------------------");
        System.out.println("Root: "+bstTree.getRoot());
        System.out.println("The height of tree is: "+bstTree.height());
        System.out.println("The height of left tree is: "+bstTree.leftHeight());
        System.out.println("The height of right tree is: "+bstTree.rightHeight());

    }
}
