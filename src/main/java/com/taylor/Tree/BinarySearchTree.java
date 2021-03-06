package com.taylor.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;
    private int size = 0;

    static class Node<T extends Comparable<? super T>> {
        T data;
        Node<T> left;
        Node<T> right;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + get(left) +
                    ", right=" + get(right) +
                    '}';
        }

        private String get(Node<T> node) {
            return node == null ? null : node.data.toString();
        }
    }

    public BinarySearchTree() {
    }

    public void add(E[] array) {
        for (E value : array) {
            add(value);
        }
    }

    public void add(E value) {
        if (root == null) {
            root = new Node<>(value);
            ++size;
        } else add(value, root);
    }

    protected void add(E value, Node<E> node) {
        if (value.compareTo(node.data)!=0){
            if (value.compareTo(node.data) < 0) {
                if (node.left == null) {
                    node.left = new Node<>(value);
                    ++size;
                } else add(value, node.left);
            } else {
                if (node.right == null) {
                    node.right = new Node<>(value);
                    ++size;
                } else add(value, node.right);
            }
        }
    }

    public void preOrderTraverse() {
        if (root != null) {
            preOrderTraverse(root);
        }
        System.out.println();
    }

    private void preOrderTraverse(Node<E> node) {
        System.out.print(node.data + " ");
        if (node.left != null)
            preOrderTraverse(node.left);
        if (node.right != null)
            preOrderTraverse(node.right);
    }

    public void infixOrderTraverse() {
        if (root != null) {
            infixOrderTraverse(root);
        }
        System.out.println();
    }

    private void infixOrderTraverse(Node<E> node) {
        if (node.left != null)
            infixOrderTraverse(node.left);
        System.out.print(node.data + " ");
        if (node.right != null)
            infixOrderTraverse(node.right);
    }

    public void postOrderTraverse() {
        if (root != null) {
            postOrderTraverse(root);
        }
        System.out.println();
    }

    private void postOrderTraverse(Node<E> node) {
        if (node.left != null)
            postOrderTraverse(node.left);
        if (node.right != null)
            postOrderTraverse(node.right);
        System.out.print(node.data + " ");
    }

    public void levelOrderTraverse() {
        if (root != null) {
            Queue<Node<E>> nodeQueue = new LinkedList<>();
            nodeQueue.offer(root);
            while (!nodeQueue.isEmpty()) {
                Node<E> temp = nodeQueue.poll();
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    nodeQueue.offer(temp.left);
                }
                if (temp.right != null) {
                    nodeQueue.offer(temp.right);
                }
            }
            System.out.println();
        }
    }

    public E[] getLevelOrderAsArray(E[] array) {
        int i = 0;
        if (root != null) {
            Queue<Node<E>> nodeQueue = new LinkedList<>();
            nodeQueue.offer(root);
            while (!nodeQueue.isEmpty()) {
                Node<E> temp = nodeQueue.poll();
                array[i++] = temp.data;
                if (temp.left != null) {
                    nodeQueue.offer(temp.left);
                }
                if (temp.right != null) {
                    nodeQueue.offer(temp.right);
                }
            }
            return array;
        }
        return null;
    }


    /**
     * Find the node that contains the smallest value
     *
     * @param node The started searching node
     * @return The node that contains the smallest value
     */
    private Node<E> findMin(Node<E> node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void remove(E value) {
        root = remove(root, value);
    }

    //????????????????????????????????????????????????

    /**
     * Delete the node that contains value, searching from the current node
     *
     * @param node  The current node
     * @param value The value should be deleted
     * @return The current node itself, which is a node that had its children refreshed
     */
    private Node<E> remove(Node<E> node, E value) {
        if (node == null) {
            return null;
        }
        //??????????????????
        if (value.compareTo(node.data) < 0) {//?????????????????????????????????
            node.left = remove(node.left, value);
        } else if (value.compareTo(node.data) > 0) {//??????????????????????????????????????????????????????
            node.right = remove(node.right, value);
        }//?????????????????????????????????????????????????????????1?????????????????????
        else if (node.left != null && node.right != null) {
            //Find the smallest value in right side
            node.data = findMin(node.right).data;
            //??????????????????????????????
            node.right = remove(node.right, node.data);
        } else {//?????????????????????
            //?????????
            if (node.left == null && node.right == null) {
                node = null;
            } else node = node.left == null ? node.right : node.left;
        }
        return node;
    }

    public Node<E> getRoot() {
        return root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    protected int height(Node<E> node) {
        if (node != null) {
            return Math.max(height(node.left), height(node.right)) + 1;
        }
        return 0;
    }


    public int height() {
        return height(root);
    }

    protected int leftHeight(Node<E> root) {
        return root == null ? 0 : height(root.left);
    }

    public int leftHeight() {
        return leftHeight(root);
    }

    protected int rightHeight(Node<E> root) {
        return root == null ? 0 : height(root.right);
    }

    public int rightHeight() {
        return rightHeight(root);
    }

    private Node<E> searchTarget(E value) {
        if (root != null) {
            return searchTarget(root, value);
        }
        return null;
    }

    private Node<E> searchTarget(Node<E> node, E value) {
        //??????????????????????????????value
        if (node.data.compareTo(value) == 0) {
            return node;
        }//????????????value?????????????????????????????????????????????
        if (value.compareTo(node.data) < 0) {
            return node.left == null ? null : searchTarget(node.left, value);
        }//??????????????????????????????
        else {
            return node.right == null ? null : searchTarget(node.right, value);
        }
    }

    private Node<E> searchParents(E value) {
        if (root != null) {
            return searchParents(root, value);
        }
        return null;
    }

    private Node<E> searchParents(Node<E> node, E value) {
        //?????????????????????????????????????????????????????????????????????????????????????????????
        if ((node.left != null && node.left.data.compareTo(value) == 0)
                || (node.right != null && node.right.data.compareTo(value) == 0)) {
            return node;
        } else {
            //???????????????????????????????????????????????????????????????node??????
            if (value.compareTo(node.data) < 0 && node.left != null) {
                return searchParents(node.left, value);
            }//??????????????????????????????????????????????????????????????????node??????
            else if (value.compareTo(node.data) >= 0 && node.right != null) {
                return searchParents(node.right, value);
            }//?????????????????????
            else return null;
        }
    }
}
