package com.lee.leetcode.Q1100;

import com.lee.leetcode.Common.TreeNode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Pwenlee
 * @date 2020-04-18 14:37
 * @description
 */
public class Q1161 {
//    1161. 最大层内元素和
//
//    给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
//
//    请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
//
//    示例：
//
//    输入：[1,7,0,7,-8,null,null]
//    输出：2
//    解释：
//    第 1 层各元素之和为 1，
//    第 2 层各元素之和为 7 + 0 = 7，
//    第 3 层各元素之和为 7 + -8 = -1，
//    所以我们返回第 2 层的层号，它的层内元素之和最大。
//
//
//    提示：
//
//    树中的节点数介于 1 和 10^4 之间
//    -10^5 <= node.val <= 10^5
//    通过次数4,444提交次数6,616

    public int maxLevelSum(TreeNode root) {
        int result = 1;
        int level = 1;
        long max = root.val;
        List<TreeNode> nodeList = new ArrayList<>(Collections.singletonList(root));
        while(nodeList.size() > 0){
            long sum = 0L;
            List<TreeNode> childrenNodeList = new ArrayList<>();
            for (TreeNode node : nodeList) {
                sum = sum + node.val;
                if(Objects.nonNull(node.left)){
                    childrenNodeList.add(node.left);
                }
                if(Objects.nonNull(node.right)){
                    childrenNodeList.add(node.right);
                }
            }
            if(sum > max){
                result = level;
                max = sum;
            }
            level++;
            nodeList = childrenNodeList;
        }
        return result;
    }
}
