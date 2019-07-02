package com.lee.leetcode.Q900;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Pwenlee
 * @date 2019/7/2 16:42
 * @description
 */
public class Q914 {
//    914. 卡牌分组
//    给定一副牌，每张牌上都写着一个整数。
//
//    此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
//
//    每组都有 X 张牌。
//    组内所有的牌上都写着相同的整数。
//    仅当你可选的 X >= 2 时返回 true。
//
//    示例 1：
//
//    输入：[1,2,3,4,4,3,2,1]
//    输出：true
//    解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
//    示例 2：
//
//    输入：[1,1,1,2,2,2,3,3]
//    输出：false
//    解释：没有满足要求的分组。
//    示例 3：
//
//    输入：[1]
//    输出：false
//    解释：没有满足要求的分组。
//    示例 4：
//
//    输入：[1,1]
//    输出：true
//    解释：可行的分组是 [1,1]
//    示例 5：
//
//    输入：[1,1,2,2,2,2]
//    输出：true
//    解释：可行的分组是 [1,1]，[2,2]，[2,2]
//
//    提示：
//
//            1 <= deck.length <= 10000
//            0 <= deck[i] < 10000

    public static boolean hasGroupsSizeX(int[] deck) {
        int length = deck.length;
        if(length < 2){
            return false;
        }
        int[] counts = new int[10001];
        for (int i : deck) {
            counts[i]++;
        }
        for(int i = 2; i <= 5000; i++) {
            boolean flag = true;
            for (int count : counts) {
                if (count != 0) {
                    if(count % i != 0){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasGroupsSizeX(new int[]{1,1,1,2,2,2,3,3}));
    }
}
