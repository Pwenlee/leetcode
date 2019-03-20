package com.lee.leetcode.Q300;

/**
 * @author Pwenlee
 * @date 2019/3/20 13:51
 * @description
 */
public class Q343 {

//    343. 整数拆分
//    给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
//
//    示例 1:
//
//    输入: 2
//    输出: 1
//    解释: 2 = 1 + 1, 1 × 1 = 1。
//    示例 2:
//
//    输入: 10
//    输出: 36
//    解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
//    说明: 你可以假设 n 不小于 2 且不大于 58。

    private static int[] result = new int[59];

    static {
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        for(int i = 4; i<= 58; i++){
            result[i] = result[i-2] * result[2];
            for(int j = 2; j <= i/2; j++){
                result[i] = Math.max(result[i], result[j] * result[i-j]);
            }
        }
    }

    public static int integerBreak(int n) {
        if(n == 2){
            return 1;
        }else if(n == 3){
            return 2;
        }else {
            return result[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
