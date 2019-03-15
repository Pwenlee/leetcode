package com.lee.leetcode.Q100;

/**
 * @author Pwenlee
 * @date 2019/3/15 09:27
 * @description
 */
public class Q171 {

//    171. Excel表列序号
//    给定一个Excel表格中的列名称，返回其相应的列序号。
//
//    例如，
//
//    A -> 1
//    B -> 2
//    C -> 3
//            ...
//    Z -> 26
//    AA -> 27
//    AB -> 28
//            ...
//    示例 1:
//
//    输入: "A"
//    输出: 1
//    示例 2:
//
//    输入: "AB"
//    输出: 28
//    示例 3:
//
//    输入: "ZY"
//    输出: 701

    public static int titleToNumber(String s) {
        if(null == s || s.length() == 0){
            return 0;
        }
        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            result = result + (chars[i] - 64) * (int)Math.pow(26, chars.length-1-i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AZ"));
    }
}
