package com.scl.leetbook;

import com.scl.ListNode;

import java.util.Arrays;

/**
 * 从尾到头打印链表
 *
 * @author : scl
 * @date :  2022/9/11
 */
public class Offer_6 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println("reversePrint(listNode) = " + Arrays.toString(reversePrint(listNode)));
    }

    /*
    输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
    示例 1：
    输入：head = [1,3,2]
    输出：[2,3,1]
    限制：
    0 <= 链表长度 <= 10000
     */

    public static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int[] ints = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            ints[i] = head.val;
            head = head.next;
        }
        return ints;
    }
//

}

