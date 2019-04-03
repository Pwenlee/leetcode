package com.lee.leetcode.Q;

import java.util.Stack;

/**
 * @author Pwenlee
 * @date 2019/4/3 13:19
 * @description
 */
public class Q20 {
//    20. 有效的括号
//    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//    有效字符串需满足：
//
//    左括号必须用相同类型的右括号闭合。
//    左括号必须以正确的顺序闭合。
//    注意空字符串可被认为是有效字符串。
//
//    示例 1:
//
//    输入: "()"
//    输出: true
//    示例 2:
//
//    输入: "()[]{}"
//    输出: true
//    示例 3:
//
//    输入: "(]"
//    输出: false
//    示例 4:
//
//    输入: "([)]"
//    输出: false
//    示例 5:
//
//    输入: "{[]}"
//    输出: true

    public boolean isValid(String s) {
        if("".equals(s)){
            return true;
        }
        if(s.contains("{}")){
            return isValid(s.replace("{}", ""));
        }
        if(s.contains("()")){
            return isValid(s.replace("()", ""));
        }
        if(s.contains("[]")){
            return isValid(s.replace("[]", ""));
        }
        return false;
    }

    public boolean isValid1(String s) {
        if("".equals(s)){
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if(stack.empty()){
                stack.push(c);
            }else{
                if(c == ')' && stack.peek().charValue() == '('){
                    stack.pop();
                }else if(c == '}' && stack.peek().charValue() == '{'){
                    stack.pop();
                }else if(c == ']' && stack.peek().charValue() == '['){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }
        return stack.empty();
    }
}
