package com.lyq.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuanqiang.liao
 * @description 用队列实现栈
 * @createTime 2023-03-07 14:31:00
 */
public class MyStack {
    private Queue<Integer> stack;

    public MyStack() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.add(x);
        for (int i = 0; i < stack.size() - 1; i++) {
            stack.add(stack.remove());
        }
    }

    public int pop() {
        return stack.remove();
    }

    public int top() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}

