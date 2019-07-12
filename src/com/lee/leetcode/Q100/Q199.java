package com.lee.leetcode.Q100;

import com.lee.leetcode.Common.TreeNode;

import java.util.*;

/**
 * @author Pwenlee
 * @date 2019/7/12 14:32
 * @description
 */
public class Q199 {
//    199. 二叉树的右视图
//    给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
//    示例:
//
//    输入: [1,2,3,null,5,null,4]
//    输出: [1, 3, 4]
//    解释:
//
//            1            <---
//          /   \
//         2     3         <---
//          \     \
//            5    4       <---

    public static List<Integer> rightSideView(TreeNode root) {
        if(Objects.isNull(root)){
            return new ArrayList<>(0);
        }
        List<Integer> result = new LinkedList<>();
        List<TreeNode> treeNodeList = new LinkedList<>(Arrays.asList(root));
        while(!treeNodeList.isEmpty()){
            result.add(treeNodeList.get(0).val);
            List<TreeNode> subTreeNodeList = new LinkedList<>();
            for (TreeNode node : treeNodeList) {
                if(Objects.nonNull(node.right)){
                    subTreeNodeList.add(node.right);
                }
                if(Objects.nonNull(node.left)){
                    subTreeNodeList.add(node.left);
                }
            }
            treeNodeList = subTreeNodeList;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        node2.left = node5;
        node1.left = node2;
        node1.right = node3;
        System.out.println(rightSideView(node1));

    }
}
