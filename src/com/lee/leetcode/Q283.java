package com.lee.leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Pwenlee
 * @date 2019/1/28 15:35
 * @description
 */
public class Q283 {
//    283. 移动零
//    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//    示例:
//
//    输入: [0,1,0,3,12]
//    输出: [1,3,12,0,0]
//    说明:
//
//    必须在原数组上操作，不能拷贝额外的数组。
//    尽量减少操作次数。

    public static int[] moveZeroes(int[] nums) {
        if(Objects.isNull(nums) || nums.length == 0){
            return nums;
        }
        int index = nums.length-1;
        boolean flag = false;
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i] == 0){
                if(flag){
                    for(int j=i;j<index;j++){
                        nums[j] = nums[j+1];
                    }
                    nums[index] = 0;
                    index--;
                }else{
                    index = i;
                }
            }else{
                flag = true;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZeroes(new int[]{6,3,0,1,0,2})));
    }
}
