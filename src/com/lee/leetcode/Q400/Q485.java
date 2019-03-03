package com.lee.leetcode.Q400;

import java.util.Objects;

/**
 * @author Administrator
 * @date 2019/3/3 19:19
 * @description
 */
public class Q485 {
//    485. 最大连续1的个数
//    给定一个二进制数组， 计算其中最大连续1的个数。
//
//    示例 1:
//
//    输入: [1,1,0,1,1,1]
//    输出: 3
//    解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
//    注意：
//
//    输入的数组只包含 0 和1。
//    输入数组的长度是正整数，且不超过 10,000。
    public static int findMaxConsecutiveOnes(int[] nums) {
        if(Objects.isNull(nums) || nums.length == 0){
            return 0;
        }
        int result1 = 0;
        int result2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                result1++;
            }else {
                result2 = Math.max(result1, result2);
                result1 = 0;
            }
        }
        return Math.max(result1, result2);
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,1,1,1}));
    }
}
