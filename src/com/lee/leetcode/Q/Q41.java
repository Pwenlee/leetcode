package com.lee.leetcode.Q;

/**
 * @author Pwenlee
 * @date 2019/5/13 16:10
 * @description
 */
public class Q41 {
//    41. 缺失的第一个正数
//    给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
//
//    示例 1:
//
//    输入: [1,2,0]
//    输出: 3
//    示例 2:
//
//    输入: [3,4,-1,1]
//    输出: 2
//    示例 3:
//
//    输入: [7,8,9,11,12]
//    输出: 1
//    说明:
//
//    你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。

    public static int firstMissingPositive(int[] nums) {
        //获取数组的长度
        int length = nums.length;
        //建立位图 如果数组的长度是n 那么假设1~n中有数没存在 如果1~n中的数都存在 则返回n+1
        byte[] array = new byte[length];
        for (int num : nums) {
            //遍历每个数  如果当然的数到1~n中 则将这个位置的值置为1
            if(num < length && num > 0) {
                array[num-1] = 1;
            }
        }
        //遍历位图  如果某个位置的值为0则返回i+1
        for (int i = 0; i < array.length; i++) {
            if(array[i] == 0){
                return i+1;
            }
        }
        return length+1;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(firstMissingPositive(new int[]{1}));
        System.out.println(System.currentTimeMillis() - start);
    }
}
