package com.lee.leetcode.Q600;

/**
 * @author Pwenlee
 * @date 2019/3/15 15:37
 * @description
 */
public class Q643 {

//    643. 子数组最大平均数 I
//    给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
//
//    示例 1:
//
//    输入: [1,12,-5,-6,50,3], k = 4
//    输出: 12.75
//    解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
//
//
//    注意:
//
//            1 <= k <= n <= 30,000。
//    所给数据范围 [-10,000，10,000]。

    public static double findMaxAverage(int[] nums, int k) {
        long result = Long.MIN_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            long sum = nums[i];
            for(int j = i + 1; j<=nums.length-1 && j <= i+k-1;j++){
                sum = sum + nums[j];
            }
            result = Math.max(result, sum);
        }
        return result/(double)k;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,13},4));
    }
}
