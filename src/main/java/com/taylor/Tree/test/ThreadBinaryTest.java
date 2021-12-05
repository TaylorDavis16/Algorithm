package com.taylor.Tree.test;



import com.taylor.LinkedList.Entity.Celebrity;
import com.taylor.LinkedList.Entity.PeopleBox;
import com.taylor.Tree.ThreadBinaryTree;

import java.util.Arrays;

public class ThreadBinaryTest {
    public static void main(String[] args) {
        ThreadBinaryTree<Celebrity> tree1= new ThreadBinaryTree<Celebrity>();
        Celebrity[] celebrityBox = PeopleBox.celebrityBox;
        Arrays.sort(celebrityBox);
        tree1.infixOrderSaveArray(celebrityBox);
        tree1.infixOrderTraverse();
//        ThreadBinaryTree.Node<Celebrity> root = tree1.getRoot();

    }
}
