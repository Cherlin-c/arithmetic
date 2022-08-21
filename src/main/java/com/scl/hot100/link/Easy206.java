package com.scl.hot100.link;

/**
 * 反转链表
 *
 * @author : scl
 * @date :  2022/8/19
 */
public class Easy206 {
    /*
    给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
    输入：head = [1,2,3,4,5]
    输出：[5,4,3,2,1]

    进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
    Related Topics
    递归
    链表
     */

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("solution(listNode) = " + solution1(listNode));
    }

    private static ListNode solution1(ListNode head) {
        ListNode reverseNode =null;
        while (head != null) {
            ListNode temp2 = reverseNode;
            reverseNode = head;
            head = head.next;
            reverseNode.next = temp2;
        }
        return reverseNode;
    }

    public static ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //递归脑壳痛
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

//    private static ListNode solution2(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode temp = new ListNode();
//        temp.next = solution2(head.next);
//        return temp.next;
//    }

}

class ListNode {
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

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}