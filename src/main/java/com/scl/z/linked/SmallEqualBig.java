package com.scl.z.linked;

import com.scl.ListNode;

/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 *
 * @author : scl
 * @date :  2022/9/18
 */
public class SmallEqualBig {

    public static void main(String[] args) {
        int pivot = 3;
        ListNode linked = new ListNode(1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(1)))));
        System.out.println("listPartition1(linked,pivot) = " + listPartition1(linked, pivot));
    }

    public static ListNode listPartition1(ListNode head, int pivot) {
        if (head == null || head.next == null) {
            return head;
        }
        //求长度
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        ListNode[] linkedArr = new ListNode[length];
        length = 0;
        current = head;
        while (current != null) {
            linkedArr[length++] = current;
            current = current.next;
        }
        int l = -1;
        int r = length;
        int index = 0;
        while (index < r) {
            if (linkedArr[index].val < pivot) {
                ListNode left = linkedArr[++l];
                linkedArr[l] = linkedArr[index];
                linkedArr[index] = left;
            } else if (linkedArr[index].val > pivot) {
                ListNode right = linkedArr[--r];
                linkedArr[r] = linkedArr[index];
                linkedArr[index] = right;
                continue;
            }
            index++;
        }
        for (int i = 1; i < linkedArr.length; i++) {
            linkedArr[i - 1].next = linkedArr[i];
        }
        linkedArr[length - 1].next = null;
        return linkedArr[0];
    }

    public static ListNode listPartition2(ListNode head, int pivot) {
        ListNode sH = null;
        ListNode sT = null;
        ListNode eH = null;
        ListNode eT = null;
        ListNode bH = null;
        ListNode bT = null;
        ListNode next;
        while (head != null) {
            //单独取出来
            next = head.next;
            head.next = null;
            if (head.val < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sH.next = head;
                    sT = head;
                }
            } else if (head.val == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eH.next = head;
                    eT = head;
                }
            } else if (head.val > pivot) {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bH.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        if (sH != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;

        }
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : (eH != null ? eH : bH);
    }

    /*
    【题目】给定一个单链表的头节点head，节点的值类型是整型，再给定一个整数pivot。
    实现一个调整链表的函数，将链表调整为左部分都是值小于pivot的节点，中间部分都是值等于pivot的节点，右部分都是值大于pivot的节点。
    【进阶】在实现原问题功能的基础上增加如下的要求
    【要求】调整后所有小于pivot的节点之间的相对顺序和调整前一样
    【要求】调整后所有等于pivot的节点之间的相对顺序和调整前一样
    【要求】调整后所有大于pivot的节点之间的相对顺序和调整前一样
    【要求】时间复杂度请达到O(N)，额外空问复杂度请达到0(1)。
     */
}