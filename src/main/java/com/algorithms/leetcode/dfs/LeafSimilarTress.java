package com.algorithms.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/*
Consider all the leaves of a binary tree, from left to right order,
the values of those leaves form a leaf value sequence.
 */
public class LeafSimilarTress {
    public boolean leafSimilar(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        List<Integer> leafs1 = new ArrayList<>();
        List<Integer> leafs2 = new ArrayList<>();
        addLeafNodes(root1, leafs1);
        addLeafNodes(root2, leafs2);
        return leafs1.equals(leafs2);
    }


    private void addLeafNodes(TreeNode<Integer> root, List<Integer> leafs){
        if(root == null) return;
        if(root.left == null && root.right ==  null){
            leafs.add(root.val);
            return;
        }
        addLeafNodes(root.left, leafs);
        addLeafNodes(root.right, leafs);
    }
}
