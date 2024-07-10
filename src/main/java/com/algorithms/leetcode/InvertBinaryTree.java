package com.algorithms.leetcode;

public class InvertBinaryTree {
    public TreeNode<Integer> invertTree(TreeNode<Integer> root) {
        if(root != null && (root.left != null || root.right != null )) {
            TreeNode left = root.left;
            TreeNode right = root.right;

            TreeNode temp = right;
            right = left;
            left = temp;

            invertTree(left);
            invertTree(right);
        }

        return root;
    }
}
