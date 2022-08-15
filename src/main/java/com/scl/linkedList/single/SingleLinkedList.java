package com.scl.linkedList.single;

/**
 * @author : scl
 * @date :  2022/8/15
 */
class SingleLinkedList {
    //头节点，不存放数据
    Node head = new Node("", "");

    /**
     * 加到尾部
     **/
    public void add(Node next) {
        Node nextTemp = head;
        while (true) {
            if (nextTemp.next == null) {
                nextTemp.next = next;
                break;
            }
            nextTemp = nextTemp.next;
        }
    }

    /**
     * 根据id大小顺序加入
     **/
    public void addById(Node next) {
        Node nextTemp = head;
        while (nextTemp.next != null) {
            String id = next.id;
            if (id.compareTo(nextTemp.next.id) < 0) {
                Node tempp = nextTemp.next;
                nextTemp.next = next;
                next.next = tempp;
                break;
            } else if (nextTemp.next.id.equals(id)) {
                System.out.println("已存在此ID 无法插入");
                break;
            }
            nextTemp = nextTemp.next;
        }
    }

    /**
     * 根据id修改
     **/
    public void putById(Node next) {
        Node nextTemp = head;
        while (nextTemp.next != null) {
            if (nextTemp.next.id.equals(next.id)) {
                nextTemp.next.value = next.value;
                break;
            }
            nextTemp = nextTemp.next;
        }
    }

    /**
     * 根据id删除
     **/
    public void removeById(String id) {
        Node nextTemp = head;
        while (nextTemp.next != null) {
            if (nextTemp.next.id.equals(id)) {
                nextTemp.next = nextTemp.next.next;
                break;
            }
            nextTemp = nextTemp.next;
        }
    }

    /**
     * 遍历数据
     **/
    public void list() {
        if (head.next == null) {
            System.out.println("无数据");
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println("head.toString() = " + temp);
        }
    }

    /**
     * 节点个数
     */
    public int getLength() {
        int length = 0;
        if (head.next == null) {
            System.out.println("无数据");
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }

}