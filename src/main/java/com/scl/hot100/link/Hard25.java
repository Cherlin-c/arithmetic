package com.scl.hot100.link;

import com.scl.ListNode;

/**
 * @author : scl
 * @date :  2022/8/19
 */
public class Hard25 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("solution(listNode,2) = " + solution1(listNode, 2));
    }

/*
给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]
输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]
*/

    static ListNode solution1(ListNode head, int k) {
        if (k < 2) {
            return head;
        }
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    static ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }

    static ListNode reverse(ListNode listNode) {
        ListNode result = null;
        //反转
        while (listNode != null) {
            ListNode temp2 = listNode.next;
            listNode.next = result;
            result = listNode;
            listNode = temp2;
        }
        return result;
    }


    static ListNode solution(ListNode listNode, int k) {
        ListNode result = null;
        ListNode resultGroup = null;
        int i = 0;
        ListNode groupLast = null;
        while (listNode != null) {
            if (i == k) {
                if (resultGroup == null) {
                    resultGroup = result;
                } else {
                    groupLast.next = result;
                }
                groupLast = null;
            }

            ListNode temp2 = listNode.next;
            listNode.next = result;
            result = listNode;
            listNode = temp2;
            i++;
            if (groupLast == null) {
                groupLast = listNode;
            }
        }
        return result;
    }

   
}