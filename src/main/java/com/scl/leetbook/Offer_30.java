package com.scl.leetbook;

import java.util.Stack;

/**
 * 包含min函数的栈
 *
 * @author : scl
 * @date :  2022/9/11
 */
public class Offer_30 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("minStack.min() = " + minStack.min());
        minStack.pop();
        System.out.println("minStack.top() = " + minStack.top());
        System.out.println("minStack.min() = " + minStack.min());

    }
/*
    定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

    示例:
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.min();   --> 返回 -3.
    minStack.pop();
    minStack.top();      --> 返回 0.
    minStack.min();   --> 返回 -2.

    提示：
    各函数的调用总次数不超过 20000 次
 */

    static class MinStack {
        Stack<Integer> stack;
        Stack<Integer> stackMin;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<Integer>();
            stackMin = new Stack<Integer>();
        }

        public void push(int x) {
            stack.push(x);
            if (stackMin.empty() || stackMin.peek() >= x) {
                stackMin.push(x);
            }

        }

        public void pop() {
            if (stack.pop().equals(stackMin.peek())) {
                stackMin.pop();
            }
        }


//        public void push(int x) {
//            stack.push(x);
//            if (stackMin.empty()) {
//                stackMin.push(x);
//            } else {
//                stackMin.push(Math.min(x, stackMin.peek()));
//            }
//        }
//
//        public void pop() {
//            stack.pop();
//            stackMin.pop();
//        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return stackMin.peek();
        }
    }

}