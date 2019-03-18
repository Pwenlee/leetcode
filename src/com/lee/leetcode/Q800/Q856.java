package com.lee.leetcode.Q800;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Pwenlee
 * @date 2019/3/18 15:35
 * @description
 */
public class Q856 {

//    856. 括号的分数
//    给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
//
//            () 得 1 分。
//    AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
//            (A) 得 2 * A 分，其中 A 是平衡括号字符串。
//
//
//    示例 1：
//
//    输入： "()"
//    输出： 1
//    示例 2：
//
//    输入： "(())"
//    输出： 2
//    示例 3：
//
//    输入： "()()"
//    输出： 2
//    示例 4：
//
//    输入： "(()(()))"
//    输出： 6
//
//
//    提示：
//
//    S 是平衡括号字符串，且只含有 ( 和 ) 。
//            2 <= S.length <= 50

    public static int scoreOfParentheses(String S) {
        while(S.contains("()")){
            S = S.replace("()","1");
        }

        Stack<String> stack = new Stack<>();
        char[] chars = S.toCharArray();
        for (char ele : chars) {
            if(ele == ')'){
                Integer value = Integer.valueOf(stack.pop());
                stack.pop();
                if(stack.empty() || stack.peek().equals("(")){
                    stack.push(String.valueOf(2 * value));
                }else{
                    Integer oldValue = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(oldValue + 2 * value));
                }
            }else if(ele == '('){
                stack.push("(");
            }else{
                if(stack.empty() || stack.peek().equals("(")){
                    stack.push(String.valueOf(ele));
                }else{
                    Integer value = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(ele - 48 + value));
                }
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("(()(()))"));
    }
}
