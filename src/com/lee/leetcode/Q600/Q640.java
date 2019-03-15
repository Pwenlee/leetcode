package com.lee.leetcode.Q600;

/**
 * @author Pwenlee
 * @date 2019/3/14 17:04
 * @description
 */
public class Q640 {

//    640. 求解方程
//    求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。
//
//    如果方程没有解，请返回“No solution”。
//
//    如果方程有无限解，则返回“Infinite solutions”。
//
//    如果方程中只有一个解，要保证返回值 x 是一个整数。
//
//    示例 1：
//
//    输入: "x+5-3+x=6+x-2"
//    输出: "x=2"
//    示例 2:
//
//    输入: "x=x"
//    输出: "Infinite solutions"
//    示例 3:
//
//    输入: "2x=x"
//    输出: "x=0"
//    示例 4:
//
//    输入: "2x+3x-6x=x+2"
//    输出: "x=-1"
//    示例 5:
//
//    输入: "x=x+2"
//    输出: "No solution"
    public static String solveEquation(String equation) {
        String[] array = equation.split("=");
        int[] left = simple(array[0]);
        int[] right = simple(array[1]);
        int xCount = left[0] - right[0];
        int otherValue = right[1] - left[1];
        if(xCount != 0){
            if(otherValue % xCount == 0){
                return "x="+(otherValue / xCount);
            }else{
                return "No solution";
            }
        }else{
            if(otherValue == 0){
                return "Infinite solutions";
            }else{
                return "No solution";
            }
        }
    }

    private static int[] simple(String s){
        int[] count = new int[2];
        char[] chars = s.toCharArray();
        StringBuilder value = new StringBuilder();
        char operator = '+';
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] != '+' && chars[i] != '-'){
                value.append(chars[i]);
                if(i == chars.length-1) {
                    count = calculate(count, operator, value);
                }
            }else{
                count = calculate(count, operator, value);
                operator = chars[i];
                value = new StringBuilder();
            }
        }
        return count;
    }

    private static int[] calculate(int[] count, char operator, StringBuilder value){
        if(operator == '+'){
            if(value.length() > 0) {
                if (value.indexOf("x") == 0) {
                    count[0] = count[0] + 1;
                } else if (value.indexOf("x") < 0) {
                    count[1] = count[1] + Integer.valueOf(value.toString());
                } else {
                    count[0] = count[0] + Integer.valueOf(value.toString().substring(0, value.length() - 1));
                }
            }
        }else if(operator == '-'){
            if(value.length() > 0) {
                if (value.indexOf("x") == 0) {
                    count[0] = count[0] - 1;
                } else if (value.indexOf("x") < 0) {
                    count[1] = count[1] - Integer.valueOf(value.toString());
                } else {
                    count[0] = count[0] - Integer.valueOf(value.toString().substring(0, value.length() - 1));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solveEquation("2x+3x-6x=x+2"));
    }
}
