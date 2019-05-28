package com.lee.leetcode.Q200;

import java.util.HashSet;

/**
 * @author Pwenlee
 * @date 2019/5/28 15:37
 * @description
 */
public class Q217 {
//    217. 存在重复元素
//    给定一个整数数组，判断是否存在重复元素。
//
//    如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
//
//    示例 1:
//
//    输入: [1,2,3,1]
//    输出: true
//    示例 2:
//
//    输入: [1,2,3,4]
//    输出: false
//    示例 3:
//
//    输入: [1,1,1,3,3,4,3,2,4,2]
//    输出: true

    public boolean containsDuplicate(int[] nums) {
        if(nums.length > 1){
            HashSet<Integer> set = new HashSet<>();
            for (int i : nums) {
                if(!set.add(i)){
                    return true;
                }
            }
        }
        return false;
    }
}
