package com.algorithms.leetcode.dfs;

public class LCAOfBinaryTree {
/*
    The LCA is the lowest node in the tree
     that has both p and q as descendants (a node can be a descendant of itself).

     We define a recursive function that does the following for each node:

        If the node is null, return null.

        If the node equals p or q, return the node.

        Recurse left and right.

        If both left and right are not null → this node is the LCA.

        If only one is not null → propagate that node upward.
 */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null)
            return root;
        return (left != null ? left: right);
    }
}
