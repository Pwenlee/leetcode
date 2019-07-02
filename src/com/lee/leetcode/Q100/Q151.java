package com.lee.leetcode.Q100;

/**
 * @author Pwenlee
 * @date 2019/7/2 16:11
 * @description
 */
public class Q151 {
//    151. 翻转字符串里的单词
//    给定一个字符串，逐个翻转字符串中的每个单词。
//
//    示例 1：
//
//    输入: "the sky is blue"
//    输出: "blue is sky the"
//    示例 2：
//
//    输入: "  hello world!  "
//    输出: "world! hello"
//    解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
//    示例 3：
//
//    输入: "a good   example"
//    输出: "example good a"
//    解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
//             
//
//    说明：
//
//    无空格字符构成一个单词。
//    输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
//    如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
//             
//
//    进阶：
//    请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。

    public static String reverseWords(String s) {
        if(s.length() == 0){
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (char c : chars) {
            if(c == ' '){
                if(word.length() > 0){
                    result.insert(0, word + " ");
                    word = new StringBuilder();
                }
            }else{
                word.append(c);
            }
        }
        if(word.length() > 0){
            result.insert(0, word + " ");
        }
        return result.length() == 0 ? "" : result.substring(0, result.length() - 1);
    }


    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world!  "));
    }
}
