package com.lee.leetcode.Q400;

import java.util.*;

/**
 * @author Pwenlee
 * @date 2019/5/29 16:22
 * @description
 */
public class Q423 {
//    423. 从英文中重建数字
//    给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。
//
//    注意:
//
//    输入只包含小写英文字母。
//    输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
//    输入字符串的长度小于 50,000。
//    示例 1:
//
//    输入: "owoztneoer"
//
//    输出: "012" (zeroonetwo)
//    示例 2:
//
//    输入: "fviefuro"
//
//    输出: "45" (fourfive)


    private static final List<char[]> LIST = new ArrayList<>(Arrays.asList(
            //0-z
            new char[]{'0','z','e','r','o'},
            //2-w
            new char[]{'2','w','t','o'},
            //6-x
            new char[]{'6','x','s','i'},
            //7-s
            new char[]{'7','s','e','v','e','n'},
            //5-v
            new char[]{'5','v','f','i','e'},
            //4-f
            new char[]{'4','f','o','u','r'},
            //8-g
            new char[]{'8','g','e','i','h','t'},
            //9-i
            new char[]{'9','i','n','n','e'},
            //1-o
            new char[]{'1','o','n','e'},
            //3-t
            new char[]{'3','t','h','r','e','e'}
    ));

    private static final char[] BASE = new char[]{'0','1','2','3','4','5','6','7','8','9'};

    public static String originalDigits(String s) {
        int[] counts = new int[10];
        Map<Character, Integer> map = new HashMap<>(15);
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < LIST.size(); i++) {
            char[] chars1 = LIST.get(i);
            char c = chars1[1];
            int index = (chars1[0] - 48);
            counts[index] = map.getOrDefault(c, 0);
            if(counts[index] != 0){
                int length = chars1.length;
                for(int j = 2; j < length; j++){
                    char c1 = chars1[j];
                    if(null != map.get(c1)) {
                        map.put(c1, map.get(c1) - counts[index]);
                    }
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            while(count > 0){
                result.append(BASE[i]);
                count--;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(originalDigits("owoztneoer"));
    }
}
