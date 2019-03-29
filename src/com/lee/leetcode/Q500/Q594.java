package com.lee.leetcode.Q500;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Pwenlee
 * @date 2019/3/29 16:07
 * @description
 */
public class Q594 {
//    594. 最长和谐子序列
//    和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
//
//    现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
//
//    示例 1:
//
//    输入: [1,3,2,2,5,2,3,7]
//    输出: 5
//    原因: 最长的和谐数组是：[3,2,2,2,3].
//    说明: 输入的数组长度最大不超过20,000.

    public static int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for (Integer key : map.keySet()) {
            int count = map.get(key);
            Integer count1 = map.get(key+1);
            if(Objects.nonNull(count1)){
                result = Math.max(result, count + count1.intValue());
            }
            Integer count2 = map.get(key-1);
            if(Objects.nonNull(count2)){
                result = Math.max(result, count + count2.intValue());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1,3,2,2,5,2,3,7}));
    }
}
