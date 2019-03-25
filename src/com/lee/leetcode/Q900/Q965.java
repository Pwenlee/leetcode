package com.lee.leetcode.Q900;

import com.lee.leetcode.Common.TreeNode;

import java.util.Objects;

/**
 * @author Pwenlee
 * @date 2019/3/5 19:56
 * @description
 */
public class Q965 {
//    965. 单值二叉树
//    如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
//
//    只有给定的树是单值二叉树时，才返回 true；否则返回 false。

    public boolean isUnivalTree(TreeNode root) {
        if(Objects.isNull(root)){
            return true;
        }
        boolean result = true;
        if(Objects.nonNull(root.left)){
            result = result && root.val == root.left.val && isUnivalTree(root.left);
        }
        if(Objects.nonNull(root.right)){
            result = result && root.val == root.right.val && isUnivalTree(root.right);
        }
        return result;
    }
}
