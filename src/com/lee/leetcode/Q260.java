package com.lee.leetcode;

import java.util.Arrays;

/**
 * @author Pwenlee
 * @date 2019/1/28 15:35
 * @description
 */
public class Q260 {
//    260. 只出现一次的数字 III
//    给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
//
//    示例 :
//
//    输入: [1,2,1,3,2,5]
//    输出: [3,5]
//    注意：
//
//    结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
//    你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？

    public static int[] singleNumber(int[] nums) {
        StringBuilder temp = new StringBuilder();
        for(int i=0;i<nums.length;i++){
            String num = String.valueOf(nums[i]);
            if(temp.indexOf(num) <= -1){
                temp.append(",").append(num);
            }else{
                num = "," + num;
                int index = temp.indexOf(num);
                temp.delete(index, index + num.length());
            }
        }
        String[] resultStr = temp.toString().substring(1, temp.length()).split(",");
        int[] result = new int[2];
        result[0] = Integer.valueOf(resultStr[0]);
        result[1] = Integer.valueOf(resultStr[1]);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{1,2,1,3,2,5})));
    }
}
