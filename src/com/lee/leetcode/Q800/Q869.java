package com.lee.leetcode.Q800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Pwenlee
 * @date 2019/3/18 16:16
 * @description
 */
public class Q869 {

//    869. 重新排序得到 2 的幂
//    从正整数 N 开始，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
//
//    如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
//
//    示例 1：
//
//    输入：1
//    输出：true
//    示例 2：
//
//    输入：10
//    输出：false
//    示例 3：
//
//    输入：16
//    输出：true
//    示例 4：
//
//    输入：24
//    输出：false
//    示例 5：
//
//    输入：46
//    输出：true
//
//    提示：
//
//            1 <= N <= 10^9

    private static List<String> list = new ArrayList<>();

    static {
        list.add("1");
        int n = 1;
        while(n <= Math.pow(10, 9)){
            n = n * 2;
            char[] chars = String.valueOf(n).toCharArray();
            Arrays.sort(chars);
            list.add(new String(chars));
        }
    }

    public boolean reorderedPowerOf2(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        Arrays.sort(chars);
        return list.contains(new String(chars));
    }



    public static void main(String[] args) {

    }
}
