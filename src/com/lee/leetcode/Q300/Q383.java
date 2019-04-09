package com.lee.leetcode.Q300;

/**
 * @author Pwenlee
 * @date 2019/4/9 15:13
 * @description
 */
public class Q383 {
//    383. 赎金信
//    给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
//
//            (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
//
//    注意：
//
//    你可以假设两个字符串均只含有小写字母。
//
//    canConstruct("a", "b") -> false
//    canConstruct("aa", "ab") -> false
//    canConstruct("aa", "aab") -> true

    public static boolean canConstruct(String ransomNote, String magazine) {
        if("".equals(ransomNote)){
            return true;
        }
        char[] chars1 = ransomNote.toCharArray();
        char[] chars2 = magazine.toCharArray();
        First:
        for (int i = 0; i < chars1.length; i++) {
            char c1 = chars1[i];
            for (int j = i; j < chars2.length; j++) {
                char c2 = chars2[j];
                if(c1 == c2){
                    chars2[j] = chars2[i];
                    continue First;
                }
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("abc", "cdba"));
    }
}
