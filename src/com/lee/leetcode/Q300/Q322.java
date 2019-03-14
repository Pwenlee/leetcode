package com.lee.leetcode.Q300;

/**
 * @author Pwenlee
 * @date 2019/3/13 16:03
 * @description
 */
public class Q322 {

//    322. 零钱兑换
//    给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
//
//    示例 1:
//
//    输入: coins = [1, 2, 5], amount = 11
//    输出: 3
//    解释: 11 = 5 + 5 + 1
//    示例 2:
//
//    输入: coins = [2], amount = 3
//    输出: -1
//    说明:
//    你可以认为每种硬币的数量是无限的。

    public static int coinChange(int[] coins, int amount) {
        int[] result = new int[amount+1];
        result[0] = 0;
        for(int i=1;i<=amount;i++){
            result[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if(coin <= amount && i-coin >= 0 && result[i-coin] != -1){
                    result[i] = Math.min(result[i], result[i-coin]+1);
                }
            }
            result[i] = result[i] == Integer.MAX_VALUE ? -1 : result[i];
        }
        return result[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }
}
