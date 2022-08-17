package com.scl.linkedList.single;

/**
 * @author : scl
 * @date :  2022/8/15
 */
class SingleNode {
    public String id;
    public Object value;
    public SingleNode next;


    public SingleNode(String id, Object value, SingleNode next) {
        this.id = id;
        this.value = value;
        this.next = next;
    }

    public SingleNode(String id, Object value) {
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