package com.lee.leetcode.Q800;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Q816 {
//    816. 模糊坐标
//    我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表中。
//
//    原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。
//
//    最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。
//
//    示例 1:
//    输入: "(123)"
//    输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
//    示例 2:
//    输入: "(00011)"
//    输出:  ["(0.001, 1)", "(0, 0.011)"]
//    解释:
//            0.0, 00, 0001 或 00.01 是不被允许的。
//    示例 3:
//    输入: "(0123)"
//    输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
//    示例 4:
//    输入: "(100)"
//    输出: [(10, 0)]
//    解释:
//            1.0 是不被允许的。
//             
//    提示:
//
//            4 <= S.length <= 12.
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/ambiguous-coordinates
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public List<String> ambiguousCoordinates(String S) {
        HashSet<String> result = new HashSet<>();
        S = S.substring(1, S.length() -1);
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder(S);
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            left.append(chars[i]);
            right.deleteCharAt(0);

            HashSet<String> leftNumberList = getNumberList(left.toString());
            HashSet<String> rightNumberList = getNumberList(right.toString());
            if(!leftNumberList.isEmpty() && !rightNumberList.isEmpty()){
                for (String leftNumber : leftNumberList) {
                    for (String rightNumber : rightNumberList) {
                        result.add(new StringBuilder("(").append(leftNumber).append(", ").append(rightNumber).append(")").toString());
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    private HashSet<String> getNumberList(String s) {
        HashSet<String> result = new HashSet<>();
        if(checkNumber(s)){
            result.add(s);
        }
        if(s.length() >1){
            char[] chars = s.toCharArray();
            StringBuilder subLeft = new StringBuilder();
            StringBuilder subRight = new StringBuilder(s);
            for (int i = 0; i < chars.length - 1; i++) {
                subLeft.append(chars[i]);
                subRight.deleteCharAt(0);
                String number = new StringBuilder(subLeft).append(".").append(subRight).toString();
                if (checkNumber(number)) {
                    result.add(number);
                }
            }
        }
        return result;
    }

    private boolean checkNumber(String s){
        if(s.contains(".")){
            String integer = s.split("\\.")[0];
            String decimal = s.split("\\.")[1];
            return (integer.equals("0") || !integer.startsWith("0")) && !decimal.endsWith("0");
        }else{
            return s.equals("0") || !s.startsWith("0");
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q816().ambiguousCoordinates("(000001)").stream().collect(Collectors.joining(",","[","]")));
    }
}
