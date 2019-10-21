package com.lee.leetcode.Q200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Q211 {

//    211. 添加与搜索单词 - 数据结构设计
//    设计一个支持以下两种操作的数据结构：
//
//    void addWord(word)
//    bool search(word)
//    search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
//
//    示例:
//
//    addWord("bad")
//    addWord("dad")
//    addWord("mad")
//    search("pad") -> false
//    search("bad") -> true
//    search(".ad") -> true
//    search("b..") -> true
//    说明:
//
//    你可以假设所有单词都是由小写字母 a-z 组成的。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/add-and-search-word-data-structure-design
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    static class WordDictionary {

        private HashMap<Integer, Set<String>> dictionary;

        /** Initialize your data structure here. */
        public WordDictionary() {
            dictionary = new HashMap<>();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            int length = word.length();
            Set<String> set = dictionary.getOrDefault(length, new HashSet<>());
            set.add(word);
            dictionary.put(length, set);
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            int length = word.length();
            Set<String> set = dictionary.getOrDefault(length, new HashSet<>());
            if(null == set || set.isEmpty()){
                return false;
            }
            if(!word.contains(".")){
                return set.contains(word);
            }else{
                for (String s : set) {
                    if(like(word, s)){
                        return true;
                    }
                }
                return false;
            }
        }

        private boolean like(String regex, String word){
            char[] regexChars = regex.toCharArray();
            char[] wordChars = word.toCharArray();
            for (int i = 0; i < wordChars.length; i++) {
                if(regexChars[i] != '.' && regexChars[i] != wordChars[i]){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        WordDictionary dictionary = new Q211.WordDictionary();
        dictionary.addWord("ab");
        dictionary.addWord("a");
        //dictionary.addWord("mad");
        System.out.println(dictionary.search(".a"));
        //System.out.println(dictionary.search("bad"));
        //System.out.println(dictionary.search(".ad"));
        //System.out.println(dictionary.search("b.."));

    }
}
