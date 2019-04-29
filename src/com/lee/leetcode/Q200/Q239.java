package com.lee.leetcode.Q200;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Pwenlee
 * @date 2019/4/29 09:37
 * @description
 */
public class Q239 {
//    239. 滑动窗口最大值
//    给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
//
//    返回滑动窗口最大值。
//
//    示例:
//
//    输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//    输出: [3,3,5,5,6,7]
//    解释:
//
//    滑动窗口的位置                最大值
//---------------               -----
//        [1  3  -1] -3  5  3  6  7       3
//        1 [3  -1  -3] 5  3  6  7       3
//        1  3 [-1  -3  5] 3  6  7       5
//        1  3  -1 [-3  5  3] 6  7       5
//        1  3  -1  -3 [5  3  6] 7       6
//        1  3  -1  -3  5 [3  6  7]      7
//    注意：
//
//    你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。
//
//    进阶：
//
//    你能在线性时间复杂度内解决此题吗？

    /** 尽量保证不循环修改数组才能有最大效率*/

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length <= 1){
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        int[] sub = new int[k];
        System.arraycopy(nums, 0, sub, 0, k);
        result[0] = Arrays.stream(sub).max().getAsInt();
        for (int i = 1; i + k <= nums.length; i++) {
            int[] newSub = new int[k];
            System.arraycopy(sub, 1, newSub, 0, k-1);
            newSub[k-1] = nums[i+k-1];
            sub = newSub;
            if(result[i-1] == nums[i-1]){
                result[i] = Arrays.stream(sub).max().getAsInt();
            }else{
                result[i] = Math.max(result[i-1], sub[k-1]);
            }
        }
        return result;
    }

    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums.length <= 1 || k == 1){
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        result[0] = Integer.MIN_VALUE;
        for(int i = 0; i < k; i++){
            result[0] = Math.max(result[0], nums[i]);
        }
        int max = result[0];
        for (int i = 1; i + k <= nums.length; i++) {
            if(nums[i+k-1] > result[i-1]){
                max = nums[i+k-1];
            }else if(nums[i-1] == max){
                max = nums[i];
                for(int j=i; j<i+k;j++){
                    max = Math.max(max, nums[j]);
                }
            }
            result[i] = max;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,2,4};
        System.out.println(Arrays.toString(maxSlidingWindow1(nums, 2)));
    }
}
