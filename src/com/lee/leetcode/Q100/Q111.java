package com.lee.leetcode.Q100;

import com.lee.leetcode.Common.TreeNode;

import java.util.Objects;

/**
 * @author Pwenlee
 * @date 2019/4/30 14:44
 * @description
 */
public class Q111 {
//    111. 二叉树的最小深度
//    给定一个二叉树，找出其最小深度。
//
//    最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
//    说明: 叶子节点是指没有子节点的节点。
//
//    示例:
//
//    给定二叉树 [3,9,20,null,null,15,7],
//
//            3
//            / \
//            9  20
//            /  \
//            15   7
//    返回它的最小深度  2.

    public int minDepth(TreeNode root) {
        if(Objects.isNull(root)){
            return 0;
        }else{
            if(Objects.isNull(root.right)){
                return 1 + minDepth(root.left);
            }else if(Objects.isNull(root.left)){
                return 1 + minDepth(root.right);
            }else{
                return 1 + Math.min(minDepth(root.left), minDepth(root.right));
            }
        }
    }
}
