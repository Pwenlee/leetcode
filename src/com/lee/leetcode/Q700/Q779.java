package com.lee.leetcode.Q700;

/**
 * @author Pwenlee
 * @date 2019/3/22 10:30
 * @description
 */
public class Q779 {
//    779. 第K个语法符号
//    在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
//
//    给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
//
//    例子:
//
//    输入: N = 1, K = 1
//    输出: 0
//
//    输入: N = 2, K = 1
//    输出: 0
//
//    输入: N = 2, K = 2
//    输出: 1
//
//    输入: N = 4, K = 5
//    输出: 1
//
//    解释:
//    第一行: 0
//    第二行: 01
//    第三行: 0110
//    第四行: 01101001
//
//    注意：
//
//    N 的范围 [1, 30].
//    K 的范围 [1, 2^(N-1)].

    public static int kthGrammar(int N, int K) {
        if(N == 1){
            return 0;
        }else if(N == 2){
            return K == 1 ? 0: 1;
        }else{
            boolean mod2 = K % 2 == 0;
            //移位运算符的优先级低于+ -  K>>1+1 = K>>2 这里要加上括号  先右移再+1
            //虽然K>>1 == K/2 但是运算符的优先级不一样
            int previous = kthGrammar(N-1, mod2 ? K>>1 : (K>>1) + 1);
            if(previous == 1){
                if(mod2){
                    return 0;
                }else{
                    return 1;
                }
            }else{
                if(mod2){
                    return 1;
                }else{
                    return 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        //System.out.println(kthGrammar(3,1));
        System.out.println(false ? 1>>1 : (1>>1) + 1);
    }
}
