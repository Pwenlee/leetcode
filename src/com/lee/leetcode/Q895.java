package com.lee.leetcode;

import java.util.*;

/**
 * @author lipan
 * @date 2019/2/12 9:55
 * @description
 */
public class Q895 {
//    895. 最大频率栈
//    实现 FreqStack，模拟类似栈的数据结构的操作的一个类。
//
//    FreqStack 有两个函数：
//
//    push(int x)，将整数 x 推入栈中。
//    pop()，它移除并返回栈中出现最频繁的元素。
//    如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。
//
//
//    示例：
//
//    输入：
//            ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
//            [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
//    输出：[null,null,null,null,null,null,null,5,7,5,4]
//    解释：
//    执行六次 .push 操作后，栈自底向上为 [5,7,5,7,4,5]。然后：
//
//    pop() -> 返回 5，因为 5 是出现频率最高的。
//    栈变成 [5,7,5,7,4]。
//
//    pop() -> 返回 7，因为 5 和 7 都是频率最高的，但 7 最接近栈顶。
//    栈变成 [5,7,5,4]。
//
//    pop() -> 返回 5 。
//    栈变成 [5,7,4]。
//
//    pop() -> 返回 4 。
//    栈变成 [5,7]。
//
//
//    提示：
//
//    对 FreqStack.push(int x) 的调用中 0 <= x <= 10^9。
//    如果栈的元素数目为零，则保证不会调用  FreqStack.pop()。
//    单个测试样例中，对 FreqStack.push 的总调用次数不会超过 10000。
//    单个测试样例中，对 FreqStack.pop 的总调用次数不会超过 10000。
//    所有测试样例中，对 FreqStack.push 和 FreqStack.pop 的总调用次数不会超过 150000。

    static class FreqStack {

        private List<Integer> valueList = new ArrayList<>();

        private List<Integer> noRepeatValueList = new ArrayList<>();

        private List<Integer> timeList = new ArrayList<>();

        public FreqStack() {

        }

        public void push(int x) {
            valueList.add(x);
            int index = noRepeatValueList.indexOf(x);
            if(index <= -1){
                noRepeatValueList.add(x);
                timeList.add(1);
            }else{
                timeList.set(index, timeList.get(index) + 1);
            }
        }

        public int pop() {
            List<Integer> maxTimeValue = new LinkedList<>();
            int maxTime = timeList.stream().mapToInt(Integer::intValue).max().getAsInt();
            for (int i=0; i<timeList.size(); i++) {
                if(timeList.get(i) == maxTime){
                    maxTimeValue.add(noRepeatValueList.get(i));
                }
            }
            int result = -1;
            for(int i=valueList.size()-1; i>=0; i--){
                int value = valueList.get(i);
                if(maxTimeValue.contains(value)){
                    result = value;
                    valueList.remove(i);
                    break;
                }
            }
            int index = noRepeatValueList.indexOf(result);
            int time = timeList.get(index);
            if(time == 1){
                timeList.remove(index);
                noRepeatValueList.remove(index);
            }else{
                timeList.set(index, timeList.get(index) - 1);
            }
            return result;
        }
    }

    public static void main(String[] args) {

        FreqStack freqStack = new FreqStack();
        freqStack.push(4);
        freqStack.push(0);
        freqStack.push(9);
        freqStack.push(3);
        freqStack.push(4);
        freqStack.push(2);
        System.out.println(freqStack.pop());
        freqStack.push(6);
        System.out.println(freqStack.pop());
        freqStack.push(1);
        System.out.println(freqStack.pop());
        freqStack.push(1);
        System.out.println(freqStack.pop());
        freqStack.push(4);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }
}
