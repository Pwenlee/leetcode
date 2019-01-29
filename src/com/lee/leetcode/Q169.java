package com.lee.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lipan
 * @date 2019/1/28 15:44
 * @description
 */
public class Q169 {
//    169. 求众数
//    给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
//    你可以假设数组是非空的，并且给定的数组总是存在众数。
//
//    示例 1:
//
//    输入: [3,2,3]
//    输出: 3
//    示例 2:
//
//    输入: [2,2,1,1,1,2,2]
//    输出: 2

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i=0;i<nums.length;i++){
            Integer count = map.containsKey(nums[i]) ? map.get(nums[i]) : 0;
            map.put(nums[i], count + 1);
        }
        for (Integer integer : map.keySet()) {
            if(map.get(integer) >= nums.length/2.0){
                return integer;
            }
        }
        return nums[0];
    }
}
