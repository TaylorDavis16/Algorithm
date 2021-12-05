package com.taylor.Tree;

import com.taylor.Tree.BinarySearchTree.Node;

public class TreeHelper {
    
    public static <T extends Comparable<T>> boolean isValidBST(BinarySearchTree<T> BST){
        return isValidBST(BST.getRoot(), null,null);
    }
    
    private static <T extends Comparable<? super T>> boolean isValidBST(Node<T> node, Node<T> min, Node<T> max) {
        if (node == null) return true;
        if (min != null && node.data.compareTo(min.data) <= 0) return false;
        if (max != null && node.data.compareTo(max.data) >= 0) return false;
        return isValidBST(node.left, min, node) && isValidBST(node.right, node, max);
    }

    public static <T extends Comparable<T>> boolean contains(BinarySearchTree<T> BST, T target){
        return contains(BST.getRoot(),target);
    }
    
    private static <T extends Comparable<? super T>> boolean contains(Node<T> node, T target){
        if (node==null) return false;
        if (node.data.compareTo(target)==0) return true;
        return contains(node.data.compareTo(target)>0 ? node.left : node.right, target);
    }
    
    public static <T extends Comparable<T>> String preOrderSerialize(BinarySearchTree<T> BST){
        Node<T> root = BST.getRoot();
        if (root==null) return "null";
        StringBuilder sb = new StringBuilder();
        preOrderSerialize(root, sb);
        return sb.toString();
    }
    
    private static <T extends Comparable<? super T>> void preOrderSerialize(Node<T> node, StringBuilder sb){
        if (node==null){
            sb.append("#,");
        }else {
            sb.append(node.data.toString()).append(",");
            preOrderSerialize(node.left, sb);
            preOrderSerialize(node.right, sb);
        }
    }

    public static <T extends Comparable<T>> String infixOrderSerialize(BinarySearchTree<T> BST){
        Node<T> root = BST.getRoot();
        if (root==null) return "#";
        StringBuilder sb = new StringBuilder();
        infixOrderSerialize(root, sb);
        return sb.toString();
    }

    private static <T extends Comparable<? super T>> void infixOrderSerialize(Node<T> node, StringBuilder sb){
        if (node==null){
            sb.append("#,");
        }else {
            infixOrderSerialize(node.left, sb);
            sb.append(node.data.toString()).append(",");
            infixOrderSerialize(node.right, sb);
        }
    }

    public static <T extends Comparable<T>> String postOrderSerialize(BinarySearchTree<T> BST){
        Node<T> root = BST.getRoot();
        if (root==null) return "null";
        StringBuilder sb = new StringBuilder();
        postOrderSerialize(root, sb);
        return sb.toString();
    }

    private static <T extends Comparable<? super T>> void postOrderSerialize(Node<T> node, StringBuilder sb){
        if (node==null){
            sb.append("#,");
        }else {
            infixOrderSerialize(node.left, sb);
            infixOrderSerialize(node.right, sb);
            sb.append(node.data.toString()).append(",");
        }
    }
}
