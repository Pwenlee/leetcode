package com.lee.leetcode.Q100;

/**
 * @author Pwenlee
 * @date 2019/3/15 10:05
 * @description
 */
public class Q168 {
//    168. Excel表列名称
//    给定一个正整数，返回它在 Excel 表中相对应的列名称。
//
//    例如，
//
//            1 -> A
//    2 -> B
//    3 -> C
//    ...
//            26 -> Z
//    27 -> AA
//    28 -> AB
//    ...
//    示例 1:
//
//    输入: 1
//    输出: "A"
//    示例 2:
//
//    输入: 28
//    输出: "AB"
//    示例 3:
//
//    输入: 701
//    输出: "ZY"
    public static String convertToTitle(int n) {
        String result = "";
        while(n > 26){
            if(n%26 != 0) {
                result = new String(new char[]{(char) (n % 26 + 64)}) + result;
                n = n / 26;
            }else{
                result = new String(new char[]{(char) (26 + 64)}) + result;
                n = n / 26 - 1;
            }
        }
        result =  new String(new char[]{(char) (n+64)}) + result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(52));
    }
}
