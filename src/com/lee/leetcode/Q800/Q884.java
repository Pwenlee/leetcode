package com.lee.leetcode.Q800;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Pwenlee
 * @date 2019/4/30 09:48
 * @description
 */
public class Q884 {
//    884. 两句话中的不常见单词
//    给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
//
//    如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
//
//    返回所有不常用单词的列表。
//
//    您可以按任何顺序返回列表。
//
//    示例 1：
//
//    输入：A = "this apple is sweet", B = "this apple is sour"
//    输出：["sweet","sour"]
//    示例 2：
//
//    输入：A = "apple apple", B = "banana"
//    输出：["banana"]
//
//    提示：
//
//            0 <= A.length <= 200
//            0 <= B.length <= 200
//    A 和 B 都只包含空格和小写字母。

    public String[] uncommonFromSentences(String A, String B) {
        String[] arrA = A.split(" ");
        String[] arrB = A.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String s : arrA) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : arrB) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> list = map.keySet().stream().filter(ele -> map.get(ele) == 1).collect(Collectors.toList());
        return list.toArray(new String[list.size()]);

    }
}
