package com.lee.leetcode.Q400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pwenlee
 * @date 2019/4/30 10:19
 * @description
 */
public class Q414 {
//    414. 第三大的数
//    给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
//
//    示例 1:
//
//    输入: [3, 2, 1]
//
//    输出: 1
//
//    解释: 第三大的数是 1.
//    示例 2:
//
//    输入: [1, 2]
//
//    输出: 2
//
//    解释: 第三大的数不存在, 所以返回最大的数 2 .
//    示例 3:
//
//    输入: [2, 2, 3, 1]
//
//    输出: 1
//
//    解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
//    存在两个值为2的数，它们都排第二。

    public int thirdMax(int[] nums) {
        int length = nums.length;
        switch (length){
            case 1:
                return nums[0];
            case 2:
                return Math.max(nums[0], nums[1]);
            default:
                long[] result = new long[3];
                result[0] = Long.MIN_VALUE;
                result[1] = Long.MIN_VALUE;
                result[2] = Long.MIN_VALUE;
                Arrays.sort(result);
                for (int num : nums) {
                    if(num > result[0] && num != result[1] && num != result[2]){
                        result[0] = num;
                        Arrays.sort(result);
                    }
                }
                if(result[0] == Long.MIN_VALUE || result[1] == Long.MIN_VALUE){
                    return (int)result[2];
                }else {
                    return (int) result[0];
                }
        }
    }

    public static void main(String[] args) {

    }
}
