package com.lee.leetcode.Q500;

/**
 * @author Pwenlee
 * @date 2019/3/15 15:50
 * @description
 */
public class Q507 {
//    507. 完美数
//    对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
//
//    给定一个 正整数 n， 如果他是完美数，返回 True，否则返回 False
//
//    示例：
//
//    输入: 28
//    输出: True
//    解释: 28 = 1 + 2 + 4 + 7 + 14
//
//    注意:
//
//    输入的数字 n 不会超过 100,000,000. (1e8)

    public boolean checkPerfectNumber(int num) {
        if(num <= 0){
            return false;
        }
        int sum = 0;
        for(int i=1;i<=num/2;i++){
            if(num % i == 0){
                sum = sum + i;
            }
        }
        return sum == num;
    }
}
