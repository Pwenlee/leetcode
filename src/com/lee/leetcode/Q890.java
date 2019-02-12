package com.lee.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lipan
 * @date 2019/1/28 15:44
 * @description
 */
public class Q890 {
//    890. 查找和替换模式
//    你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
//
//    如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
//
//            （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
//
//    返回 words 中与给定模式匹配的单词列表。
//
//    你可以按任何顺序返回答案。
//
//
//
//    示例：
//
//    输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
//    输出：["mee","aqq"]
//    解释：
//            "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
//            "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
//    因为 a 和 b 映射到同一个字母。

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        if(null == words || words.length == 0){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        First:
        for (String word : words) {
            if(null != words){
                if("".equals(pattern)){
                    if("".equals(word)){
                        result.add(word);
                    }
                }else {
                    if (word.length() == pattern.length()) {
                        Map<Character, Character> map = new HashMap<>(pattern.length());
                        for(int i=0;i<pattern.length();i++){
                            Character p = pattern.charAt(i);
                            Character w = word.charAt(i);
                            if(map.containsKey(p)){
                                if(!w.equals(map.get(p))){
                                    continue First;
                                }
                            }else{
                                if(map.values().contains(w)){
                                    continue First;
                                }
                                map.put(p, w);
                            }
                        }
                        result.add(word);
                    }
                }
            }
        }
        return result;
    }
}
