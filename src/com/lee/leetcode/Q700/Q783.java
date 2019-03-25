package com.lee.leetcode.Q700;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import com.lee.leetcode.Common.TreeNode;

/**
 * @author Pwenlee
 * @date 2019/3/6 16:24
 * @description
 */
public class Q783 {
//    783. 二叉搜索树结点最小距离
//    给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
//
//    示例：
//
//    输入: root = [4,2,6,1,3,null,null]
//    输出: 1
//    解释:
//    注意，root是树结点对象(TreeNode object)，而不是数组。
//
//    给定的树 [4,2,6,1,3,null,null] 可表示为下图:
//
//            4
//            /   \
//            2      6
//            / \
//            1   3
//
//    最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
//    注意：
//
//    二叉树的大小范围在 2 到 100。
//    二叉树总是有效的，每个节点的值都是整数，且不重复。

    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        addValue(list, root);
        list = list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        int result = list.get(1) - list.get(0);
        for (int i = 1; i < list.size()-1; i++) {
            result = Math.min(result, list.get(i+1) - list.get(i));
        }
        return result;
    }

    private void addValue(List<Integer> list, TreeNode node){
        if(Objects.nonNull(node)){
            list.add(node.val);
            addValue(list, node.left);
            addValue(list, node.right);
        }
    }

    public static void main(String[] args) {

    }
}
