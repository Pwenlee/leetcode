package com.lee.leetcode.Q100;

import java.util.Stack;

/**
 * @author Pwenlee
 * @date 2019/4/15 09:41
 * @description
 */
public class Q155 {
//    155. 最小栈
//    设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
//
//    push(x) -- 将元素 x 推入栈中。
//    pop() -- 删除栈顶的元素。
//    top() -- 获取栈顶元素。
//    getMin() -- 检索栈中的最小元素。
//    示例:
//
//    MinStack minStack = new MinStack();
//    minStack.push(-2);
//    minStack.push(0);
//    minStack.push(-3);
//    minStack.getMin();   --> 返回 -3.
//    minStack.pop();
//    minStack.top();      --> 返回 0.
//    minStack.getMin();   --> 返回 -2.

    class MinStack {

        private Stack<Integer> stack;

        private Integer min;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if(stack.empty()){
                min = x;
            }else{
                if(x < min.intValue()){
                    min = x;
                }
            }
            stack.push(x);
        }

        public void pop() {
            stack.pop();
            min = stack.empty() ? null : stack.stream().mapToInt(Integer::intValue).min().getAsInt();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.intValue();
        }
    }
}
