package com.scl.z.linked;

import com.scl.ListNode;

import java.util.Stack;

/**
 * 回文结构
 *
 * @author : scl
 * @date :  2022/9/18
 */
public class PalindromicLinked {
    public static void main(String[] args) {
//        SinglyLinked listNode = new SinglyLinked(1, new SinglyLinked(2, new SinglyLinked(3, new SinglyLinked(2, new SinglyLinked(1)))));
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println("isPalindrome(listNode) = " + isPalindrome2(listNode));
    }
    /*
    给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
    示例 1：
    输入：head = [1,2,2,1]
    输出：true
    示例 2：
    输入：head = [1,2]
    输出：false
    提示：
    链表中节点数目在范围[1, 105] 内
    0 <= Node.val <= 9
     */

    public static boolean isPalindrome(ListNode head) {
        ListNode temp1 = head;
        ListNode temp2 = head;
        Stack<Integer> stack = new Stack<Integer>();
        while (temp1 != null) {
            if (temp2 != null) {
                if (temp2.next == null) {
                    temp1 = temp1.next;
                    temp2 = null;
                    continue;
                }
                stack.push(temp1.val);
                temp1 = temp1.next;
                temp2 = temp2.next.next;
            } else {
                if (temp1.val != stack.pop()) {
                    return Boolean.FALSE;
                }
                temp1 = temp1.next;
            }
        }
        return Boolean.TRUE;
    }

    //1 2 2 1
    public static boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode midNode = endOfFirstHalf(head);
        ListNode last = reverseList(midNode.next);
        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = last;
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
//        // 还原链表并返回结果
//        midNode.next = reverseList(last);
        return Boolean.TRUE;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    private static ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            //找到前半段
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public boolean isPalindrome3(ListNode head) {
        if(head==null) {
            return false;
        }
        ListNode p=head;
        ListNode q=head;
        while(p.next!=null&&p.next.next!=null){
            p=p.next.next;
            q=q.next;
        }
        p=null;
        while(q!=null){
            ListNode r=q.next;
            q.next=p;
            p=q;
            q=r;
        }
        while(p!=null&&head!=null){
            if(p.val!=head.val)
                return false;
            p=p.next;
            head=head.next;
        }
        return true;
    }

}