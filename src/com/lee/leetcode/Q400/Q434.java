package com.lee.leetcode.Q400;

import java.util.Objects;

/**
 * @author Administrator
 * @date 2019/3/3 19:36
 * @description
 */
public class Q434 {

//    434. 字符串中的单词数
//
//    统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
//
//    请注意，你可以假定字符串里不包括任何不可打印的字符。
//
//    示例:
//
//    输入: "Hello, my name is John"
//    输出: 5
    public static int countSegments(String s) {
        if(Objects.isNull(s) || s.length() == 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ' '){
                for(int j = i+1; j < chars.length; j++){
                    i++;
                    if(chars[j] != ' '){
                        count++;
                        break;
                    }
                }
            }
        }
        return s.startsWith(" ") ? count : count+1;
    }

    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John   "));
    }
}
