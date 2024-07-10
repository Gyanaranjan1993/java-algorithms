package com.algorithms.leetcode;

public class DiameterOfBinaryTree {
    private int maxDiam= 0;
    public int diameterOfBinaryTree(TreeNode root) {

        /*
            Diameter of binary tree is maximum depth of left subtree + maximum depth of right subtree
            And the root node need not be included.

            So we calculate diameter of each node. Keep a max diameter which will be updated when the
            current node diameter is more than the  max diameter.
         */

        return maxDiam(root);
    }

    private int maxDiam(TreeNode root) {
        if(root == null)
            return 0;

        int leftDepth = maxDiam(root.left);
        int rightDepth = maxDiam(root.right);

        int currDiameter = leftDepth + rightDepth;
        maxDiam = Math.max(maxDiam, currDiameter);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
