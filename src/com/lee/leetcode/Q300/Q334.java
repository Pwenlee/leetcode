package com.lee.leetcode.Q300;

/**
 * @author Pwenlee
 * @date 2019/5/30 13:40
 * @description
 */
public class Q334 {
//    334. 递增的三元子序列
//    给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
//
//    数学表达式如下:
//
//    如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
//    使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
//    说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
//
//    示例 1:
//
//    输入: [1,2,3,4,5]
//    输出: true
//    示例 2:
//
//    输入: [5,4,3,2,1]
//    输出: false
//

    public static boolean increasingTriplet(int[] nums) {
        if(nums.length < 3){
            return  false;
        }
        int length = nums.length;
        int max = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length - 1; i++) {
            if(nums[i] > max){
                return true;
            }
            min = Math.min(min, nums[i]);
            if(nums[i + 1] > min){
                max = Math.min(max, nums[i + 1]);
            }
        }
        return nums[length - 1] > max;
    }

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{1,2,3,1,2,1}));
    }
}
