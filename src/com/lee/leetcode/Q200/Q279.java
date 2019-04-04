package com.lee.leetcode.Q200;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Pwenlee
 * @date 2019/4/4 09:27
 * @description
 */
public class Q279 {
//    279. 完全平方数
//    给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//
//    示例 1:
//
//    输入: n = 12
//    输出: 3
//    解释: 12 = 4 + 4 + 4.
//    示例 2:
//
//    输入: n = 13
//    输出: 2
//    解释: 13 = 4 + 9.

    private static Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 1);
        map.put(5, 2);
        map.put(6, 3);
    }

    public static int numSquares(int n) {
        Integer value = map.get(n);
        if(Objects.nonNull(value)){
            return value.intValue();
        }
        value = Integer.MAX_VALUE;
        double sqrt = Math.sqrt(n);
        if(isInteger(sqrt)){
            value = 1;
        }else{
            for(int m = (int)sqrt; m >= 1; m--) {
                value = Math.min(value, 1 + numSquares(n - m * m));
            }
        }
        map.put(n, value);
        return value;
    }

    private static boolean isInteger(double obj) {
        // 精度范围
        double eps = 1e-10;
        return obj-Math.floor(obj) < eps;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
