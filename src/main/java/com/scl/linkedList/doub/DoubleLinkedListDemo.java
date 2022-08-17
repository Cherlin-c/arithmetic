package com.scl.linkedList.doub;

/**
 * 双向链表测试
 *
 * @author : scl
 * @date :  2022/8/17
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(new DoubleNode("1", "1value"));
        list.add(new DoubleNode("2", "2value"));
//        list.add(new DoubleNode("3", "3value"));
        list.add(new DoubleNode("4", "4value"));
        list.addById(new DoubleNode("3", "3value"));
        list.list();
//        System.out.println("===修改===");
//        list.putById(new DoubleNode("3", "333value"));
//        list.list();
//        System.out.println("===删除===");
//        list.removeById("2");
//        list.list();
//        System.out.println("list.getLength() = " + list.getLength());
    }
}