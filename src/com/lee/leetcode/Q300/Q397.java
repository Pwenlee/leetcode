package com.lee.leetcode.Q300;

import java.util.*;

/**
 * @author Pwenlee
 * @date 2019/3/21 09:21
 * @description
 */
public class Q397 {
//    397. 整数替换
//    给定一个正整数 n，你可以做如下操作：
//
//            1. 如果 n 是偶数，则用 n / 2替换 n。
//            2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
//    n 变为 1 所需的最小替换次数是多少？
//
//    示例 1:
//
//    输入:
//            8
//
//    输出:
//            3
//
//    解释:
//         8 -> 4 -> 2 -> 1
//    示例 2:
//
//    输入:
//        7
//
//    输出:
//        4
//
//    解释:
//        7 -> 8 -> 4 -> 2 -> 1
//    或
//        7 -> 6 -> 3 -> 2 -> 1

    public static int integerReplacement(int n) {
        return integerReplacement((long)n);
    }

    public static int integerReplacement(long n) {
        if(n == 1){
            return 0;
        }else if(n == 2){
            return 1;
        }else {
            int value;
            if(isPowerOf2(n)){
                return getPowerOf2(n);
            }else if (n % 2 == 0) {
                value = integerReplacement(n / 2) + 1;
            } else {
                value = Math.min(integerReplacement(n + 1), integerReplacement(n - 1)) + 1;
            }
            return value;
        }
    }

    private static boolean isPowerOf2(long n){
        return (n & (n-1)) == 0;
    }

    private static int getPowerOf2(long n){
        int x = 0;
        while (n > 1) {
            n >>= 1;
            x++;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(integerReplacement(2147483647));
    }
}
