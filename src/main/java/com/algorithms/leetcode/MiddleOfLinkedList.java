package com.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {

        //need to get the total size
        //calculate the middle

        if(head.next == null)
            return head;

        List<ListNode> list = new ArrayList<>();

        while(head != null){
            list.add(head);
            head = head.next;
        }
        int count = list.size();

        if(count % 2 == 0){
            return list.get(count/2);
        } else {
            return list.get((count - 1)/2);
        }
    }

    //2 pointer approach
    public ListNode middleNodeUsing2PointerApproach(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }
}
