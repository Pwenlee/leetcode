package com.lee.leetcode.Q900;

/**
 * @author Pwenlee
 * @date 2019/4/8 14:58
 * @description
 */
public class Q984 {
//    984. 不含 AAA 或 BBB 的字符串
//    给定两个整数 A 和 B，返回任意字符串 S，要求满足：
//
//    S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母；
//    子串 'aaa' 没有出现在 S 中；
//    子串 'bbb' 没有出现在 S 中。
//
//    示例 1：
//
//    输入：A = 1, B = 2
//    输出："abb"
//    解释："abb", "bab" 和 "bba" 都是正确答案。
//    示例 2：
//
//    输入：A = 4, B = 1
//    输出："aabaa"
//
//    提示：
//
//            0 <= A <= 100
//            0 <= B <= 100
//    对于给定的 A 和 B，保证存在满足要求的 S。

    public String strWithout3a3b(int A, int B) {
        StringBuilder result = new StringBuilder();
        char c1, c2;
        if(A > B){
            c1 = 'a';
            A--;
        }else{
            c1 = 'b';
            B--;
        }
        if(A > B){
            c2 = 'a';
            A--;
        }else{
            c2 = 'b';
            B--;
        }
        result.append(c1).append(c2);
        while(A != 0 || B != 0){
           if(c1 == c2){
               if(c1 == 'a'){
                   result.append('b');
                   c2 = 'b';
                   B--;
               }else{
                   result.append('a');
                   c2 = 'c';
                   A--;
               }
           } else{
               c1 = c2;
               if(A > B){
                   c2 = 'a';
                   result.append('a');
                   A--;
               }else{
                   result.append('b');
                   c2 = 'b';
                   B--;
               }
           }
        }
        return result.toString();
    }

    public static void main(String[] args) {

    }
}
