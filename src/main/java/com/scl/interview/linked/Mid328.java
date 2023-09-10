package com.scl.interview.linked;

/**
 * 奇偶链表
 *
 * @author : scl
 * @date :  9/9/2023
 */
public class Mid328 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode listNode = new ListNode(nums[0]);
        ListNode listNode2 = listNode;
        for (int i = 1; i < nums.length; i++) {
            listNode.next = new ListNode(nums[i]);
            listNode = listNode.next;
        }
        System.out.println("oddEvenList(listNode) = " + oddEvenList2(listNode2));
    }
    /*
    给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
    第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
    请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
    你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
    示例 1:
    输入: head = [1,2,3,4,5]
    输出: [1,3,5,2,4]
    示例 2:
    输入: head = [2,1,3,5,6,4,7]
    输出: [2,3,6,7,1,5,4]
    提示:
    n ==  链表中的节点数
    0 <= n <= 104
    -106 <= Node.val <= 106
    */

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode lastNode = new ListNode();
        ListNode lastNode1 = lastNode;
        ListNode node = head;
        ListNode pre = new ListNode();
        while (head != null) {
            if (head.next == null) {
                lastNode.next = null;
                break;
            }
            ListNode temp = head.next;
            head.next = head.next.next;
            pre = head;
            head = head.next;
            lastNode.next = temp;
            lastNode = lastNode.next;
        }
        if (head == null) {
            pre.next = lastNode1.next;
        } else {
            head.next = lastNode1.next;
        }
        return node;
    }

    public static ListNode oddEvenList2(ListNode head) {
        if (head == null) {
            return head;
        }
        //偶数链表的头节点
        ListNode evenHead = head.next;
        //偶数节点
        ListNode even = evenHead;
        //奇数节点
        ListNode odd = head;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}