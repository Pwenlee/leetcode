package com.lee.leetcode.Q400;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Pwenlee
 * @date 2019/4/26 14:07
 * @description
 */
public class Q451 {
//    451. 根据字符出现频率排序
//    给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
//
//    示例 1:
//
//    输入:
//            "tree"
//
//    输出:
//            "eert"
//
//    解释:
//            'e'出现两次，'r'和't'都只出现一次。
//    因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
//    示例 2:
//
//    输入:
//            "cccaaa"
//
//    输出:
//            "cccaaa"
//
//    解释:
//            'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//    注意"cacaca"是不正确的，因为相同的字母必须放在一起。
//    示例 3:
//
//    输入:
//            "Aabb"
//
//    输出:
//            "bbAa"
//
//    解释:
//    此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//    注意'A'和'a'被认为是两种不同的字符。

    public static String frequencySort(String s) {
        if(Objects.isNull(s) || s.length() <= 1){
            return s;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            Integer count = map.getOrDefault(c, 0);
            count++;
            map.put(c, count);
        }
        List<String> list = new ArrayList<>(map.size());
        for (Character c : map.keySet()) {
            int count = map.get(c);
            char[] chars1 = new char[count];
            for(int i = 1; i <= count; i++){
                chars1[i-1] = c;
            }
            list.add(new String(chars1));
        }
        return list.stream().sorted(Comparator.comparingInt(String::length).reversed()).collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}
