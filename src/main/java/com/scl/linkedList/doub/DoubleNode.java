package com.scl.linkedList.doub;

/**
 * @author : scl
 * @date :  2022/8/15
 */
public class DoubleNode {
    public String id;
    public Object value;
    public DoubleNode next;
    public DoubleNode pre;

    public DoubleNode(String id, Object value, DoubleNode next, DoubleNode pre) {
        this.id = id;
        this.value = value;
        this.next = next;
        this.pre = pre;
    }

    public DoubleNode(String id, Object value, DoubleNode next) {
        this.id = id;
        this.value = value;
        this.next = next;
    }

    public DoubleNode(String id, Object value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "id='" + id + '\'' +
                ", value=" + value +
                '}';
    }
}