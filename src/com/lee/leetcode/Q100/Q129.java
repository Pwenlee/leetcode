package com.lee.leetcode.Q100;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Pwenlee
 * @date 2019/3/12 20:38
 * @description
 */
public class Q129 {
//    129. 求根到叶子节点数字之和
//    给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
//
//    例如，从根到叶子节点路径 1->2->3 代表数字 123。
//
//    计算从根到叶子节点生成的所有数字之和。
//
//    说明: 叶子节点是指没有子节点的节点。
//
//    示例 1:
//
//    输入: [1,2,3]
//            1
//            / \
//            2   3
//    输出: 25
//    解释:
//    从根到叶子节点路径 1->2 代表数字 12.
//    从根到叶子节点路径 1->3 代表数字 13.
//    因此，数字总和 = 12 + 13 = 25.
//    示例 2:
//
//    输入: [4,9,0,5,1]
//            4
//            / \
//            9   0
//            / \
//            5   1
//    输出: 1026
//    解释:
//    从根到叶子节点路径 4->9->5 代表数字 495.
//    从根到叶子节点路径 4->9->1 代表数字 491.
//    从根到叶子节点路径 4->0 代表数字 40.
//    因此，数字总和 = 495 + 491 + 40 = 1026.

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int sumNumbers(TreeNode root) {
        if(Objects.isNull(root)){
            return 0;
        }
        List<String> list = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        viewTree(root,list,s);
        return list.stream().map(Integer::valueOf).collect(Collectors.summingInt(Integer::intValue));
    }

    private static void viewTree(TreeNode node, List<String> list, StringBuilder stringBuilder){
        stringBuilder.append(node.val);
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        if(Objects.nonNull(node.left)){
            viewTree(node.left, list, stringBuilder);
        }
        if(Objects.nonNull(node.right)){
            stringBuilder = stringBuilder1;
            viewTree(node.right, list, stringBuilder);
        }
        if(Objects.isNull(node.left) && Objects.isNull(node.right)){
            list.add(stringBuilder.toString());
        }
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node9 = new TreeNode(9);
        TreeNode node0 = new TreeNode(0);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        node9.left = node5;
        node9.right = node1;
        node4.left = node9;
        node4.right = node0;
        System.out.println(sumNumbers(node4));
    }
}