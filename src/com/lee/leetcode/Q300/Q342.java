package com.lee.leetcode.Q300;

import com.lee.leetcode.Common;

/**
 * @author Pwenlee
 * @date 2019/4/28 16:28
 * @description
 */
public class Q342 {
//    342. 4的幂
//    给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
//
//    示例 1:
//
//    输入: 16
//    输出: true
//    示例 2:
//
//    输入: 5
//    输出: false

    public boolean isPowerOfFour(int num) {
        return Common.isPowerOf2(num) && num % 3 == 1;
    }
}
