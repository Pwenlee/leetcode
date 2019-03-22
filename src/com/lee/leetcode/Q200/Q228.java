package com.lee.leetcode.Q200;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Pwenlee
 * @date 2019/3/22 09:52
 * @description
 */
public class Q228 {
//    228. 汇总区间
//    给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
//
//    示例 1:
//
//    输入: [0,1,2,4,5,7]
//    输出: ["0->2","4->5","7"]
//    解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
//    示例 2:
//
//    输入: [0,2,3,4,6,8,9]
//    输出: ["0","2->4","6","8->9"]
//    解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(Objects.nonNull(nums) && nums.length >= 1){
            int begin = nums[0];
            int end = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if(nums[i] == end + 1){
                    end = end + 1;
                }else{
                    if(begin == end){
                        result.add(String.valueOf(begin));
                    }else{
                        result.add(begin + "->" + end);
                    }
                    begin = nums[i];
                    end = nums[i];
                }
            }
            if(begin == end){
                result.add(String.valueOf(begin));
            }else{
                result.add(begin + "->" + end);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0,2,3,4,6,8,9}).stream().map(String::valueOf).collect(Collectors.joining(",")));
    }
}
