package com.lee.leetcode.Q400;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Pwenlee
 * @date 2019/2/25 20:29
 * @description
 */
public class Q409 {
//    409. 最长回文串
//    给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
//
//    在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
//
//    注意:
//    假设字符串的长度不会超过 1010。
//
//    示例 1:
//
//    输入:
//            "abccccdd"
//
//    输出:
//            7
//
//    解释:
//    我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
    public static int longestPalindrome(String s) {
        if(Objects.isNull(s) || s.length() <= 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Integer count = map.get(chars[i]);
            if(Objects.isNull(count)){
                map.put(chars[i], 1);
            }else{
                count = count + 1;
                map.put(chars[i], count);
            }
        }
        int result = 0;
        int flag = 0;
        for (Integer value : map.values()) {
            if(value % 2 == 1){
                flag = 1;
                result = result + 1;
            }
        }
        return  s.length() - result + flag;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccddtt"));
    }
}
