package com.lee.leetcode.Q700;

/**
 * @author Pwenlee
 * @date 2019/5/17 17:34
 * @description
 */
public class Q709 {

//    709. 转换成小写字母
//    实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
//
//    示例 1：
//
//    输入: "Hello"
//    输出: "hello"
//    示例 2：
//
//    输入: "here"
//    输出: "here"
//    示例 3：
//
//    输入: "LOVELY"
//    输出: "lovely"

    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            char c = chars[i];
            chars[i] = (char)((c >= 65 && c <= 90) ? c + 32 : c);
        }
        return new String(chars);
    }
}
