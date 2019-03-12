package com.lee.leetcode.Q100;

import java.util.Objects;

/**
 * @author Pwenlee
 * @date 2019/2/27 14:46
 * @description
 */
public class Q153 {

//    153. 寻找旋转排序数组中的最小值
//    假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
//            ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
//    请找出其中最小的元素。
//
//    你可以假设数组中不存在重复元素。
//
//    示例 1:
//
//    输入: [3,4,5,1,2]
//    输出: 1
//    示例 2:
//
//    输入: [4,5,6,7,0,1,2]
//    输出: 0

    public static int findMin(int[] nums) {
        if(Objects.isNull(nums) || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        for(int i=1; i<=nums.length-1; i++){
            if(nums[i] < nums[i-1]){
                return nums[i];
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1,2,3,4,5,0}));
    }
}
