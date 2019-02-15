package com.lee.leetcode.Q300;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Pwenlee
 * @date 2019/2/12 14:43
 * @description
 */
public class Q387 {
//    387. 字符串中的第一个唯一字符
//    给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
//    案例:
//
//    s = "leetcode"
//    返回 0.
//
//    s = "loveleetcode",
//    返回 2.
//
//
//    注意事项：您可以假定该字符串只包含小写字母。

    public static int firstUniqChar(String s) {
        if(Objects.isNull(s) || s.length() == 0){
            return -1;
        }
        char[] chars = s.toCharArray();
        int result = -1;
        List<Character> repeatedCharList = new ArrayList<>();
        for (int i=0;i<chars.length;i++) {
            char character = chars[i];
            if(!repeatedCharList.contains(character)){
                if(s.indexOf(character) == s.lastIndexOf(character)){
                    result = i;
                    break;
                }
            }
            repeatedCharList.add(character);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
}
