package com.lee.leetcode;

import java.util.Arrays;

/**
 * @author lipan
 * @date 2019/1/28 15:44
 * @description
 */
public class Q654 {
//    654. 最大二叉树
//    给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
//
//    1.二叉树的根是数组中的最大元素。
//    2.左子树是通过数组中最大值左边部分构造出的最大二叉树。
//    3.右子树是通过数组中最大值右边部分构造出的最大二叉树。
//    通过给定的数组构建最大二叉树，并且输出这个树的根节点。
//
//    Example 1:
//
//    输入: [3,2,1,6,0,5]
//    输入: 返回下面这棵树的根节点：
//
//            6
//            /   \
//            3     5
//            \    /
//            2  0
//            \
//            1
//    注意:
//
//    给定的数组的大小在 [1, 1000] 之间。

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(null != nums && nums.length != 0){
            int maxValueIndex = maxValueIndex(nums);
            TreeNode node  = new TreeNode(nums[maxValueIndex]);
            int leftLength = maxValueIndex - 0;
            leftLength = leftLength > 0 ? leftLength : 0;
            int rightLength = nums.length - maxValueIndex - 1;
            rightLength = rightLength > 0 ? rightLength : 0;
            int[] leftSubNums = new int[leftLength];
            int[] rightSubNums = new int[rightLength];
            if(leftLength > 0){
                leftSubNums = Arrays.copyOf(nums, leftLength);
            }
            if(rightLength > 0){
                rightSubNums = Arrays.copyOfRange(nums, maxValueIndex + 1, nums.length);
            }
            node.left = constructMaximumBinaryTree(leftSubNums);
            node.right = constructMaximumBinaryTree(rightSubNums);
            return node;
        }else{
            return null;
        }
    }

    private int maxValueIndex(int[] nums) {
        int index = 0;
        int maxValue = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > maxValue){
                index = i;
                maxValue = nums[i];
            }
        }
        return index;
    }
}
