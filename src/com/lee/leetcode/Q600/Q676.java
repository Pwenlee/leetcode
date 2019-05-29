package com.lee.leetcode.Q600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pwenlee
 * @date 2019/5/29 14:09
 * @description
 */
public class Q676 {
//    676. 实现一个魔法字典
//    实现一个带有buildDict, 以及 search方法的魔法字典。
//
//    对于buildDict方法，你将被给定一串不重复的单词来构建一个字典。
//
//    对于search方法，你将被给定一个单词，并且判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
//
//    示例 1:
//
//    Input: buildDict(["hello", "leetcode"]), Output: Null
//    Input: search("hello"), Output: False
//    Input: search("hhllo"), Output: True
//    Input: search("hell"), Output: False
//    Input: search("leetcoded"), Output: False
//    注意:
//
//    你可以假设所有输入都是小写字母 a-z。
//    为了便于竞赛，测试所用的数据量很小。你可以在竞赛结束后，考虑更高效的算法。
//    请记住重置MagicDictionary类中声明的类变量，因为静态/类变量会在多个测试用例中保留。 请参阅这里了解更多详情。

    class MagicDictionary {

        private HashMap<Integer, List<String>> map;

        /** Initialize your data structure here. */
        public MagicDictionary() {
            map = new HashMap<>();
        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {
            for (String s : dict) {
                int length = s.length();
                List<String> list = map.getOrDefault(length, new ArrayList<>());
                list.add(s);
                map.put(length, list);
            }
        }

        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search(String word) {
            int length = word.length();
            List<String> list = map.get(length);
            if(null != list && list.size() > 0){
                for (String s : list) {
                    if(like(s, word)){
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean like(String s1, String s2){
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            int diff = 0;
            for (int i = 0; i < chars1.length; i++) {
                if(chars1[i] != chars2[i]){
                    diff++;
                    if(diff == 2){
                        return false;
                    }
                }
            }
            return diff == 1;
        }
    }
}
