package com.lee.leetcode.Q500;

import com.lee.leetcode.Common.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * @author Pwenlee
 * @date 2019/4/30 14:13
 * @description
 */
public class Q538 {

//    538. 把二叉搜索树转换为累加树
//    给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
//
//    例如：
//
//    输入: 二叉搜索树:
//            5
//            /   \
//            2     13
//
//    输出: 转换为累加树:
//            18
//            /   \
//            20     13

    public TreeNode convertBST(TreeNode root) {
        if(Objects.isNull(root)){
            return root;
        }
        List<Integer> list = new ArrayList<>();
        getAllNode(root, list);
        list.sort(Comparator.reverseOrder());
        addValue(root, list);
        return root;
    }

    private void getAllNode(TreeNode root, List<Integer> list){
        if(Objects.nonNull(root)){
            list.add(root.val);
            getAllNode(root.left, list);
            getAllNode(root.right, list);
        }
    }

    private void addValue(TreeNode root, List<Integer> list){
        if(Objects.nonNull(root)){
            int sum = 0;
            int value = root.val;
            for (Integer integer : list) {
               if(integer.intValue() > value){
                   sum = sum + integer.intValue();
               }else {
                   break;
               }
            }
            root.val = sum + root.val;
            addValue(root.left, list);
            addValue(root.right, list);
        }
    }

    /**
     * 二叉搜索树 右子节点>父节点>子节点
     * @param root
     * @return
     */
    private int sum = 0;

    public TreeNode convertBST1(TreeNode root) {
        if(Objects.isNull(root)){
            return root;
        }
        convertBST1(root.right);
        sum = sum + root.val;
        root.val = sum;
        convertBST1(root.left);
        return root;
    }


}
