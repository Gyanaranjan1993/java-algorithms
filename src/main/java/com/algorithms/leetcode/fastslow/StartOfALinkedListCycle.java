package com.algorithms.leetcode.fastslow;

import com.algorithms.leetcode.ListNode;

/**
 * Tortoise Hare algo, find if they have a cycle using both pointers,
 * if there is a cycle, move the slow to head. then move both fast and slow pointer one by one
 * until they both meet.
 */

public class StartOfALinkedListCycle {
    public ListNode solution (ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)  break;
        }

        if(fast == null || fast.next == null) return null;

        slow = head;

        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
