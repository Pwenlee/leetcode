package com.lee.leetcode.Q200;

import java.util.HashMap;

/**
 * @author Pwenlee
 * @date 2019/5/28 15:50
 * @description
 */
public class Q219 {
//    219. 存在重复元素 II
//    给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
//
//    示例 1:
//
//    输入: nums = [1,2,3,1], k = 3
//    输出: true
//    示例 2:
//
//    输入: nums = [1,0,1,1], k = 1
//    输出: true
//    示例 3:
//
//    输入: nums = [1,2,3,1,2,3], k = 2
//    输出: false

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int key = nums[i];
            Integer value = map.get(key);
            if(null == value){
                map.put(key, i);
            }else{
                if(i - value.intValue() <= k){
                    return true;
                }else{
                    map.put(key, i);
                }
            }
        }
        return false;
    }
}
