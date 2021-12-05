package com.taylor.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 有序数组构建AVL树
 */
public class BuildAVLFromArray {
    public static int[] a;
    public static int index;
    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 9, 15, 15, 16, 17, 20, 22, 24};
        a=new int[nums.length];
        TreeNode root = getAVLTree(nums);
        preOrder(root);
        System.out.println("\n-------------------------------");
        levelOrder(root);
        System.out.println(Arrays.toString(a));
    }

    public static TreeNode getAVLTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return getAVLTree(nums, 0, nums.length - 1);
    }

    public static TreeNode getAVLTree(int[] nums, int start, int end) {
        TreeNode root = null;
        if (start <= end) {
            int mid = (start + end) / 2;

            root = new TreeNode(nums[mid]);
            a[index++]=nums[mid];
            root.left = getAVLTree(nums, start, mid - 1);

            root.right = getAVLTree(nums, mid + 1, end);

        }
        return root;
    }


    public static void preOrder(TreeNode node){
        if (node!=null){
            System.out.print(node.val+" ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void levelOrder(TreeNode node){
        if (node!=null){
            Queue<TreeNode> queue=new LinkedList<>();
            queue.offer(node);
            while (!queue.isEmpty()){
                TreeNode treeNode = queue.poll();
                System.out.print(treeNode.val+" ");
                if (treeNode.left!=null)
                    queue.offer(treeNode.left);
                if (treeNode.right!=null)
                    queue.offer(treeNode.right);
            }
            System.out.println();
        }

    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}