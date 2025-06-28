package com.algorithms.dfs;

public class BalancedTree {

    int height(TreeNode root) {
        if(root == null)
            return -1;
        int lh = height(root.left);
        if(lh == -1)
            return -1;
        int rh = height(root.right);
        if(rh == -1)
            return -1;
        if(Math.abs(lh - rh) > 1)
            return -1;
        else
            return 1 + Math.abs(lh - rh);
    }
}
