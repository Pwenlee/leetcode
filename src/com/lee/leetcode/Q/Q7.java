package com.lee.leetcode.Q;

/**
 * @author Pwenlee
 * @date 2019/7/11 16:40
 * @description
 */
public class Q7 {
//    7. 整数反转
//    给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
//    示例 1:
//
//    输入: 123
//    输出: 321
//             示例 2:
//
//    输入: -123
//    输出: -321
//    示例 3:
//
//    输入: 120
//    输出: 21
//    注意:
//
//    假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

    public static int reverse(int x) {
        long x1 = x;
        if(x1 > -10 && x1 < 10){
            return (int)x1;
        }
        StringBuilder operator = new StringBuilder();
        if(x1 < 0){
            operator.append("-");
            x1 = 0 - x1;
        }
        StringBuilder number = new StringBuilder();
        char[] chars = String.valueOf(x1).toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if(number.length() != 0 || chars[i] != '0'){
                number.append(chars[i]);
            }
        }
        Long result = Long.valueOf(operator.append(number).toString());
        return result.longValue() > Integer.MAX_VALUE || result.longValue() < Integer.MIN_VALUE ? 0 : result.intValue();
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }
}
