package com.lee.leetcode.Q300;

import java.util.*;

/**
 * @author Pwenlee
 * @date 2019/3/18 13:52
 * @description
 */
public class Q384 {

//    384. 打乱数组
//    打乱一个没有重复元素的数组。
//
//    示例:
//
//    // 以数字集合 1, 2 和 3 初始化数组。
//    int[] nums = {1,2,3};
//    Solution solution = new Solution(nums);
//
//    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
//    solution.shuffle();
//
//    // 重设数组到它的初始状态[1,2,3]。
//    solution.reset();
//
//    // 随机返回数组[1,2,3]打乱后的结果。
//    solution.shuffle();

    static class Solution {

        private int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return this.nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] copy = Arrays.copyOf(nums, nums.length);
            int[] result = new int[copy.length];
            for (int i = 0; i < result.length; i++) {
                int index = new Random().nextInt(copy.length - i);
                result[i] = copy[index];
                copy[index] = copy[copy.length-i-1];
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution(new int[]{1,2,3,4,5,6,7,8,9,10});
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.reset()));
    }

}
