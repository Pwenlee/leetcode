package com.lee.leetcode;

/**
 * @author lipan
 * @date 2019/2/12 14:43
 * @description
 */
public class Q606 {
//    606. 根据二叉树创建字符串
//    你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
//
//    空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
//
//    示例 1:
//
//    输入: 二叉树: [1,2,3,4]
//            1
//            /   \
//            2     3
//            /
//            4
//
//    输出: "1(2(4))(3)"
//
//    解释: 原本将是“1(2(4)())(3())”，
//    在你省略所有不必要的空括号对之后，
//    它将是“1(2(4))(3)”。
//    示例 2:
//
//    输入: 二叉树: [1,2,3,null,4]
//            1
//            /   \
//            2     3
//            \
//            4
//
//    输出: "1(2()(4))(3)"
//
//    解释: 和第一个示例相似，
//    除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public String tree2str(TreeNode t){
        if(null == t){
            return "";
        }
        if(null == t.left && null == t.right){
            return String.valueOf(t.val);
        }
        if(null == t.right){
            return t.val + "(" + tree2str(t.left) + ")";
        }else {
            return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
