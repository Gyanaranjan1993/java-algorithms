package com.algorithms.leetcode;

/*
    Find out the lowest common ancestor of any two given nodes in a BST.
 */
public class LowestCommonAncestorOfBST {

    /*
        LCA is the lowest node that has both P n Q as descendants.

        So given a root, if both P & Q are greater than the root, then we know they lie in the right half
        if they both are smaller than the root, then we know thy lie in the left half.
        in case the root's value is in between P and Q then we know that root is the LCA.
     */

    public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {

        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);

        while(root != null){
            if(root.val > max)
                root = root.left;
            else if(root.val < min)
                root = root.right;
            else
                return root;
        }

        return null;
    }

}
