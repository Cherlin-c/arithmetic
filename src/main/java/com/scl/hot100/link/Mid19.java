package com.scl.hot100.link;

import com.scl.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * @author : scl
 * @date :  2022/8/16
 */
public class Mid19 {
    /*
        给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
        输入：head = [1,2,3,4,5], n = 2
        输出：[1,2,3,5]
        输入：head = [1], n = 1
        输出：[]
        输入：head = [1,2], n = 1
        输出：[1]
        提示：
        链表中结点的数目为 sz
        1 <= sz <= 30
        0 <= Node.val <= 100
        1 <= n <= sz
     */

    public static void main(String[] args) {
//        SinglyLinked listNode = new SinglyLinked(1, new SinglyLinked(2, new SinglyLinked(3, new SinglyLinked(4))));
        ListNode listNode = new ListNode(1, new ListNode(2));
        System.out.println("removeNthFromEnd(listNode,2) = " + removeNthFromEnd(listNode, 1));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newList = new ListNode(0, head);
        int i = 1;
        ListNode temp = head;
        while (temp.next != null) {
            i++;
            temp = temp.next;
        }
        ListNode temp2 = newList;
        for (int j = 1; j <= i; j++) {
            if (i - j == n - 1) {
                temp2.next = temp2.next.next;
                break;
            }
            temp2 = temp2.next;
        }
        head = newList.next;
        return head;
    }
}
