package com.algorithms.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 Given the root of a binary tree, return the level order traversal of its nodes' values.
 (i.e., from left to right, level by level).
 */
public class BSTLevelOrderTraversal {

    /*
        Queue based approach:
            Add all the current level values from top -> bottom to the queue.
            The size of the queue determines the number of elements in the current level.
            Create an empty list for each level and add all the non-null elements in the current level.
            Add the left and right nodes (if non-null) to the queue for next iteration.
     */
    public List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            List<Integer> sublist = new ArrayList<>();

            for (int i = 0; i < levelCount; i++) {
                TreeNode<Integer> node = queue.poll();
                sublist.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(sublist);
        }
        return result;
    }
}
