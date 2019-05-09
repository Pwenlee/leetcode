package com.lee.leetcode.Q100;

import com.lee.leetcode.Common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Pwenlee
 * @date 2019/5/9 14:26
 * @description
 */
public class Q107 {
//    107. 二叉树的层次遍历 II
//    给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
//    例如：
//    给定二叉树 [3,9,20,null,null,15,7],
//
//             3
//            / \
//           9   20
//              /  \
//             15   7
//    返回其自底向上的层次遍历为：
//
//            [
//            [15,7],
//            [9,20],
//            [3]
//            ]

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(Objects.nonNull(root)) {
            List<List<Integer>> sub = new ArrayList<>();
            List<List<Integer>> leftSub = new ArrayList<>();
            if(Objects.nonNull(root.left)){
                leftSub = levelOrderBottom(root.left);
            }
            List<List<Integer>> rightSub = new ArrayList<>();
            if(Objects.nonNull(root.right)){
                rightSub = levelOrderBottom(root.right);
            }
            for(int i = Math.max(leftSub.size(), rightSub.size()); i>0; i--){
                if(i > leftSub.size()){
                    sub.add(rightSub.get(rightSub.size() - i));
                }else if(i > rightSub.size()){
                    sub.add(leftSub.get(leftSub.size() - i));
                }else{
                    List<Integer> temp = new ArrayList<>();
                    temp.addAll(leftSub.get(leftSub.size() - i));
                    temp.addAll(rightSub.get(rightSub.size() - i));
                    sub.add(temp);
                }
            }
            list.addAll(sub);
            List<Integer> rootList = new ArrayList<>(1);
            rootList.add(root.val);
            list.add(rootList);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node3.right = node5;
        node3.left = node4;
        node1.left = node2;
        node1.right = node3;
        System.out.println(levelOrderBottom(node1));
    }
}
