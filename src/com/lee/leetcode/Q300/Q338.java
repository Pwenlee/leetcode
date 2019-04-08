package com.lee.leetcode.Q300;

import static com.lee.leetcode.Common.isPowerOf2;

import java.util.Arrays;

/**
 * @author Pwenlee
 * @date 2019/4/8 15:33
 * @description
 */
public class Q338 {
//    338. 比特位计数
//    给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
//
//    示例 1:
//
//    输入: 2
//    输出: [0,1,1]
//    示例 2:
//
//    输入: 5
//    输出: [0,1,1,2,1,2]
//    进阶:
//
//    给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
//    要求算法的空间复杂度为O(n)。
//    你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。

    public static int[] countBits(int num) {
        if (num == 0) {
            return new int[]{0};
        } else if (num == 1) {
            return new int[]{0, 1};
        } else if (num == 2) {
            return new int[]{0, 1, 1};
        } else {
            int[] result = new int[num + 1];
            result[0] = 0;
            result[1] = 1;
            result[2] = 1;
            int powerOf2Value = 2;
            for (int i = 3; i <= num; i++) {
                if (isPowerOf2(i)) {
                    powerOf2Value = i;
                    result[i] = 1;
                } else {
                    result[i] = 1 + result[i - powerOf2Value];
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(8)));
    }
}
