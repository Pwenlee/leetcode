package com.lee.leetcode.Q200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Pwenlee
 * @date 2019/4/28 13:59
 * @description
 */
public class Q216 {
//    216. 组合总和 III
//    找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
//
//    说明：
//
//    所有数字都是正整数。
//    解集不能包含重复的组合。
//    示例 1:
//
//    输入: k = 3, n = 7
//    输出: [[1,2,4]]
//    示例 2:
//
//    输入: k = 3, n = 9
//    输出: [[1,2,6], [1,3,5], [2,3,4]]

    public static List<List<Integer>> combinationSum3(int k, int n) {
        int minValue = getMinValue(k);
        int maxValue = getMaxValue(k);
        if(n < minValue || n > maxValue){
            return new ArrayList<>();
        }
        Set<Set<Integer>> setResult = new HashSet<>();
        Set<Integer> initSet = new HashSet<>();
        while(k > 0){
            initSet.add(k);
            k--;
        }
        setResult.add(initSet);
        while(minValue < n){
            Set<Set<Integer>> copyList = new HashSet<>();
            for (Set<Integer> set : setResult) {
                for (Integer ele : set) {
                    if(!set.contains(ele+1) && ele.intValue() != 9){
                        HashSet<Integer> copySet = new HashSet<>(set);
                        copySet.remove(ele);
                        copySet.add(ele+1);
                        copyList.add(copySet);
                    }
                }
            }
            setResult = copyList;
            minValue++;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Set<Integer> set : setResult) {
            result.add(new ArrayList<>(set));
        }
        return result;
    }

    private static int getMinValue(int k){
        int sum = 0;
        while(k > 0){
            sum += k;
            k--;
        }
        return sum;
    }

    private final static int MAX_VALUE = 45;

    private static int getMaxValue(int k){
        return MAX_VALUE - getMinValue(9-k);
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3,15));
    }
}
