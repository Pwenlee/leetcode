package com.lee.leetcode.Q100;

import com.lee.leetcode.Common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Pwenlee
 * @date 2019/4/9 15:37
 * @description
 */
public class Q113 {
//    给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
//
//    说明: 叶子节点是指没有子节点的节点。
//
//    示例:
//    给定如下二叉树，以及目标和 sum = 22，
//
//            5
//            / \
//            4   8
//            /   / \
//            11  13  4
//            /  \    / \
//            7    2  5   1
//    返回:
//
//            [
//            [5,4,11,2],
//            [5,8,4,5]
//            ]

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(null == root){
            return result;
        }else {
            List<Integer> ele = new ArrayList<>(1);
            ele.add(root.val);
            viewTree(result, root, ele);
            return result.stream().filter(e -> e.stream().mapToInt(Integer::intValue).sum() == sum).collect(Collectors.toList());
        }
    }

    private static void viewTree(List<List<Integer>> result, TreeNode treeNode, List<Integer> list){
        if(Objects.isNull(treeNode.left) && Objects.isNull(treeNode.right)){
            result.add(list);
        }else{
            if(Objects.nonNull(treeNode.left)){
                List<Integer> newList = new ArrayList<>();
                newList.addAll(list);
                newList.add(treeNode.left.val);
                viewTree(result, treeNode.left, newList);
            }
            if(Objects.nonNull(treeNode.right)){
                List<Integer> newList = new ArrayList<>();
                newList.addAll(list);
                newList.add(treeNode.right.val);
                viewTree(result, treeNode.right, newList);
            }
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
        System.out.println(pathSum(node4, 4));
    }
}
