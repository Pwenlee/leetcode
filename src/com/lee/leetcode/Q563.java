package com.lee.leetcode;

/**
 * @author Pwenlee
 * @date 2019/1/28 15:44
 * @description
 */
public class Q563 {
//    563. 二叉树的坡度
//    给定一个二叉树，计算整个树的坡度。
//
//    一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
//
//    整个树的坡度就是其所有节点的坡度之和。
//
//    示例:
//
//    输入:
//            1
//            /   \
//            2     3
//    输出: 1
//    解释:
//    结点的坡度 2 : 0
//    结点的坡度 3 : 0
//    结点的坡度 1 : |2-3| = 1
//    树的坡度 : 0 + 0 + 1 = 1
//    注意:
//
//    任何子树的结点的和不会超过32位整数的范围。
//    坡度的值不会超过32位整数的范围。

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public int findTilt(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.abs(getSum(root.left) - getSum(root.right)) + findTilt(root.left) + findTilt(root.right);
    }

    private int getSum(TreeNode node){
        if(node == null){
            return 0;
        }
        int sum = node.val;
        if(node.left != null){
            sum += getSum(node.left);
        }
        if(node.right != null){
            sum += getSum(node.right);
        }
        return sum;
    }
}
