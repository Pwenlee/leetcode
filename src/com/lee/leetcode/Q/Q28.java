package com.lee.leetcode.Q;

/**
 * @author Pwenlee
 * @date 2019/4/26 17:23
 * @description
 */
public class Q28 {
//    28. 实现strStr()
//    实现 strStr() 函数。
//
//    给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
//
//    示例 1:
//
//    输入: haystack = "hello", needle = "ll"
//    输出: 2
//    示例 2:
//
//    输入: haystack = "aaaaa", needle = "bba"
//    输出: -1
//    说明:
//
//    当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
//
//    对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

    public static int strStr(String haystack, String needle) {
        if("".equals(needle)){
            return 0;
        }
        if("".equals(haystack) || haystack.length() < needle.length()){
            return -1;
        }
        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();
        First:
        for (int i = 0; i <= chars1.length - chars2.length; i++) {
            if(chars1[i] == chars2[0]){
                for(int j = i+1,z=1; z< chars2.length; j++,z++){
                    if(chars1[j] != chars2[z]){
                        continue First;
                    }
                }
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("aaaaa", "bba"));
    }
}
