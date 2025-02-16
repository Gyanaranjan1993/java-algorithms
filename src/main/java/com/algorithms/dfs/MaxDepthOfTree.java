package com.algorithms.dfs;

import java.util.Stack;

public class MaxDepthOfTree {

    //Using recursion
    public int maxDepth(TreeNode treeNode) {
        if (treeNode == null)
            return 0;

        return 1 + Math.max(maxDepth(treeNode.left), maxDepth(treeNode.right));
    }

    //Using normal loop and a stack
    public int maxDepthUsingStack(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int max = 0;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int temp = value.pop();
            max = Math.max(temp, max);
            if(node.left != null) {
                stack.push(node.left);
                value.push(temp+1);
            }
            if(node.right != null) {
                stack.push(node.right);
                value.push(temp+1);
            }
        }
        return max;
    }
}
