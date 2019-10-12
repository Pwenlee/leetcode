package com.lee.leetcode.Q1100;

import java.util.Arrays;

public class Q1189 {

//    1189. “气球” 的最大数量
//    给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
//
//    字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
//
//    示例 1：
//
//    输入：text = "nlaebolko"
//    输出：1
//    示例 2：
//
//    输入：text = "loonbalxballpoon"
//    输出：2
//    示例 3：
//
//    输入：text = "leetcode"
//    输出：0
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/maximum-number-of-balloons
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int maxNumberOfBalloons(String text) {
        int[] count = new int[5];
        char[] chars = text.toCharArray();
        for (char c : chars) {
            switch (c){
                case 'b':
                    count[0]++;
                    break;
                case 'a':
                    count[1]++;
                    break;
                case 'l':
                    count[2]++;
                    break;
                case 'o':
                    count[3]++;
                    break;
                case 'n':
                    count[4]++;
                    break;
                default:
                    break;
            }
        }
        count[2] = count[2] / 2;
        count[3] = count[3] / 2;
        return Arrays.stream(count).min().getAsInt();
    }
}
