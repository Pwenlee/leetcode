package com.lee.leetcode.Q500;

/**
 * @author Pwenlee
 * @date 2019/4/4 16:33
 * @description
 */
public class Q557 {
//    557. 反转字符串中的单词 III
//    给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
//    示例 1:
//
//    输入: "Let's take LeetCode contest"
//    输出: "s'teL ekat edoCteeL tsetnoc"
//    注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。

    public static String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String ele : strings) {
            result.append(reverse(ele)).append(" ");
        }
        return result.substring(0, result.length() - 1);
    }

    private static String reverse(String s){
        char[] chars = s.toCharArray();
        for(int i = 1; i<= chars.length/2; i++){
            char c = chars[i-1];
            chars[i - 1] = chars[chars.length - i];
            chars[chars.length - i] = c;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("abcd dcba"));
    }
}
