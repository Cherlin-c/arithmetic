package com.scl.z.linked;

import com.scl.ListNode;

import java.util.HashSet;

/**
 * 找到第一个相交的节点位置
 *
 * @author : scl
 * @date :  2022/9/19
 */
public class FindFirstIntersectNode {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(21, new ListNode(22, new ListNode(32, new ListNode(34, new ListNode(41)))));
        ListNode head1 = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(7, listNode)))));
        ListNode head2 = new ListNode(2, new ListNode(6, new ListNode(10, listNode)));
        System.out.println("getLoop2Node(head1,head2) = " + get2NoLoopNode(head1, head2));
        System.out.println("getLoop2Node2(head1,head2) = " + get2NoLoopNode2(head1, head2));
        ListNode headCircle = new ListNode(10);
        ListNode listNode2 = new ListNode(21, new ListNode(22, new ListNode(32, new ListNode(34, new ListNode(41, headCircle)))));
        headCircle.next = listNode2;
        ListNode head3 = new ListNode(2, new ListNode(6, headCircle));
        System.out.println("getLoopNode2(head1) = " + getLoopNode2(head1));
        System.out.println("getLoopNode2(head1) = " + getLoopNode2(head3));
        System.out.println("getLoopNode3(head1) = " + getLoopNode3(head3));
    }

    /**
     * 找到两个无环的相交节点
     **/
    private static ListNode get2NoLoopNode(ListNode head1, ListNode head2) {
        HashSet<ListNode> nodes = new HashSet<ListNode>();
        while (head1 != null) {
            nodes.add(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            if (nodes.contains(head2)) {
                return head2;
            }
            head2 = head2.next;
        }
        return null;
    }

    /**
     * 找到两个无环的相交节点
     * 不用HASH
     **/
    private static ListNode get2NoLoopNode2(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode temp1 = head1;
        int length1 = 1;
        while (temp1.next != null) {
            length1++;
            temp1 = temp1.next;
        }
        ListNode temp2 = head2;
        int length2 = 1;
        while (temp2.next != null) {
            length2++;
            temp2 = temp2.next;
        }
        if (temp1 != temp2) {
            //最后一个值不相等 肯定不相交
            return null;
        }
        boolean oneMax = length1 > length2;
        temp1 = head1;
        temp2 = head2;
        if (oneMax) {
            return findIntersect(temp2, run(temp1, length1 - length2));
        } else {
            return findIntersect(temp1, run(temp2, length2 - length1));
        }
    }

    private static ListNode run(ListNode head, int step) {
        for (int i = 0; i < step; i++) {
            head = head.next;
        }
        return head;
    }

    private static ListNode findIntersect(ListNode head1, ListNode head2) {
        while (head1 != null) {
            if (head1.equals(head2)) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }


    /**
     * 找到两个有环的相交节点
     * 不用HASH
     **/
    private static ListNode get2LoopNode2(ListNode head1, ListNode head2) {
        ListNode loop1 = getLoopNode3(head1);
        ListNode loop2 = getLoopNode3(head2);
        if (loop1 == loop2) {
            //在直线的时候就相交了
            return get2NoLoopNode2(head1, head2);
        }
        ListNode temp1 = loop1.next;
        while (temp1 != loop1) {
            if (temp1 == loop2) {
                //在环里面相交啦
                return temp1;
            }
            temp1 = temp1.next;
        }
        //转了一大圈都没相交就没有交点啦
        return null;
    }

    /**
     * 一个单链表的环形初始点
     **/
    private static ListNode getLoopNode2(ListNode head) {
        HashSet<ListNode> nodes = new HashSet<ListNode>();
        while (head != null) {
            if (nodes.contains(head)) {
                head.next = null;
                return head;
            }
            nodes.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     * 一个单链表的环形初始点
     **/
    private static ListNode getLoopNode3(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        Boolean isLoop = Boolean.FALSE;
        //找到快慢指针第一个相遇点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                //相遇了有相交
                isLoop = Boolean.TRUE;
                break;
            }
        }
        if (isLoop) {
            fast = head;
            while (true) {
                //再次相遇即第一个环形点
                if (fast.equals(slow)) {
//                    fast.next = null;
                    return fast;
                }
                slow = slow.next;
                fast = fast.next;
            }
        }
        return null;
    }

}