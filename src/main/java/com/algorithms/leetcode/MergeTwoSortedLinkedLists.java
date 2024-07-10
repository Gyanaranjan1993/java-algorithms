package com.algorithms.leetcode;

public class MergeTwoSortedLinkedLists {

    private ListNode first;

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

   /*
        Create a Result ListNode with dummy value 0. Keep the reference in another variable (prehead)
        which we will use to retrieve the result because we will move the result node to its next node
        while building the o/p.


        2. Next compare l1.val and l2.val
        3. if l1.val < l2.val -> assign node.next -> l1 and move l1 to l1.next as we are done with current l1 object.
        4. Else assign node.next -> l2 and move l2 to l2.next as we are done with current l2 object.
        5. as we have assigned the right value to current result node , move result to result.next.

        Repeat steps 2-5 until one of l1 or l2 is null.

        When one of l1 or l2 becomes null in the above loop, assign the result node next to the non-null list.
        Because as one list is done, we just need to assign the next of the result node the remainder of the non-null
        list.

        At the end the prehead.next as the initial value is a dummy value and it's only used while creating the
        result node.
    */

    public static ListNode merge(ListNode list1, ListNode list2){

        ListNode resultNode = new ListNode(0);
        ListNode preHead = resultNode;

        while(list1 != null && list2 != null){

            if(list1.val <= list2.val){
                resultNode.next = list1;
                list1 = list1.next;
            } else {
                resultNode.next = list2;
                list2 = list2.next;
            }
            resultNode = resultNode.next;
        }

        if(list1 == null) {
            resultNode.next = list2;
        }

        if(list2 == null) {
            resultNode.next = list1;
        }

        //Also can be simply replaced by
        //resultNode.next = list1 == null ? list2 : list1;

        return preHead.next;

    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode mergedListNode = new ListNode();
        ListNode head = null;

        //Merge
        while (list2 != null || list1 != null) {

            if(head != null){
                mergedListNode.next = new ListNode();
                mergedListNode = mergedListNode.next;
            } else {
                head = mergedListNode;
            }

            if (list1 == null) {
                mergedListNode = list2;
                return head;
            }

            if (list2 == null) {
                mergedListNode = list1;
                return head;
            }

            if (list1.val <= list2.val) {
                mergedListNode.val = list1.val;
                list1 = list1.next;
            } else {
                mergedListNode.val = list2.val;
                list2 = list2.next;
            }
        }

        return head;
    }


    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode first1 = listNode1;
        listNode1.next = new ListNode(2);
        listNode1 = listNode1.next;
        listNode1.next = new ListNode(4);

        ListNode listNode2 = new ListNode(1);
        ListNode first2 = listNode2;
        listNode2.next = new ListNode(3);
        listNode2 = listNode2.next;
        listNode2.next = new ListNode(5);

        ListNode merged = merge(first1, first2);

        System.out.println("Test");

    }
}
