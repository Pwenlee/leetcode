package com.lee.leetcode.Q500;

public class Q551 {
//    551. 学生出勤记录 I
//    给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
//
//            'A' : Absent，缺勤
//            'L' : Late，迟到
//            'P' : Present，到场
//    如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
//
//    你需要根据这个学生的出勤记录判断他是否会被奖赏。
//
//    示例 1:
//
//    输入: "PPALLP"
//    输出: True
//    示例 2:
//
//    输入: "PPALLL"
//    输出: False
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/student-attendance-record-i
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public boolean checkRecord(String s) {
        return !s.contains("LLL") && s.indexOf("A") == s.lastIndexOf("A");
    }
}
