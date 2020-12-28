package com.lee.leetcode.Q1500;

/**
 * @author Pwenlee
 * @date 2020/12/28 16:16
 * @description
 */
public class Q1513 {
//    1513. 仅含 1 的子串数
//    给你一个二进制字符串 s（仅由 '0' 和 '1' 组成的字符串）。
//
//    返回所有字符都为 1 的子字符串的数目。
//
//    由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
//
//    示例 1：
//
//    输入：s = "0110111"
//    输出：9
//    解释：共有 9 个子字符串仅由 '1' 组成
//    "1" -> 5 次
//    "11" -> 3 次
//    "111" -> 1 次
//    示例 2：
//
//    输入：s = "101"
//    输出：2
//    解释：子字符串 "1" 在 s 中共出现 2 次
//    示例 3：
//
//    输入：s = "111111"
//    输出：21
//    解释：每个子字符串都仅由 '1' 组成
//    示例 4：
//
//    输入：s = "000"
//    输出：0
//             
//    提示：
//
//    s[i] == '0' 或 s[i] == '1'
//            1 <= s.length <= 10^5
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/number-of-substrings-with-only-1s
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int numSub(String s) {
        long result = 0;
        int n = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                result += sum(n);
                n = 0;
            } else {
                n++;
            }
        }
        result += sum(n);
        return (int)(result % ((int)(Math.pow(10, 9)) + 7));
    }

    private static long sum(int n) {
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += i + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numSub("1111110011"));
    }
}
