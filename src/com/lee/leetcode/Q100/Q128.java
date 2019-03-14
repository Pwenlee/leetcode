package com.lee.leetcode.Q100;

import java.util.*;

/**
 * @author Pwenlee
 * @date 2019/2/14 15:48
 * @description
 */
public class Q128 {
//    128. 最长连续序列
//    给定一个未排序的整数数组，找出最长连续序列的长度。
//
//    要求算法的时间复杂度为 O(n)。
//
//    示例:
//
//    输入: [100, 4, 200, 1, 3, 2]
//    输出: 4
//    解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。

    public static int longestConsecutive(int[] nums) {
        if(Objects.isNull(nums)){
            return 0;
        }
        if(nums.length <= 1){
            return nums.length;
        }
        //定义两个map 分别 记录开始值、长度  结束值、长度
        Map<Integer, Integer> naturalOrderMap = new HashMap<>(nums.length);
        Map<Integer, Integer> reverseOrderMap = new HashMap<>(nums.length);
        //定义set 过滤重复元素
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)){
                continue;
            }
            set.add(num);
            if(Objects.nonNull(naturalOrderMap.get(num+1))){
                //如果记录开始值的map中有包含num+1的元素 则将num拼在前面
                appendHead(num, 1, naturalOrderMap, reverseOrderMap);
            }else if(Objects.nonNull(reverseOrderMap.get(num-1))){
                //如果记录结束值的map中有包含num-1的元素 则将num拼在后面
                appendTail(num, 1, naturalOrderMap, reverseOrderMap);
            }else{
                naturalOrderMap.put(num, 1);
                reverseOrderMap.put(num, 1);
            }
        }
        return naturalOrderMap.values().stream().max(Comparator.naturalOrder()).get();
    }

    private static void appendHead(int num, int length, Map<Integer, Integer> naturalOrderMap, Map<Integer, Integer> reverseOrderMap){
        //原开始值是num+1
        Integer startIndex = num + 1;
        Integer currentLength = naturalOrderMap.get(startIndex);
        //原结束值是 开始值+长度-1
        Integer endIndex = startIndex + currentLength - 1;
        //原长度+需要拼接的长度
        currentLength = currentLength + length;
        //写入新的开始值 新的长度 结束值不变
        naturalOrderMap.put(num-length+1, currentLength);
        reverseOrderMap.put(endIndex, currentLength);
        //移除掉原开始值
        naturalOrderMap.remove(startIndex);

        //拼在前面完毕  检查num是不是可以拼在其他元素的后面
        if(Objects.nonNull(reverseOrderMap.get(num-1))){
            //从map中移除num项
            naturalOrderMap.remove(num, currentLength);
            reverseOrderMap.remove(endIndex, currentLength);
            //拼在后面 num和length
            appendTail(num, currentLength,  naturalOrderMap,  reverseOrderMap);
        }

    }

    private static void appendTail(int num, int length, Map<Integer, Integer> naturalOrderMap, Map<Integer, Integer> reverseOrderMap){
        //原结束值是num+1
        Integer endIndex = num - 1;
        Integer currentLength = reverseOrderMap.get(endIndex);
        //原开始值是 开始值-长度-+1
        Integer startIndex = endIndex - currentLength + 1;
        currentLength = currentLength + length;
        //写入新的结束值 新的长度 开始值不变
        reverseOrderMap.put(num+length-1, currentLength);
        naturalOrderMap.put(startIndex, currentLength);
        //移除掉原结束值
        reverseOrderMap.remove(endIndex);

        //拼在后面完毕  检查num是不是可以拼在其他元素的前面
        if(Objects.nonNull(naturalOrderMap.get(num+1))){
            //从map中移除num项
            reverseOrderMap.remove(num, currentLength);
            naturalOrderMap.remove(startIndex, currentLength);
            //拼在后面 num和length
            appendHead(num, currentLength,  naturalOrderMap,  reverseOrderMap);
        }
    }

    public static void main(String[] args){
        System.out.println(longestConsecutive(new int[]{1,3,5,2,4}));
    }
}
