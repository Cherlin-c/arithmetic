package com.scl.leetbook;

import java.util.Stack;

/**
 * 用两个栈实现队列
 *
 * @author : scl
 * @date :  2022/9/11
 */
public class Offer_9 {
    /*
    用两个栈实现一个队列。
    队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
    (若队列中没有元素，deleteHead操作返回 -1 )
    示例 1：
    输入：
    ["CQueue","appendTail","deleteHead","deleteHead"]
    [[],[3],[],[]]
    输出：[null,null,3,-1]
    示例 2：
    输入：
    ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
    [[],[],[5],[2],[],[]]
    输出：[null,-1,null,null,5,2]
     */

    public static void main(String[] args) {
//        CQueue cQueue = new CQueue();
//        cQueue.appendTail(3);
//        System.out.println("(1)cQueue.deleteHead() = " + cQueue.deleteHead());
//        System.out.println("(2)cQueue.deleteHead() = " + cQueue.deleteHead());
        CQueue cQueue = new CQueue();
        System.out.println("(1)cQueue.deleteHead() = " + cQueue.deleteHead());
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        System.out.println("(2)cQueue.deleteHead() = " + cQueue.deleteHead());
        System.out.println("(3)cQueue.deleteHead() = " + cQueue.deleteHead());

    }


    static class CQueue {

        //可用Deque
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<Integer>();
            stack2 = new Stack<Integer>();
        }


        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.empty()) {
                if (stack1.empty()) {
                    return -1;
                }
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

//        public void appendTail(int value) {
//            if (stack1.empty()){
//                stack1.push(value);
//            }else {
//                while (!stack1.empty()){
//                    stack2.push(stack1.pop());
//                }
//                stack1.push(value);
//                while (!stack2.empty()){
//                    stack1.push(stack2.pop());
//                }
//            }
//        }
//
//        public int deleteHead() {
//            if (stack1.empty()){
//                return -1;
//            }
//            return stack1.pop();
//        }
    }
}