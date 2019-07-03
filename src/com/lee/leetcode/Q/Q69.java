package com.lee.leetcode.Q;

/**
 * @author Pwenlee
 * @date 2019/7/3 14:20
 * @description
 */
public class Q69 {
//    69. x 的平方根
//    实现 int sqrt(int x) 函数。
//
//    计算并返回 x 的平方根，其中 x 是非负整数。
//
//    由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//
//    示例 1:
//
//    输入: 4
//    输出: 2
//    示例 2:
//
//    输入: 8
//    输出: 2
//    说明: 8 的平方根是 2.82842...,
//                 由于返回类型是整数，小数部分将被舍去。
//

    public static int mySqrt(int x) {
        if(x == 0){
            return 0;
        }else if(x == 1){
            return 1;
        }else{
            long start = 1;
            long end = x/2;
            while(true){
                if(start == end){
                    return (int)start;
                }
                long mid = (end + start) / 2 ;
                long value = mid * mid;
                if(value == x){
                    return (int)mid;
                }else if(value > x){
                    if((mid - 1) * (mid - 1) <= x) {
                        return (int)(mid - 1);
                    }else{
                        end = end == mid ? mid - 1 : mid;
                    }
                }else{
                    if((mid + 1) * (mid + 1) > x) {
                        return (int)mid;
                    }else{
                        start = start == mid ? mid + 1 : mid;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
