package com.algorithms.leetcode.dfs;

/*
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are
no nodes with a value greater than X.

Return the number of good nodes in the binary tree.
 */
public class NumberOfGoodNodes {
    private int count = 0;
    public int goodNodes(TreeNode<Integer> root) {
        int maxValue = root.val;
        numOfGoodNodes(root, maxValue);
        return count;
    }
    private void numOfGoodNodes(TreeNode<Integer> root, int maxValue){
        if(root == null) return;

        if(root.val >= maxValue){
            count++;
            maxValue = root.val;
        }
        numOfGoodNodes(root.left, maxValue);
        numOfGoodNodes(root.right, maxValue);
    }
}
