package com.scl.hot100.link;

import com.scl.ListNode;

/**
 * 21. 合并两个有序链表
 *
 * @author : scl
 * @date :  2022/8/17
 */
public class Easy21 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2, new ListNode(3, new ListNode(4)));
        ListNode listNode2 = new ListNode(1, new ListNode(2, new ListNode(4)));
//        SinglyLinked listNode1 = new SinglyLinked();
//        SinglyLinked listNode2 = new SinglyLinked(1);
        ListNode listNode = mergeTwoLists2(listNode1, listNode2);
        System.out.println(listNode);
    }

    //呜呜呜 不是人做的呀
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    //呜呜呜 不是人做的呀
    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode();
        ListNode temp = listNode;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                temp.next = list2;
                list2 = list2.next;
            } else {
                temp.next = list1;
                list1 = list1.next;
            }
            temp = temp.next;
        }
        temp.next = list1 == null ? list2 : list1;
        return listNode.next;
    }

}