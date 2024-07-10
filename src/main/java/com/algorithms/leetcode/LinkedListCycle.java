package com.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {

        if(head.next == null) return true;

        List<ListNode> visitedNodes = new ArrayList<>();

        while(head != null) {
            if(visitedNodes.contains(head)){
                return true;
            }
            visitedNodes.add(head);
            head = head.next;
        }
        return false;
    }

    /*
        Floyd's Tortoise and Hare algorithm, also known as the slow and fast pointers approach,
        is used to detect cycles in a linked list. The main idea is to use two pointers moving at
        different speeds through the linked list. If there is a cycle in the list,
        the fast pointer will eventually meet the slow pointer.
     */

    static boolean hasCycle2(ListNode head) {
        if(head == null || head.next == null)
            return false;

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null ) {
            if(slow == fast)
                return true;

            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = listNode;

        boolean a = hasCycle(listNode);
    }
}
