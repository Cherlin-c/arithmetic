package com.scl.linkedList.single;

/**
 * @author : scl
 * @date :  2022/8/15
 */
class Node {
    public String id;
    public Object value;
    public Node next;


    public Node(String id, Object value, Node next) {
        this.id = id;
        this.value = value;
        this.next = next;
    }

    public Node(String id, Object value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id='" + id + '\'' +
                ", value=" + value +
                '}';
    }
}