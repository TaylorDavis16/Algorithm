package com.taylor.Tree.test;



import com.taylor.LinkedList.Entity.Celebrity;
import com.taylor.LinkedList.Entity.People;
import com.taylor.LinkedList.Entity.PeopleBox;
import com.taylor.Tree.BinaryTree;
import com.taylor.Tree.SampleTree;

import java.util.Arrays;

public class BinaryTest {
    public static void main(String[] args) {
        BinaryTree<Celebrity> celebrityTree=new BinaryTree<>(SampleTree.TaylorDavis);
        BinaryTree.Node<Celebrity> root=celebrityTree.getRoot();
        celebrityTree.preOrderTraverse();
        System.out.println("---------------------------------");
        celebrityTree.infixOrderTraverse();
        System.out.println("---------------------------------");
        celebrityTree.postOrderTraverse();
        System.out.println("---------------------------------");

        System.out.println("Pre order: id="+8+" "+celebrityTree.preOrderSearch(8,root));
        System.out.println("Pre order: id="+0+" "+celebrityTree.preOrderSearch(0,root));
        System.out.println("Pre order: id="+5+" "+celebrityTree.preOrderSearch(5,root));
        System.out.println("Infix order: id="+8+" "+celebrityTree.infixOrderSearch(8,root));
        System.out.println("Infix order: id="+0+" "+celebrityTree.infixOrderSearch(0,root));
        System.out.println("Infix order: id="+5+" "+celebrityTree.infixOrderSearch(5,root));
        System.out.println("Post order: id="+8+" "+celebrityTree.postOrderSearch(8,root));
        System.out.println("Post order: id="+0+" "+celebrityTree.postOrderSearch(0,root));
        System.out.println("Post order: id="+5+" "+celebrityTree.postOrderSearch(5,root));

        Celebrity[] celebrityBox = PeopleBox.celebrityBox;
        Arrays.sort(celebrityBox);
        BinaryTree<Celebrity> celebrityTree2= new BinaryTree<Celebrity>();

//        celebrityTree2.preOrderSaveArray(celebrityBox);
//        System.out.println("----------------");
//        celebrityTree2.preOrderTraverse();
//
//        celebrityTree2.infixOrderSaveArray(celebrityBox);
//        System.out.println("----------------");
//        celebrityTree2.infixOrderTraverse();

        celebrityTree2.postOrderSaveArray(celebrityBox);
        System.out.println("----------------");
        celebrityTree2.postOrderTraverse();
        System.out.println("----------------");
        People[] array={new People(4),new People(2),
                new People(1),new People(3),
                new People(6),new People(5),new People(7)};

        BinaryTree<People> intTree=new BinaryTree<>();
        intTree.preOrderSaveArray(array);
        System.out.println("haha");
        intTree.preOrderTraverse();
        System.out.println("----------------");
        intTree.infixOrderSaveArray(array);
        intTree.infixOrderTraverse();

        System.out.println("----------------");
        People[] array2={new People(1),new People(3),
                new People(2),new People(6),
                new People(5)};
        intTree.postOrderSaveArray(array2);
        intTree.postOrderTraverse();
        
    }
}
