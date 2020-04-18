package com.lee.leetcode.Q1200;

import java.util.*;

/**
 * @author Pwenlee
 * @date 2020-04-18 15:02
 * @description
 */
public class Q1296 {
//    1296. 划分数组为连续数字的集合
//    给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
//    如果可以，请返回 True；否则，返回 False。
//
//    示例 1：
//
//    输入：nums = [1,2,3,3,4,4,5,6], k = 4
//    输出：true
//    解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
//    示例 2：
//
//    输入：nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
//    输出：true
//    解释：数组可以分成 [1,2,3] , [2,3,4] , [3,4,5] 和 [9,10,11]。
//    示例 3：
//
//    输入：nums = [3,3,2,2,1,1], k = 3
//    输出：true
//    示例 4：
//
//    输入：nums = [1,2,3,4], k = 3
//    输出：false
//    解释：数组不能分成几个大小为 3 的子数组。
//             
//    提示：
//
//            1 <= nums.length <= 10^5
//            1 <= nums[i] <= 10^9
//            1 <= k <= nums.length
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public boolean isPossibleDivide(int[] nums, int k) {
        int length = nums.length;
        if (length % k != 0) {
            return false;
        }

        int min = 1000000000;
        int max = 1;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] arr = new int[max - min + 2];
        for (int num : nums) {
            arr[num - min + 1]++;
        }
        int startIndex = 1;
        int endIndex = max - min + 1;
        while (startIndex < endIndex) {
            if (arr[startIndex] == 0) {
                startIndex++;
            } else {
                for (int i = startIndex; i < startIndex + k; i++) {
                    if (arr[i] == 0) {
                        return false;
                    }
                    arr[i]--;
                }
            }
        }
        return true;
    }

    public boolean isPossibleDivide1(int[] nums, int k) {
        int length = nums.length;
        if (length % k != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.naturalOrder());
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while(!map.isEmpty()) {
            Integer key = map.firstKey();
            for (int i = key; i < key + k; i++) {
                Integer value = map.get(i);
                if (Objects.isNull(value)) {
                    return false;
                } else {
                    if (value == 0) {
                        return false;
                    } else if (value == 1) {
                        map.remove(i);
                    } else {
                        map.put(i, value - 1);
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Q1296().isPossibleDivide1(new int[]{1, 2, 3, 4, 5001, 5002, 5003, 5004, 200, 201, 202, 203}, 4));
    }
}
