package com.algorithms.leetcode.dfs;

public class TreeNode<T> {
    T val;

    public T getVal() {
        return val;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode() {
    }

    TreeNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
