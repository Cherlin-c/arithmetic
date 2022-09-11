package com.scl.leetbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 复杂链表的复制
 *
 * @author : scl
 * @date :  2022/9/11
 */
public class Offer_35 {

    public static void main(String[] args) {
        // ======= Test Case =======
        int[] nodesVal = new int[]{7, 13, 11, 10, 1};
        Integer[] nodesRandom = new Integer[]{null, 0, 4, 2, 0};
        // Construct nodes
        List<Node> nodeList = new ArrayList<Node>();
        for (int val : nodesVal) {
            nodeList.add(new Node(val));
        }
        // Build next reference
        for (int i = 0; i < nodesVal.length - 1; i++) {
            nodeList.get(i).next = nodeList.get(i + 1);
        }
        // Build random reference
        for (int i = 0; i < nodesVal.length; i++) {
            if (nodesRandom[i] != null) {
                nodeList.get(i).random = nodeList.get(nodesRandom[i]);
            }
        }
        // Get the head of the linked list
        Node head = nodeList.get(0);
        Node res = copyRandomList3(head);
        System.out.println("head.equals(nodeNew) = " + head.equals(res));
        // Print the copied linked list
        List<Node> nodeListNew = new ArrayList<Node>();
        while (res != null) {
            nodeListNew.add(res);
            res = res.next;
        }
        Integer[][] printArr = new Integer[nodesVal.length][2];
        for (int i = 0; i < nodeListNew.size(); i++) {
            Node node = nodeListNew.get(i);
            printArr[i][0] = node.val;
            printArr[i][1] = node.random != null ? nodeListNew.indexOf(node.random) : null;
        }
        System.out.println(Arrays.deepToString(printArr));

    }

    /*
    请实现 copyRandomList 函数，复制一个复杂链表。
    在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
    示例 1：
    输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
    输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
    示例 2：
    输入：head = [[1,1],[2,1]]
    输出：[[1,1],[2,1]]
    示例 3：
    输入：head = [[3,null],[3,0],[3,null]]
    输出：[[3,null],[3,0],[3,null]]
    示例 4：
    输入：head = []
    输出：[]
    解释：给定的链表为空（空指针），因此返回 null。
    提示：
    -10000 <= Node.val <= 10000
    Node.random 为空（null）或指向链表中的节点。
    节点数目不超过 1000 。
     */
//自己看解释先写的
//    public static Node copyRandomList(Node head) {
//        Node newHead = new Node(0);
//        Node tempNew = newHead;
//        Node tempOld = head;
//        //oldNode,newNode
//        HashMap<Node, Node> nodeMap = new HashMap<Node, Node>();
//        while (tempOld != null) {
//            tempNew.next = new Node(tempOld.val);
//            nodeMap.put(tempOld, tempNew.next);
//            tempOld = tempOld.next;
//            tempNew = tempNew.next;
//        }
//        Node tempNew2 = newHead;
//        while (head != null) {
//            tempNew2.next.random = nodeMap.get(head.random);
//            tempNew2 = tempNew2.next;
//            head = head.next;
//        }
//        return newHead.next;
//    }

    public static Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node tempOld = head;
        //oldNode,newNode
        HashMap<Node, Node> nodeMap = new HashMap<Node, Node>();
        while (tempOld != null) {
            nodeMap.put(tempOld, new Node(tempOld.val));
            tempOld = tempOld.next;
        }
        tempOld = head;
        while (tempOld != null) {
            Node newNode = nodeMap.get(tempOld);
            newNode.next = nodeMap.get(tempOld.next);
            newNode.random = nodeMap.get(tempOld.random);
            tempOld = tempOld.next;
        }
        return nodeMap.get(head);
    }

    public static Node copyRandomList3(Node head) {
        if (head == null) {
            return null;
        }
        Node oldNode = head;
        while (oldNode != null) {
            Node temp = oldNode.next;
            //复制一个当前节点
            oldNode.next = new Node(oldNode.val);
            oldNode.next.next = temp;
            oldNode = oldNode.next.next;
        }
        oldNode = head;
        while (oldNode != null) {
            Node random = oldNode.random;
            if (random != null) {
                oldNode.next.random = random.next;
            }
            oldNode = oldNode.next.next;
        }
        Node res = new Node(0);
        Node newNode = res;
        oldNode = head;
        while (oldNode != null) {
            newNode.next = oldNode.next;
            oldNode.next = oldNode.next.next;
            newNode = newNode.next;
            oldNode = oldNode.next;
        }
        return res.next;
    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next.val +
                    ", random=" + random.val +
                    '}';
        }
    }
}