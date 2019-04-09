package com.lee.leetcode.Q500;

import com.lee.leetcode.Common.Node;

import java.util.List;

/**
 * @author Pwenlee
 * @date 2019/4/9 15:24
 * @description
 */
public class Q559 {
//    559. N叉树的最大深度
//    给定一个 N 叉树，找到其最大深度。
//
//    最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
//
//    例如，给定一个 3叉树 :
//
//    我们应返回其最大深度，3。
//
//    说明:
//
//    树的深度不会超过 1000。
//    树的节点总不会超过 5000。

    public int maxDepth(Node root) {
        if(null == root){
            return 0;
        }
        List<Node> children = root.children;
        if(null == children || children.size() == 0){
            return 1;
        }else{
            int depth = 0;
            for (Node child : children) {
                depth = Math.max(depth, maxDepth(child));
            }
            return depth + 1;
        }
    }
}
