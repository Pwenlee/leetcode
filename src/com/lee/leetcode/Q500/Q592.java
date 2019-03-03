package com.lee.leetcode.Q500;

/**
 * @author Administrator
 * @date 2019/3/3 20:00
 * @description
 */
public class Q592 {
//    592. 分数加减运算
//    给定一个表示分数加减运算表达式的字符串，你需要返回一个字符串形式的计算结果。 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
//
//    示例 1:
//
//    输入:"-1/2+1/2"
//    输出: "0/1"
//    示例 2:
//
//    输入:"-1/2+1/2+1/3"
//    输出: "1/3"
//    示例 3:
//
//    输入:"1/3-1/2"
//    输出: "-1/6"
//    示例 4:
//
//    输入:"5/3+1/3"
//    输出: "2/1"
//    说明:
//
//    输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。
//    输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
//    输入只包含合法的最简分数，每个分数的分子与分母的范围是  [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。
//    输入的分数个数范围是 [1,10]。
//    最终结果的分子与分母保证是 32 位整数范围内的有效整数。

    private final static int MAX_DENOMINATOR = 2*3*4*5*7*3;

    public static String fractionAddition(String expression) {
        if(expression.startsWith("-")){
            expression = "0"+expression;
        }
        int sum = 0;
        expression = expression.replaceAll("-", "+-");
        String[] arrays = expression.split("[+]");
        for (String str : arrays) {
            if(!str.equals("0")){
                int value;
                boolean minus = str.startsWith("-");
                str = minus? str.substring(1) : str;
                if(str.contains("/")){
                    String[] ele = str.split("/");
                    value = MAX_DENOMINATOR/Integer.valueOf(ele[1])*Integer.valueOf(ele[0]);
                }else{
                    value = Integer.valueOf(str) * MAX_DENOMINATOR;
                }
                if(minus){
                    sum = sum - value;
                }else{
                    sum = sum + value;
                }
            }
        }
        return simple(sum);
    }

    private static String simple(int value){
        if(value == 0){
            return "0/1";
        }
        boolean ltz = value < 0;
        value = ltz? 0-value : value;
        int denominator = MAX_DENOMINATOR;
        while(true){
            if(denominator % 2 == 0 && value % 2 == 0){
                value = value / 2;
                denominator = denominator / 2;
                continue;
            }
            if(denominator % 3 == 0 && value % 3 == 0){
                value = value / 3;
                denominator = denominator / 3;
                continue;
            }
            if(denominator % 5 == 0 && value % 5 == 0){
                value = value / 5;
                denominator = denominator / 5;
                continue;
            }
            if(denominator % 7 == 0 && value % 7 == 0){
                value = value / 7;
                denominator = denominator / 7;
                continue;
            }
            break;
        }
        String result = "";
        if(denominator == 1){
            result = value+"/1";
        }else{
            result = value+ "/" + denominator;
        }
        return ltz ? "-"+result : result;
    }

    public static void main(String[] args) {
        System.out.println(fractionAddition("5/3+1/3"));
    }
}
