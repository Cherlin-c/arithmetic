package com.scl.linkedList.single;

/**
 * 单链表
 *
 * @author : scl
 * @date :  2022/8/15
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {

        SingleLinkedList list = new SingleLinkedList();
        list.add(new Node("1", "1value"));
        list.add(new Node("2", "2value"));
        list.add(new Node("4", "4value"));
        list.addById(new Node("3", "3value"));
        list.putById(new Node("3", "333value"));
        list.removeById("2");
        list.removeById("20");
        list.list();
        System.out.println("list.getLength() = " + list.getLength());
    }

}


