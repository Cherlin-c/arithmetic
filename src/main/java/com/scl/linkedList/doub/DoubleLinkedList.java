package com.scl.linkedList.doub;

/**
 * 双向链表
 *
 * @author : scl
 * @date :  2022/8/17
 */
public class DoubleLinkedList {

    //头节点 无数据
    DoubleNode head = new DoubleNode("", "");

    /**
     * 遍历数据
     **/
    public void list() {
        if (head.next == null) {
            System.out.println("无数据");
        }
        DoubleNode temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println("node = " + temp);
        }
    }

    /**
     * 加到尾部
     **/
    public void add(DoubleNode node) {
        DoubleNode temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    /**
     * 根据id大小顺序加入
     **/
    public void addById(DoubleNode node) {
        DoubleNode temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
            if (node.id.equals(temp.id)) {
                System.out.println("已存在此ID 无法插入");
                break;
            } else if (node.id.compareTo(temp.id) < 0) {
                temp.pre.next = node;
                if (temp.next!=null){
                    temp.next.pre = node;
                }
                node.pre = temp.pre;
                node.next = temp;
            }
        }
    }

    /**
     * 根据id修改
     **/
    public void putById(DoubleNode node) {
        if (head.next == null) {
            System.out.println("无数据");
        }
        DoubleNode temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
            if (temp.id.equals(node.id)) {
                temp.value = node.value;
                break;
            }
        }
    }


    /**
     * 根据id删除
     **/
    public void removeById(String id) {
        if (head.next == null) {
            System.out.println("无数据");
        }
        DoubleNode temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
            if (temp.id.equals(id)) {
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;
                break;
            }
        }
    }
}