package com.lee.leetcode.Q400;

import java.util.*;

/**
 * @author Pwenlee
 * @date 2019/6/24 16:57
 * @description
 */
public class Q438 {
//    438. 找到字符串中所有字母异位词
//    给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
//
//    字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
//
//    说明：
//
//    字母异位词指字母相同，但排列不同的字符串。
//    不考虑答案输出的顺序。
//    示例 1:
//
//    输入:
//    s: "cbaebabacd" p: "abc"
//
//    输出:
//            [0, 6]
//
//    解释:
//    起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//    起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
//             示例 2:
//
//    输入:
//    s: "abab" p: "ab"
//
//    输出:
//            [0, 1, 2]
//
//    解释:
//    起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//    起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//    起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。

    private static List<Character> KEYS = new ArrayList<>(26);

    static {
        for (int i = 'a'; i <= 'z'; i++){
            KEYS.add((char)i);
        }
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> map1 = new HashMap<>(26);
        char[] pChars = p.toCharArray();
        for (char c : pChars) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int pLength = p.length();
        int sLength = s.length();
        Map<Character, Integer> map2 = new HashMap<>(26);
        String subStr = s.substring(0, 0 + pLength);
        char[] subStrChars = subStr.toCharArray();
        for (char c : subStrChars) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        if(isAnagrams(map1, map2)){
            result.add(0);
        }

        char[] sChars = s.toCharArray();
        for (int i = 1; i + pLength <= sLength; i++) {
            char oldC = sChars[i - 1];
            char newC = sChars[i + pLength - 1];
            map2.put(oldC, map2.get(oldC) - 1);
            map2.put(newC, map2.getOrDefault(newC, 0) + 1);
            if(isAnagrams(map1, map2)){
                result.add(i);
            }
        }
        return result;
    }

    private static boolean isAnagrams(Map<Character, Integer> map1, Map<Character, Integer> map2){
        for (Character key : KEYS) {
            if(!map1.getOrDefault(key, 0).equals(map2.getOrDefault(key, 0))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
