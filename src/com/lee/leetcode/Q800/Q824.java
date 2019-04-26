package com.lee.leetcode.Q800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Pwenlee
 * @date 2019/4/26 17:04
 * @description
 */
public class Q824 {
//    824. 山羊拉丁文
//    给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
//
//    我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
//
//    山羊拉丁文的规则如下：
//
//    如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
//    例如，单词"apple"变为"applema"。
//
//    如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
//    例如，单词"goat"变为"oatgma"。
//
//    根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
//    例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
//    返回将 S 转换为山羊拉丁文后的句子。
//
//    示例 1:
//
//    输入: "I speak Goat Latin"
//    输出: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
//    示例 2:
//
//    输入: "The quick brown fox jumped over the lazy dog"
//    输出: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
//    说明:
//
//    S 中仅包含大小写字母和空格。单词间有且仅有一个空格。
//            1 <= S.length <= 150。

    private static final List<String> vowelList = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u", "A", "E", "I", "O", "U"));

    public static String toGoatLatin(String S) {
        String[] array = S.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            String s = array[i];
            String start = s.substring(0, 1);
            StringBuilder ele = new StringBuilder();
            if(vowelList.contains(start)){
                ele.append(s).append("ma");
            }else{
                ele.append(s.substring(1)).append(start).append("ma");
            }
            int j = 0;
            while(j <= i){
                ele.append("a");
                j++;
            }
            result.append(ele).append(" ");
        }
        return result.substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(toGoatLatin("I speak Goat Latin"));
    }

}
