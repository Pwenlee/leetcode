package com.lee.leetcode.Q500;

/**
 * @author Pwenlee
 * @date 2019/3/7 14:32
 * @description
 */
public class Q540 {
//    540. 有序数组中的单一元素
//    给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
//
//    示例 1:
//
//    输入: [1,1,2,3,3,4,4,8,8]
//    输出: 2
//    示例 2:
//
//    输入: [3,3,7,7,10,11,11]
//    输出: 10
//    注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。

    public static int singleNonDuplicate(int[] nums) {
        if(null==nums || nums.length % 2 == 0){
            return 0;
        }  // 11  0   10
        int start = 0;
        int end = nums.length-1;
        while(true){
            int mid = (end + start)/2;
            if(nums[mid] == nums[mid+1]){
                int rightCount = end - (mid + 1);
                int leftCount = mid - start;
                if(rightCount == 1){
                    return nums[end];
                }
                if(leftCount == 1){
                    return nums[start];
                }
                if(rightCount % 2 == 0){
                    end = mid - 1;
                }else{
                    start = (mid + 1) + 1;
                }
            }else if(nums[mid-1] == nums[mid]){
                int rightCount = end - mid;
                int leftCount = (mid-1) - start;
                if(rightCount == 1){
                    return nums[end];
                }
                if(leftCount == 1){
                    return nums[start];
                }
                if(leftCount % 2 == 0){
                    start = mid + 1;
                }else{
                    end = (mid - 1)-1;
                }
            }else{
                return nums[mid];
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(singleNonDuplicate(new int[]{1,1,3,3,4,4,6,6,5}));
    }
}
