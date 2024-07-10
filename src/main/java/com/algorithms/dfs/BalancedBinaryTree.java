package com.algorithms.dfs;

/*
  Find out if a binary tree is height balanced or not.

  Bruteforce DFS:-
    It's balanced only if the height of left subtree and right subtree is less than or equal to 1
    and also if each sub parent is height balanced.
    So we can find out if height(leftsubtree - rightsubtree) <=1 && leftsubtree is balanced && right is balanced

    In this case we are running one recursion to find out if a subtree is balanced
    Also we are running another recursion to get the height of each subtree
    which leads to time complexity of O(n^2).
 */
public class BalancedBinaryTree {

    boolean isBalanced(TreeNode<Integer> treeNode) {

        //Base case if the node is null, then return true, because the height is less than 1
        if(treeNode == null ) return true;

        var ln = treeNode.left;
        var rn = treeNode.right;

        int leftHeight = height(ln);
        int rightHeight = height(rn);

        // height of left subtree - right subtree and if both right and left subtree is balanced
        return Math.abs(leftHeight - rightHeight) <= 1
                && isBalanced(ln)
                && isBalanced(rn);
    }

    int height(TreeNode<Integer> treeNode) {
        //base case
        if(treeNode == null) return 0;

        return 1 + Math.max(height(treeNode.left), height(treeNode.right));
    }

    /*
        Efficient approach would be to return the height of the subtree in one recursion
        So 1 recursion for left subtree and we return -1 if the tree is not balanced
        otherwise return the height i.e. height(left subtree - right subtree)

        Run similar recursion for right subtree.

        So we visit each element once in this way which gives complexity as O(n)
     */

    static int isBalanced2(TreeNode<Integer> treeNode) {
        //base case
        if (treeNode == null)
            return 0;

        //Get height of left subtree
        int lh = isBalanced2(treeNode.left);

        if(lh == -1)
            return -1;

        int rh = isBalanced2(treeNode.right);

        if(rh == -1)
            return -1;

        if (Math.abs(lh - rh) > 1)
            return -1;
        else
            return 1 + Math.abs(lh - rh);


    }

}
