package com.algorithms.leetcode.dfs;

import com.algorithms.leetcode.TreeNode;

public class InvertBinaryTree {
    public TreeNode<Integer> invertTree(TreeNode<Integer> root) {
        if(root != null && (root.getLeft() != null || root.getRight() != null )) {
            TreeNode left = root.getLeft();
            TreeNode right = root.getRight();

            TreeNode temp = right;
            right = left;
            left = temp;

            invertTree(left);
            invertTree(right);
        }

        return root;
    }
}
