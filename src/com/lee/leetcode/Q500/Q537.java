package com.lee.leetcode.Q500;

/**
 * @author Pwenlee
 * @date 2019/3/19 16:31
 * @description
 */
public class Q537 {
//    537. 复数乘法
//    给定两个表示复数的字符串。
//
//    返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。
//
//    示例 1:
//
//    输入: "1+1i", "1+1i"
//    输出: "0+2i"
//    解释: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
//    示例 2:
//
//    输入: "1+-1i", "1+-1i"
//    输出: "0+-2i"
//    解释: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
//    注意:
//
//    输入字符串不包含额外的空格。
//    输入字符串将以 a+bi 的形式给出，其中整数 a 和 b 的范围均在 [-100, 100] 之间。输出也应当符合这种形式。

    public static String complexNumberMultiply(String a, String b) {
        int[] a1 = simple(a);
        int[] b1 = simple(b);
        int value = a1[0] * b1[0] - a1[1] * b1[1];
        int i = a1[0] * b1[1] + a1[1] * b1[0];
        return new StringBuilder().append(value).append("+").append(i).append("i").toString();
    }

    private static int[] simple(String s){
        int[] result = new int[2];
        int i = 0;
        char[] chars = s.toCharArray();
        char operator = '+';
        StringBuilder value = new StringBuilder();
        for (char c : chars) {
            if(c == 'i'){
                if(value.length() > 0){
                    result[i] = Integer.valueOf(new StringBuilder().append(operator).append(value).toString());
                    i++;
                }
            }
            if(c == '+' || c == '-'){
                if(value.length() > 0){
                    result[i] = Integer.valueOf(new StringBuilder().append(operator).append(value).toString());
                    i++;
                }
                operator = c;
                value = new StringBuilder();
            }else{
                value.append(c);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));
    }
}
