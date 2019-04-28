package com.lee.leetcode.Q200;

import com.lee.leetcode.Common;

/**
 * @author Pwenlee
 * @date 2019/4/28 15:08
 * @description
 */
public class Q231 {
//    231. 2的幂
//    给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
//
//    示例 1:
//
//    输入: 1
//    输出: true
//    解释: 20 = 1
//    示例 2:
//
//    输入: 16
//    输出: true
//    解释: 24 = 16
//    示例 3:
//
//    输入: 218
//    输出: false

    public boolean isPowerOfTwo(int n) {
        return Common.isPowerOf2(n);
    }
}
