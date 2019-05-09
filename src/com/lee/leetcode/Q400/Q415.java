package com.lee.leetcode.Q400;

/**
 * @author Pwenlee
 * @date 2019/5/9 17:32
 * @description
 */
public class Q415 {
//    415. 字符串相加
//    给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
//
//    注意：
//
//    num1 和num2 的长度都小于 5100.
//    num1 和num2 都只包含数字 0-9.
//    num1 和num2 都不包含任何前导零。
//    你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。

    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int length1 = num1.length();
        int length2 = num2.length();
        StringBuilder prefix = new StringBuilder();
        int minus = Math.abs(length1 - length2);
        while(minus > 0){
            prefix.append("0");
            minus--;
        }
        if(length1 > length2){
            num2 = prefix.toString() + num2;
        }else{
            num1 = prefix.toString() + num1;
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        boolean flow = false;
        for(int i = Math.max(length1, length2); i > 0;i--){
            int value = chars1[i-1] - 48 + chars2[i-1] - 48;
            value = flow ? value + 1 : value;
            if(value > 9){
                result.insert(0,value - 10);
                flow = true;
            }else{
                result.insert(0,value);
                flow = false;
            }
        }
        if(flow){
            result.insert(0,1);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("1", "9"));
    }
}
