package com.lee.leetcode.Q300;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pwenlee
 * @date 2019/3/19 14:01
 * @description
 */
public class Q347 {

//    347. 前K个高频元素
//    给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
//    示例 1:
//
//    输入: nums = [1,1,1,2,2,3], k = 2
//    输出: [1,2]
//    示例 2:
//
//    输入: nums = [1], k = 1
//    输出: [1]
//    说明：
//
//    你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
//    你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>(k);
        List<Integer> valueList = new ArrayList<>();
        List<Integer> timeList = new ArrayList<>();
        for (int num : nums) {
            int index = valueList.indexOf(num);
            if(index > -1){
                timeList.set(index, timeList.get(index) + 1);
            }else{
                valueList.add(num);
                timeList.add(1);
            }
        }
        List<Integer> sortTimeList = timeList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for(int i = 1; i <= k; i++){
            int index = timeList.indexOf(sortTimeList.get(i-1));
            timeList.remove(index);
            result.add(valueList.remove(index));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,7,7,8,7,3}, 2).stream().map(String::valueOf).collect(Collectors.joining(",")));
    }
}
