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
        linkedList.add(new SingleNode("1", "1value"));
        linkedList.add(new SingleNode("2", "2value"));
        linkedList.add(new SingleNode("3", "3value"));
        linkedList.add(new SingleNode("4", "4value"));
        linkedList.add(new SingleNode("5", "5value"));
        linkedList.add(new SingleNode("6", "6value"));

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
        SingleNode head = linkedList.head;
        SingleLinkedList reverseLinkedList = new SingleLinkedList();
        SingleNode reverseHead = reverseLinkedList.head;
        while (head.next != null) {
            SingleNode temp = head.next;
            head.next = head.next.next;
            SingleNode reverseTemp = reverseHead.next;
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

        Stack<SingleNode> singleNodes = new Stack<SingleNode>();
        SingleNode singleNode = linkedList.head;
        while (singleNode.next != null) {
//            nodes.add(node.next); 意思相同 来自不同类
            singleNodes.push(singleNode.next);
            singleNode = singleNode.next;
        }
        for (int size = singleNodes.size(); size > 0; size--) {
            System.out.println(singleNodes.pop());
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

    private static SingleNode method2(SingleLinkedList linkedList, int k) {
        int index = 0;
        int length = linkedList.getLength();
        SingleNode singleNode = linkedList.head.next;
        while (singleNode != null) {
            if (k == (length - index)) {
                return singleNode;
            } else {
                singleNode = singleNode.next;
                index++;
            }
        }
        return singleNode;
    }
}