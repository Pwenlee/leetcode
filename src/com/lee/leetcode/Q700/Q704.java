package com.lee.leetcode.Q700;

public class Q704 {
//    704. 二分查找
//    给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
//    示例 1:
//
//    输入: nums = [-1,0,3,5,9,12], target = 9
//    输出: 4
//    解释: 9 出现在 nums 中并且下标为 4
//    示例 2:
//
//    输入: nums = [-1,0,3,5,9,12], target = 2
//    输出: -1
//    解释: 2 不存在 nums 中因此返回 -1
//             
//    提示：
//
//    你可以假设 nums 中的所有元素是不重复的。
//    n 将在 [1, 10000]之间。
//    nums 的每个元素都将在 [-9999, 9999]之间。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/binary-search
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(end - start > 1){
            if(nums[start] == target){
                return start;
            }else if(nums[end] == target){
                return end;
            }else{
                int value = (end + start) / 2;
                if (nums[value] > target) {
                    end = value;
                } else if (nums[value] < target) {
                    start = value;
                } else {
                    return value;
                }
            }
        }
        if(nums[start] == target){
            return start;
        }else if(nums[end] == target){
            return end;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        String a = "123"; String b = "123"; String c = new String("123");System.out.println(a==b);System.out.println(a==c);
        //System.out.println(new Q704().search(new int[]{-1,0,3,5,9,12}, 2));
    }
}
