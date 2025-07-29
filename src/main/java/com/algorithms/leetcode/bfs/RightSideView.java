package com.algorithms.leetcode.bfs;

import com.algorithms.leetcode.dfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
    Given the root of a binary tree, imagine yourself standing on the right side of it,
     return the values of the nodes you can see ordered from top to bottom.

    Example 1:

    Input: root = [1,2,3,null,5,null,4]

    Output: [1,3,4]
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++){
                TreeNode<Integer> current = queue.poll();
                if(i == levelSize -1) list.add(current.getVal());
                if(current.getLeft() != null) queue.offer(current.getLeft());
                if(current.getRight() != null) queue.offer(current.getRight());
            }
        }
        return list;
    }
}
