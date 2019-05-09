package com.lee.leetcode.Q600;

import com.lee.leetcode.Common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Pwenlee
 * @date 2019/5/9 15:57
 * @description
 */
public class Q637 {
//    637. 二叉树的层平均值
//    给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
//
//            示例 1:
//
//    输入:
//            3
//            / \
//            9  20
//            /  \
//            15   7
//    输出: [3, 14.5, 11]
//    解释:
//    第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
//    注意：
//
//    节点值的范围在32位有符号整数范围内。

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(Objects.nonNull(root)){
            result = getTreeNodeLevelAverageValueList(new ArrayList<>(Arrays.asList(root)));
        }
        return result;
    }

    private static List<Double> getTreeNodeLevelAverageValueList(List<TreeNode> treeNodeList){
        List<Double> list = new ArrayList<>();
        double sum = 0;
        if(Objects.nonNull(treeNodeList) && treeNodeList.size() > 0){
            List<TreeNode> subNodeList = new ArrayList<>();
            for (TreeNode treeNode : treeNodeList) {
                sum = sum + treeNode.val;
                if(Objects.nonNull(treeNode.left)){
                    subNodeList.add(treeNode.left);
                }
                if(Objects.nonNull(treeNode.right)){
                    subNodeList.add(treeNode.right);
                }
            }
            list.add(sum/treeNodeList.size());
            list.addAll(getTreeNodeLevelAverageValueList(subNodeList));
        }
        return list;
    }
}
