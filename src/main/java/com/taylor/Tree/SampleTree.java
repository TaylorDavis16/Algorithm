package com.taylor.Tree;


import com.taylor.LinkedList.Entity.Celebrity;
import com.taylor.LinkedList.Entity.PeopleBox;

public class SampleTree {
    private static BinaryTree.Node<Celebrity> Somebody = new BinaryTree.Node<>(null, PeopleBox.Somebody, null);
    private static BinaryTree.Node<Celebrity> JayChou = new BinaryTree.Node<>(null, PeopleBox.JayChou, null);
    private static BinaryTree.Node<Celebrity> ArianaGrande = new BinaryTree.Node<>(null, PeopleBox.ArianaGrande, null);
    private static BinaryTree.Node<Celebrity> KatyPerry = new BinaryTree.Node<>(null, PeopleBox.KatyPerry, JayChou);
    private static BinaryTree.Node<Celebrity> MariahCarey = new BinaryTree.Node<>(Somebody, PeopleBox.MariahCarey, KatyPerry);
    private static BinaryTree.Node<Celebrity> Selena = new BinaryTree.Node<>(null, PeopleBox.Selena, ArianaGrande);
    private static BinaryTree.Node<Celebrity> TaylorSwift = new BinaryTree.Node<>(Selena, PeopleBox.TaylorSwift, null);
    public static BinaryTree.Node<Celebrity> TaylorDavis = new BinaryTree.Node<>(MariahCarey, PeopleBox.TaylorDavis, TaylorSwift);

}
