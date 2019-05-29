package com.lee.leetcode.Q100;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pwenlee
 * @date 2019/5/29 14:33
 * @description
 */
public class Q152 {
//    152. 乘积最大子序列
//    给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
//
//    示例 1:
//
//    输入: [2,3,-2,4]
//    输出: 6
//    解释: 子数组 [2,3] 有最大乘积 6。
//    示例 2:
//
//    输入: [-2,0,-1]
//    输出: 0
//    解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

    public static int maxProduct(int[] nums) {
        int length = nums.length;
        if(length == 1){
            return nums[0];
        }
        long product = 1;

        for (int num : nums) {
            product *= num;
        }
        if(product > 0){
            return (int)product;
        }else if(product < 0){
            long result = 0;
            long leftProduct = 1;
            for (int i = 0; i < length; i++) {
                int num = nums[i];
                if(num > 0){
                    leftProduct = leftProduct * num;
                }else{
                    result = Math.max(leftProduct, product / leftProduct / num);
                    break;
                }
            }
            long rightProduct = 1;
            for (int i = length - 1; i >= 0; i--) {
                int num = nums[i];
                if(num > 0){
                    rightProduct = rightProduct * num;
                }else{
                    result = Math.max(result ,Math.max(rightProduct, product / rightProduct /num));
                    break;
                }
            }
            return (int)result;
        }else{
            if(nums[0] == 0){
                return Math.max(maxProduct(Arrays.copyOfRange(nums, 1, length)), 0);
            }else if(nums[length - 1] == 0){
                return Math.max(maxProduct(Arrays.copyOfRange(nums, 0, length - 1)), 0);
            }else{
                for (int i = 1; i < nums.length - 1; i++) {
                    if(nums[i] == 0){
                        int[] left = Arrays.copyOfRange(nums, 0, i);
                        int[] right = Arrays.copyOfRange(nums, i + 1, length);
                        return Math.max(Math.max(maxProduct(left), maxProduct(right)) , 0);
                    }
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,-5,-2,-4,3}));
    }
}
