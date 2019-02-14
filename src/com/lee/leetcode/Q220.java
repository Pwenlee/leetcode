package com.lee.leetcode;

import java.util.Objects;

/**
 * @author Pwenlee
 * @date 2019/2/12 15:41
 * @description
 */
public class Q220 {
//    220. 两数之和
//    给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
//
//    示例 1:
//
//    输入: nums = [1,2,3,1], k = 3, t = 0
//    输出: true
//    示例 2:
//
//    输入: nums = [1,0,1,1], k = 1, t = 2
//    输出: true
//    示例 3:
//
//    输入: nums = [1,5,9,1,5,9], k = 2, t = 3
//    输出: false

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(Objects.isNull(nums) || nums.length <= 1){
            return false;
        }
        for(int i=0;i<=nums.length-1;i++){
            for(int j=i+1;j<=Math.min(nums.length-1, i+k);j++){
                long valuei = nums[i];
                long valuej = nums[j];
                if(Math.abs(valuei - valuej) <= t){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[]{2147483647,-2147483647}, 1, 2147483647));
    }
}
