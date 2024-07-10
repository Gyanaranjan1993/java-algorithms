package com.algorithms.dfs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

/*
    A node in a tree is called visible tree node if the value of the node is highest in its path from
    the root.
    A single node tree has one visible node because it is the highest node by itself
    Calculate the number of visible nodes in a given tree.
 */
public class VisibleTreeNode {
    public static int numberOfVisibleNodes(TreeNode<Integer> treeNode, int maxValue){

        if (treeNode == null) return 0;
        int total = 0;

        if(treeNode.val >= maxValue) {
            total++;
        }

        total += numberOfVisibleNodes(treeNode.left, Math.max(maxValue, treeNode.val));
        total += numberOfVisibleNodes(treeNode.right, Math.max(maxValue, treeNode.val));

        return total;
    }

    public static <T> TreeNode<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        if (val.equals("x")) return null;
        TreeNode<T> left = buildTree(iter, f);
        TreeNode<T> right = buildTree(iter, f);
        return new TreeNode<T>(f.apply(val), left, right);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        scanner.close();
        int res = numberOfVisibleNodes(root, Integer.MIN_VALUE);
        System.out.println(res);
    }

}
