package com.algorithms.leetcode.dfs;

public class TargetPathSum {
    public boolean hasPath(TreeNode<Integer> treeNode, int target){
        if(treeNode == null) return false;
        if(treeNode.val - target == 0 && treeNode.left == null && treeNode.right == null )
            return true;

        return hasPath(treeNode.left, target-treeNode.val) ||
                hasPath(treeNode.right, target- treeNode.val);
    }
}
