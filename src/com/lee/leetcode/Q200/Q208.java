package com.lee.leetcode.Q200;

import java.util.HashSet;

/**
 * @author Pwenlee
 * @date 2020-05-04 10:39
 * @description
 */
public class Q208 {
//    208. 实现 Trie (前缀树)
//    实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
//
//    示例:
//
//    Trie trie = new Trie();
//
//    trie.insert("apple");
//    trie.search("apple");   // 返回 true
//    trie.search("app");     // 返回 false
//    trie.startsWith("app"); // 返回 true
//    trie.insert("app");
//    trie.search("app");     // 返回 true
//    说明:
//
//    你可以假设所有的输入都是由小写字母 a-z 构成的。
//    保证所有输入均为非空字符串。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    class Trie {

        private HashSet<String> set;

        private HashSet<String> prefixSet;

        /** Initialize your data structure here. */
        public Trie() {
            set = new HashSet<>();
            prefixSet = new HashSet<>();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            set.add(word);
            StringBuilder prefix = new StringBuilder();
            for (char c : word.toCharArray()) {
                prefix.append(c);
                prefixSet.add(prefix.toString());
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            return set.contains(word);
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return prefixSet.contains(prefix);
        }
    }

}
