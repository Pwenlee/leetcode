package com.lee.leetcode.Q1500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Pwenlee
 * @date 2020/9/10 10:15
 * @description
 */
public class Q1507 {
//    1507. 转变日期格式
//    给你一个字符串 date ，它的格式为 Day Month Year ，其中：
//
//    Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
//    Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} 中的一个元素。
//    Year 的范围在 ​[1900, 2100] 之间。
//    请你将字符串转变为 YYYY-MM-DD 的格式，其中：
//
//    YYYY 表示 4 位的年份。
//    MM 表示 2 位的月份。
//    DD 表示 2 位的天数。
//             
//    示例 1：
//
//    输入：date = "20th Oct 2052"
//    输出："2052-10-20"
//    示例 2：
//
//    输入：date = "6th Jun 1933"
//    输出："1933-06-06"
//    示例 3：
//
//    输入：date = "26th May 1960"
//    输出："1960-05-26"
//             
//    提示：
//
//    给定日期保证是合法的，所以不需要处理异常输入。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/reformat-date
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    private static final List<String> MONTH = new ArrayList<>(Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));

    public static String reformatDate(String date) {
        String[] dates = date.split(" ");
        String month = String.valueOf(MONTH.indexOf(dates[1]) + 1);
        String day = dates[0].substring(0, dates[0].length() -2);
        month = month.length() == 1 ? "0" + month : month;
        day = day.length() == 1 ? "0" + day : day;
        return dates[2] + "-" + month + "-" + day;
    }


    public static void main(String[] args) {
        System.out.println(reformatDate("24th Oct 1960"));
    }
}
