package com.lee.leetcode.Q700;

/**
 * @author Administrator
 * @date 2019/2/25 19:46
 * @description
 */
public class Q713 {
//    713. 乘积小于K的子数组
//    给定一个正整数数组 nums。
//
//    找出该数组内乘积小于 k 的连续的子数组的个数。
//
//    示例 1:
//
//    输入: nums = [10,5,2,6], k = 100
//    输出: 8
//    解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
//    需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
//    说明:
//
//            0 < nums.length <= 50000
//            0 < nums[i] < 1000
//            0 <= k < 10^6
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int value = 1;
            for(int j = i; j < nums.length; j++){
                value = value * nums[j];
                if(value < k){
                    result = result + 1;
                    continue;
                }else{
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
