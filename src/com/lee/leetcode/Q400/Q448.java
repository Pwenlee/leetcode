package com.lee.leetcode.Q400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pwenlee
 * @date 2020/9/28 10:05
 * @description
 */
public class Q448 {
//    448. 找到所有数组中消失的数字
//    给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
//
//    找到所有在 [1, n] 范围之间没有出现在数组中的数字。
//
//    您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
//
//    示例:
//
//    输入:
//            [4,3,2,7,8,2,3,1]
//
//    输出:
//            [5,6]
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] result = new int[nums.length];
        for (int num : nums) {
            result[num - 1] = 1;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{1,2,3}));
    }
}
