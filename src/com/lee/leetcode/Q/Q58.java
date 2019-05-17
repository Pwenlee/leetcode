package com.lee.leetcode.Q;

/**
 * @author Pwenlee
 * @date 2019/5/17 16:43
 * @description
 */
public class Q58 {
//    58. 最后一个单词的长度
//    给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
//
//    如果不存在最后一个单词，请返回 0 。
//
//    说明：一个单词是指由字母组成，但不包含任何空格的字符串。
//
//    示例:
//
//    输入: "Hello World"
//    输出: 5

    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            char c = chars[i];
            if(c == ' '){
                if(result != 0){
                    return result;
                }
            }else{
                result++;
            }
        }
        return result;
    }
}
