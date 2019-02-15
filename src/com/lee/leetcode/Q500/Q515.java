package com.lee.leetcode.Q500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Pwenlee
 * @date 2019/2/14 15:05
 * @description
 */
public class Q515 {
//515. 在每个树行中找最大值
//    您需要在二叉树的每一行中找到最大的值。
//
//    示例：
//
//    输入:
//
//            1
//            / \
//            3   2
//            / \   \
//            5   3   9
//
//    输出: [1, 3, 9]

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(Objects.isNull(root)){
            return result;
        }
        List<TreeNode> treeNodeList = new ArrayList<>();
        treeNodeList.add(root);
        while(!treeNodeList.isEmpty()){
//            int maxValue = treeNodeList.stream().mapToInt(ele -> ele.val).max().getAsInt();
//            result.add(maxValue);
//            List<TreeNode> subNodeList = new ArrayList<>();
//            subNodeList.addAll(treeNodeList.stream().map(ele -> ele.left).filter(ele->Objects.nonNull(ele)).collect(Collectors.toList()));
//            subNodeList.addAll(treeNodeList.stream().map(ele -> ele.right).filter(ele->Objects.nonNull(ele)).collect(Collectors.toList()));
//            treeNodeList.clear();
//            treeNodeList.addAll(subNodeList);
            //lamda表达式虽然简洁 但是如果运用不当会影响代码执行效率  如上46 49 50行对一个stream进行了三次操作 实际上一个循环就能解决
            List<TreeNode> subNodeList = new ArrayList<>();
            int maxValue = Integer.MIN_VALUE;
            for (TreeNode treeNode : treeNodeList) {
                if(treeNode.val > maxValue){
                    maxValue = treeNode.val;
                }
                if(Objects.nonNull(treeNode.left)){
                    subNodeList.add(treeNode.left);
                }
                if(Objects.nonNull(treeNode.right)){
                    subNodeList.add(treeNode.right);
                }
            }
            result.add(maxValue);
            treeNodeList.clear();
            treeNodeList.addAll(subNodeList);
        }
        return result;
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            List<Integer> ret = new Q515().largestValues(root);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}
