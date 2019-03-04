package com.lee.leetcode.Q800;

/**
 * @author Administrator
 * @date 2019/3/4 21:21
 * @description
 */
public class Q844 {
//    844. 比较含退格的字符串
//    给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
//
//    示例 1：
//
//    输入：S = "ab#c", T = "ad#c"
//    输出：true
//    解释：S 和 T 都会变成 “ac”。
//    示例 2：
//
//    输入：S = "ab##", T = "c#d#"
//    输出：true
//    解释：S 和 T 都会变成 “”。
//    示例 3：
//
//    输入：S = "a##c", T = "#a#c"
//    输出：true
//    解释：S 和 T 都会变成 “c”。
//    示例 4：
//
//    输入：S = "a#c", T = "b"
//    输出：false
//    解释：S 会变成 “c”，但 T 仍然是 “b”。
//
//    提示：
//
//            1 <= S.length <= 200
//            1 <= T.length <= 200
//    S 和 T 只含有小写字母以及字符 '#'。

    public static boolean backspaceCompare(String S, String T) {
        return done(S).equals(done(T));
    }

    private static String done(String s){
        if(s.length() == 0){
            return s;
        }
        while(s.startsWith("#")){
            s = s.substring(1);
        }
        while(s.indexOf("#") > 0) {
            char[] chars = s.toCharArray();
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == '#') {
                    String temp = new String(new char[]{chars[i - 1]}) + "#";
                    s = s.replace(temp, "");
                    while(s.startsWith("#")){
                        s = s.substring(1);
                    }
                    break;
                }
            }
        }
        return s.replaceAll("#", "");
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("e##e#o##oyof##q","e##e#fq##o##oyof##q"));
    }
}
