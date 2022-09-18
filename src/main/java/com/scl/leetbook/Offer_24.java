package com.scl.leetbook;

import com.scl.ListNode;

/**
 * 反转链表
 *
 * @author : scl
 * @date :  2022/9/11
 */
public class Offer_24 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println("reversePrint(listNode) = " + reverseList(listNode));

    }

    public static ListNode reverseList(ListNode head) {
        ListNode listNode = new ListNode(0);
        while (head != null) {
            ListNode temp = listNode.next;
            listNode.next = new ListNode(head.val);
            listNode.next.next = temp;
            head = head.next;

        }
        return listNode.next;
    }


    public static ListNode reverseList2(ListNode head) {
        return recur(head, null);
    }


    public static ListNode recur(ListNode current, ListNode pre) {
        if (current == null) {
            return pre;
        }
        ListNode listNode = recur(current.next, current);
        current.next = pre;
        return listNode;
    }

}