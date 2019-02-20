package com.lee.leetcode.Q;

import java.util.Arrays;

/**
 * @author Pwenlee
 * @date 2019/2/11 14:43
 * @description
 */
public class Q66 {
//    66. 加一
//    给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
//    最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
//
//    你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//    示例 1:
//
//    输入: [1,2,3]
//    输出: [1,2,4]
//    解释: 输入数组表示数字 123。
//    示例 2:
//
//    输入: [4,3,2,1]
//    输出: [4,3,2,2]
//    解释: 输入数组表示数字 4321。

    public static int[] plusOne(int[] digits) {
        if(null == digits && digits.length == 0){
            return digits;
        }
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        for(int i=digits.length-1; i>=0; i--){
            if(digits[i] != 10){
                break;
            }
            digits[i] = 0;
            if(i!=0) {
                digits[i - 1] = digits[i - 1] + 1;
            }else{
                int[] result = new int[digits.length +1];
                result[0] = 1;
                for(int j=0; j<digits.length; j++){
                    result[j+1] = digits[j];
                }
                return result;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9})));
    }
}
