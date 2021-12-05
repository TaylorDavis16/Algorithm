package com.taylor.Tree.test;


import com.taylor.Tree.BinarySearchTree;
import com.taylor.Tree.TreeHelper;

public class BSTTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> intBST=new BinarySearchTree<>();
//        Integer[] integers={2,5,6,8,3,9,7,0,12,10,6};
        Integer[] integers={4,2,1,3,6,5,7};
//        Integer[] integers={2,4,1,3,5,6,7};
        Integer[] array1={0,8,5,1,2,3,7,4,9};
        Integer[] array2={4, 1, 0, 2, 3, 7, 5, 8, 9};
        Integer[] array3={6,3,0,9,1,7,2,5};
        Integer[] array4={3, 1, 0, 2, 6, 5, 7, 9};
        intBST.add(array2);
//        intBST.remove(10);

//        intBST.remove(0);
//        System.out.println(intBST.getRoot());
//        intBST.remove(7);
//        System.out.println(intBST.getRoot());
//        intBST.remove(8);
//        System.out.println(intBST.getRoot());
//        intBST.remove(3);
//        System.out.println(intBST.getRoot());
//        intBST.remove(5);
//        System.out.println(intBST.getRoot());
//        intBST.remove(6);
//        System.out.println(intBST.getRoot());
//        intBST.remove(6);
//        System.out.println(intBST.getRoot());
//        intBST.remove(2);
//        System.out.println(intBST.getRoot());
//        intBST.remove(9);
//        System.out.println(intBST.getRoot());
//        intBST.remove(10);
//        System.out.println(intBST.getRoot());
//        intBST.remove(12);
//        System.out.println(intBST.getRoot());


        intBST.preOrderTraverse();
        System.out.println("--------------------------");
        intBST.infixOrderTraverse();
        System.out.println("--------------------------");
        intBST.postOrderTraverse();
        System.out.println("--------------------------");
        intBST.levelOrderTraverse();
        System.out.println("--------------------------");
        System.out.println("The height of tree is: "+intBST.height());
        System.out.println("The height of left tree is: "+intBST.leftHeight());
        System.out.println("The height of right tree is: "+intBST.rightHeight());
        System.out.println("------------------------------------------");
        String[] months={"Jan","Feb","Mar","Apr","May","June","July","Aug","Sep","Oct","Nov","Dec"};
        BinarySearchTree<String> searchTree=new BinarySearchTree<>();
        searchTree.add(months);
        searchTree.levelOrderTraverse();
//        BinarySearchTree<Celebrity> celebrityBST=new BinarySearchTree<Celebrity>();
//        celebrityBST.add(PeopleBox.celebrityBox);
//        celebrityBST.infixOrderTraverse();

        System.out.println(TreeHelper.isValidBST(intBST));
        System.out.println(TreeHelper.isValidBST(searchTree));
        System.out.println("Have "+5+ TreeHelper.contains(intBST,5));
        System.out.println("Have "+6+ TreeHelper.contains(intBST,6));
        System.out.println("Have Feb "+ TreeHelper.contains(searchTree,"Feb"));
        System.out.println("Have nov "+6+ TreeHelper.contains(searchTree,"nov"));

        System.out.println(TreeHelper.preOrderSerialize(intBST));
        System.out.println(TreeHelper.infixOrderSerialize(intBST));
        System.out.println(TreeHelper.postOrderSerialize(intBST));
    }
}
