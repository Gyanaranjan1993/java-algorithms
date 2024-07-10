package com.algorithms.leetcode;

/*
    Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode reverseHead = null;

        while(head != null){
            ListNode temp = new ListNode(head.val);
            temp.next = reverseHead;
            reverseHead = temp;
            head = head.next;
        }

        return reverseHead;
    }

    public static void main(String[] args) {

    }
}
