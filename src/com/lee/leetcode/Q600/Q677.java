package com.lee.leetcode.Q600;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pwenlee
 * @date 2019/5/17 17:28
 * @description
 */
public class Q677 {
//    677. 键值映射
//    实现一个 MapSum 类里的两个方法，insert 和 sum。
//
//    对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
//
//    对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
//
//    示例 1:
//
//    输入: insert("apple", 3), 输出: Null
//    输入: sum("ap"), 输出: 3
//    输入: insert("app", 2), 输出: Null
//    输入: sum("ap"), 输出: 5

    class MapSum {

        private Map<String, Integer> map;

        /** Initialize your data structure here. */
        public MapSum() {
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {
            int sum = 0;
            for (String s : map.keySet()) {
                if(s.startsWith(prefix)){
                    sum = sum + map.get(s);
                }
            }
            return sum;
        }
    }
}
