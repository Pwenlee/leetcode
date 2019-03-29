package com.lee.leetcode.Q500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pwenlee
 * @date 2019/3/29 15:37
 * @description
 */
public class Q500 {

//    500. 键盘行
//    给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
//
//    American keyboard
//
//    示例：
//
//    输入: ["Hello", "Alaska", "Dad", "Peace"]
//    输出: ["Alaska", "Dad"]
//
//
//    注意：
//
//    你可以重复使用键盘上同一字符。
//    你可以假设输入的字符串将只包含字母。

    private static Map<Character, Character> map = new HashMap<>(26);

    static {
        map.put('Q', '1');map.put('W', '1');map.put('E', '1');map.put('R', '1');
        map.put('T', '1');map.put('Y', '1');map.put('U', '1');map.put('I', '1');
        map.put('O', '1');map.put('P', '1');
        map.put('A', '2');map.put('S', '2');map.put('D', '2');map.put('F', '2');
        map.put('G', '2');map.put('H', '2');map.put('J', '2');map.put('K', '2');
        map.put('L', '2');
        map.put('Z', '3');map.put('X', '3');map.put('C', '3');map.put('V', '3');
        map.put('B', '3');map.put('N', '3');map.put('M', '3');
    }

    public static String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if(check(word)){
                list.add(word);
            }
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    private static boolean check(String word){
        if(word.length() <= 1){
            return true;
        }else{
            word = word.toUpperCase();
            char[] chars = word.toCharArray();
            char value = map.get(chars[0]);
            for (int i = 1; i < chars.length; i++) {
                if(map.get(chars[i]).charValue() != value){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        findWords(new String[]{"adsdf","sfd"});
    }
}
