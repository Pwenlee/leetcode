package com.lee.leetcode.Q400;

import com.lee.leetcode.Common.TreeNode;

import java.util.Objects;

/**
 * @author Pwenlee
 * @date 2019/5/9 14:17
 * @description
 */
public class Q404 {
//    404. 左叶子之和
//    计算给定二叉树的所有左叶子之和。
//
//    示例：
//
//            3
//            / \
//            9  20
//            /  \
//            15   7
//
//    在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if(Objects.nonNull(root)){
            TreeNode left = root.left;
            if(Objects.nonNull(left) && Objects.isNull(left.left) && Objects.isNull(left.right)){
                sum = sum + left.val;
            }
            sum = sum + sumOfLeftLeaves(left) + sumOfLeftLeaves(root.right);
        }
        return sum;
    }
}
