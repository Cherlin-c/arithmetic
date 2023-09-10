package com.scl.interview.linked;

/**
 * 反转链表
 *
 * @author : scl
 * @date :  9/9/2023
 */
public class Easy206 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 7, 1, 2, 6};
        ListNode listNode = new ListNode(nums[0]);
        ListNode listNode2 = listNode;
        for (int i = 1; i < nums.length; i++) {
            listNode.next = new ListNode(nums[i]);
            listNode = listNode.next;
        }
        System.out.println("reverseList(listNode) = " + reverseList(listNode2));
    }

    /*
    给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

    示例 1：
    输入：head = [1,2,3,4,5]
    输出：[5,4,3,2,1]
    示例 2：
    输入：head = [1,2]
    输出：[2,1]
    示例 3：
    输入：head = []
    输出：[]
    提示：
    链表中节点的数目范围是 [0, 5000]
    -5000 <= Node.val <= 5000
    进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
    */

    public static ListNode reverseList(ListNode head) {
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

    /**
     * 递归
     **/
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}