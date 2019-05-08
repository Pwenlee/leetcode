package com.lee.leetcode.Q400;

import java.util.Arrays;

/**
 * @author Pwenlee
 * @date 2019/5/8 16:34
 * @description
 */
public class Q416 {
//    416. 分割等和子集
//    给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
//    注意:
//
//    每个数组中的元素不会超过 100
//    数组的大小不会超过 200
//    示例 1:
//
//    输入: [1, 5, 11, 5]
//
//    输出: true
//
//    解释: 数组可以分割成 [1, 5, 5] 和 [11].
//
//
//    示例 2:
//
//    输入: [1, 2, 3, 5]
//
//    输出: false
//
//    解释: 数组不能分割成两个元素和相等的子集.

    public static boolean canPartition(int[] nums) {
        if(nums.length <= 1){
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0){
            return false;
        }
        sum = sum / 2;
        //标记从1~sum所有子集相加可以达到的数
        boolean[] result = new boolean[sum+1];
        for (int num : nums) {
            //如果有元素等于sum 则返回true
            if(num == sum) {
                return true;
            }else if(num < sum){
                boolean[] copy = Arrays.copyOf(result, result.length);
                for (int i = 0; i < copy.length; i++) {
                    //如果当前的位置加上元素大于了sum 则跳出当前循环
                    if(i+num > sum){
                        break;
                    }
                    //如果当前的位置是true 则当前的位置+当前元素的位置也为true
                    if(copy[i]){
                        result[i+num] = true;
                    }
                }
                //当前元素的位置为true
                result[num] = true;
            }
            if(result[sum]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{2,2,3,5}));
    }
}
