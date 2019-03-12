package com.lee.leetcode.Q600;

/**
 * @author Pwenlee
 * @date 2019/2/27 16:09
 * @description
 */
public class Q633 {

//    633. 平方数之和
//    给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
//
//    示例1:
//
//    输入: 5
//    输出: True
//    解释: 1 * 1 + 2 * 2 = 5
//
//    示例2:
//
//    输入: 3
//    输出: False
    public static boolean judgeSquareSum(int c) {
        double sqrDouble = Math.sqrt(c);
        int sqr = (int) sqrDouble;
        if(sqr == sqrDouble){
            return true;
        }
        for(int i=1;i<=sqr;i++){
            for(int j=sqr;j>=0;j--){
                long sum = i * i + j * j;
                if(sum == c){
                    return true;
                }else if(sum < c){
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
    }
}
