package com.lee.leetcode.Q700;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Pwenlee
 * @date 2019/2/13 14:12
 * @description
 */
public class Q784 {

//    784. 字母大小写全排列
//
//    给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
//
//    示例:
//    输入: S = "a1b2"
//    输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
//
//    输入: S = "3z4"
//    输出: ["3z4", "3Z4"]
//
//    输入: S = "12345"
//    输出: ["12345"]
//    注意：
//
//    S 的长度不超过12。
//    S 仅由数字和字母组成。

    public static List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        result.add(S);
        if(Objects.nonNull(S) && S.length() > 0){
            char[] chars = S.toCharArray();
            for(int i=0;i<chars.length;i++){
                char character = chars[i];
                int count = result.size();
                if(character >= 'a' && character <= 'z'){
                    for(int j=0;j<count;j++){
                        result.add(new StringBuilder(result.get(j).substring(0, i)).append(character).append(S.substring(i+1)).toString());
                        result.add(new StringBuilder(result.get(j).substring(0, i)).append((char)(character + 32)).append(S.substring(i+1)).toString());
                    }
                }else if(character >= 'A' && character <= 'Z'){
                    for(int j=0;j<count;j++){
                        result.add(new StringBuilder(result.get(j).substring(0, i)).append(character).append(S.substring(i+1)).toString());
                        result.add(new StringBuilder(result.get(j).substring(0, i)).append((char)(character - 32)).append(S.substring(i+1)).toString());
                    }
                }
            }
        }
        HashSet set = new HashSet(result);
        result.clear();
        result.addAll(set);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("12345").stream().collect(Collectors.joining(",")));
    }
}
