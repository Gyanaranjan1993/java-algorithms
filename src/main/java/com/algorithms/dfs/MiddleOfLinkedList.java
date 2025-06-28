package com.algorithms.dfs;

import com.algorithms.leetcode.ListNode;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode slowNode = head;
        ListNode fastNode = head;

        while(fastNode != null || fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        return slowNode;
    }
}
