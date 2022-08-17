package com.scl.linkedList.single;

import java.util.Stack;

/**
 * 面试题
 *
 * @author : scl
 * @date :  2022/8/15
 */
public class Interview {
    /*
    1.求单链表的节点个数
    2.查找单链表中倒数第K个节点
    3.单链表的反转
    4.从尾到头打印单链表：要求1反向遍历，2Stack栈
    5.合并两个有序的单链表，合并之后依然有序
     */

    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add(new Node("1", "1value"));
        linkedList.add(new Node("2", "2value"));
        linkedList.add(new Node("3", "3value"));
        linkedList.add(new Node("4", "4value"));
        linkedList.add(new Node("5", "5value"));
        linkedList.add(new Node("6", "6value"));

        //        求单链表的节点个数(不含头节点)
        //    ===========    1 BEGIN    ==============
        System.out.println("==============1================");
        System.out.println("单链表的节点个数(不含头节点) = " + method1(linkedList));
        //    ===========    1 END    ==============

        //        查找单链表中倒数第K个节点
        //    ===========    2 BEGIN    ==============
        System.out.println("==============2================");
        int k = 2;
        System.out.println("单链表中倒数第" + k + "个节点 = " + method2(linkedList, k));
        //    ===========    2 END    ==============

        //        单链表的反转
        //    ===========    3 BEGIN    ==============
        System.out.println("==============3================");
        linkedList.list();
        Node head = linkedList.head;
        SingleLinkedList reverseLinkedList = new SingleLinkedList();
        Node reverseHead = reverseLinkedList.head;
        while (head.next != null) {
            Node temp = head.next;
            head.next = head.next.next;
            Node reverseTemp = reverseHead.next;
            reverseHead.next = temp;
            reverseHead.next.next = reverseTemp;

        }
//        reverseLinkedList.list();
        System.out.println("反转后");
        linkedList = reverseLinkedList;
        linkedList.list();
        //    ===========    3 END    ==============

        //        从尾到头打印单链表：要求1反向遍历，2Stack栈
        //    ===========    4 BEGIN    ==============
        System.out.println("==============4================");

        Stack<Node> nodes = new Stack<Node>();
        Node node = linkedList.head;
        while (node.next != null) {
//            nodes.add(node.next); 意思相同 来自不同类
            nodes.push(node.next);
            node = node.next;
        }
        for (int size = nodes.size(); size > 0; size--) {
            System.out.println(nodes.pop());
        }
        //    ===========    4 END    ==============

        //        合并两个有序的单链表，合并之后依然有序
        //    ===========    5 BEGIN    ==============
        System.out.println("==============5================");

        //    ===========    5 END    ==============
    }

    private static int method1(SingleLinkedList linkedList) {
        return linkedList.getLength();
    }

    private static Node method2(SingleLinkedList linkedList, int k) {
        int index = 0;
        int length = linkedList.getLength();
        Node node = linkedList.head.next;
        while (node != null) {
            if (k == (length - index)) {
                return node;
            } else {
                node = node.next;
                index++;
            }
        }
        return node;
    }
}