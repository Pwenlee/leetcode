package com.lee.leetcode.Q100;

/**
 * @author Pwenlee
 * @date 2019/3/19 20:31
 * @description
 */
public class Q125 {
//    125. 验证回文串
//    给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
//    说明：本题中，我们将空字符串定义为有效的回文串。
//
//    示例 1:
//
//    输入: "A man, a plan, a canal: Panama"
//    输出: true
//    示例 2:
//
//    输入: "race a car"
//    输出: false

    public static boolean isPalindrome(String s) {
        if(s.length() <= 1){
            return true;
        }
        char[] chars = s.toCharArray();
        int beginIndex = 0;
        int endIndex = chars.length - 1;
        while(beginIndex != endIndex && beginIndex - 1 != endIndex){
            char c1 = chars[beginIndex];
            char c2 = chars[endIndex];
            if(!isNumber(c1) && !isLetter(c1)){
                beginIndex++;
                continue;
            }
            if(!isNumber(c2) && !isLetter(c2)){
                endIndex--;
                continue;
            }
            if(isLetter(c1) && isLetter(c2)){
                if(c1 != c2 && c1 + 32 != c2 && c1-32 != c2){
                    return false;
                }
            }else {
                if (c1 != c2) {
                    return false;
                }
            }
            beginIndex++;
            endIndex--;
        }
        return true;
    }

    private static boolean isNumber(char c){
        return c >= 48 && c <= 57;
    }

    private static boolean isLetter(char c){
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("ab"));
    }
}
