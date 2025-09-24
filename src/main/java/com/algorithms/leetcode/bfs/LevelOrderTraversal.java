package com.algorithms.leetcode.bfs;

import com.algorithms.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//O(N) because we traverse each node once
public class LevelOrderTraversal {
    public List<List<Integer>> traverse(TreeNode<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<>(levelSize);
            for(int i = 0; i < levelSize; i++) {
                TreeNode<Integer> current = queue.poll();
                list.add(current.getVal());
                if(current.getLeft() != null) queue.offer(current.getLeft());
                if(current.getRight() != null) queue.offer(current.getRight());
            }
            result.add(list);
        }
        return result;
    }
}
