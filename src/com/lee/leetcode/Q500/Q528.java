package com.lee.leetcode.Q500;

import java.util.Random;

/**
 * @author Pwenlee
 * @date 2019/3/25 09:16
 * @description
 */
public class Q528 {
//    528. 按权重随机选择
//    给定一个正整数数组 w ，其中 w[i] 代表位置 i 的权重，请写一个函数 pickIndex ，它可以随机地获取位置 i，选取位置 i 的概率与 w[i] 成正比。
//
//    说明:
//
//            1 <= w.length <= 10000
//            1 <= w[i] <= 10^5
//    pickIndex 将被调用不超过 10000 次
//    示例1:
//
//    输入:
//            ["Solution","pickIndex"]
//            [[[1]],[]]
//    输出: [null,0]
//    示例2:
//
//    输入:
//            ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
//            [[[1,3]],[],[],[],[],[]]
//    输出: [null,0,1,1,1,0]
//    输入语法说明：
//
//    输入是两个列表：调用成员函数名和调用的参数。Solution 的构造函数有一个参数，即数组 w。pickIndex 没有参数。输入参数是一个列表，即使参数为空，也会输入一个 [] 空列表。

    static class Solution {

        private int sum;

        private int[] value;

        public Solution(int[] w) {
            sum = 0;
            value = new int[w.length];
            for (int i = 0; i < w.length; i++) {
                value[i] = sum + w[i];
                sum = sum + w[i];
            }
        }

        public int pickIndex() {
            int random = new Random().nextInt(sum) + 1;
            System.out.print(random + "=========");
            for (int i = 0; i < value.length - 1; i++) {
                if(value[i] >= random){
                    return i;
                }
            }
            return value.length - 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 3, 6});
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
    }
}
