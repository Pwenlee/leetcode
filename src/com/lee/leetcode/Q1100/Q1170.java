package com.lee.leetcode.Q1100;

import java.util.Arrays;

public class Q1170 {
//    1170. 比较字符串最小字母出现频次
//    我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。
//
//    例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
//
//    现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
//
//    示例 1：
//
//    输入：queries = ["cbd"], words = ["zaaaz"]
//    输出：[1]
//    解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
//    示例 2：
//
//    输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
//    输出：[1,2]
//    解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
//             
//    提示：
//            1 <= queries.length <= 2000
//            1 <= words.length <= 2000
//            1 <= queries[i].length, words[i].length <= 10
//    queries[i][j], words[i][j] 都是小写英文字母
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/compare-strings-by-frequency-of-the-smallest-character
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int wordsLength = words.length;
        int[] wordsValue = new int[wordsLength];
        for (int i = 0; i < wordsLength; i++) {
            wordsValue[i] = smallerByFrequency(words[i]);
        }
        Arrays.sort(wordsValue);
        int queriesLength = queries.length;
        int[] queriesValue = new int[queriesLength];
        for (int i = 0; i < queriesLength; i++) {
            int queryValue = smallerByFrequency(queries[i]);
            for (int j = 0; j < wordsLength; j++) {
                if(wordsValue[j] > queryValue){
                    queriesValue[i] = wordsLength - j;
                    break;
                }
            }
        }
        return queriesValue;
    }

    private int smallerByFrequency(String word){
        int[] letters = new int[26];
        char[] chars = word.toCharArray();
        for (char c : chars) {
            letters[c - 97]++;
        }
        return Arrays.stream(letters).filter(ele -> ele != 0).findFirst().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q1170().numSmallerByFrequency(new String[]{"bbb", "cc"}, new String[]{"a", "aa", "aaa", "aaaa"})));
    }
}
