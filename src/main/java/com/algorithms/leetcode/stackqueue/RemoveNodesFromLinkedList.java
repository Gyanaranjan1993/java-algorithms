package com.algorithms.leetcode.stackqueue;

import com.algorithms.leetcode.ListNode;

import java.util.Stack;

/*
    Problem Statement
    Given the head node of a singly linked list, modify the list such that any node that has a node with a greater value to its right gets removed. The function should return the head of the modified list.

    Examples:

    Input: 5 -> 3 -> 7 -> 4 -> 2 -> 1
    Output: 7 -> 4 -> 2 -> 1
    Explanation: 5 and 3 are removed as they have nodes with larger values to their right.

    Input: 1 -> 2 -> 3 -> 4 -> 5
    Output: 5
    Explanation: 1, 2, 3, and 4 are removed as they have nodes with larger values to their right.
 */
public class RemoveNodesFromLinkedList {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while(current != null){
            if(stack.isEmpty()) stack.push(current);
            else {
                while(!stack.isEmpty() || stack.peek().val <= current.val){
                    stack.pop();
                }
                if(!stack.isEmpty()) stack.peek().next = current;
                stack.push(current);
                current = current.next;
            }
        }

        return stack.isEmpty() ? null : stack.get(0);

    }
}
