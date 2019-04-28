package com.lee.leetcode;

import java.util.List;
import java.util.Objects;

/**
 * @author Pwenlee
 * @date 2019/3/25 15:45
 * @description
 */
public class Common {

    public static class ListNode{

        public int val;

        public ListNode next;

        public ListNode(int x) { val = x; }

        @Override
        public String toString(){
            ListNode node = this;
            StringBuilder s = new StringBuilder();
            while (Objects.nonNull(node)) {
                s.append("->").append(node.val);
                node = node.next;
            }
            return s.substring(2);
        }

    }

    public static class TreeNode {
        public int val;

        public TreeNode left;

        public TreeNode right;

        public TreeNode(int x) { val = x; }

    }

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static ListNode reverse(ListNode l1){
        ListNode node = null;
        if(Objects.nonNull(l1)) {
            node = new ListNode(l1.val);
            l1 = l1.next;
            while (Objects.nonNull(l1)) {
                ListNode newNode = new ListNode(l1.val);
                newNode.next = node;
                node = newNode;
                l1 = l1.next;
            }
        }
        return node;
    }

    public static boolean isPowerOf2(long n){
        return n > 0 && (n & (n-1)) == 0;
    }

    public static int getPowerOf2(long n){
        int x = 0;
        while (n > 1) {
            n >>= 1;
            x++;
        }
        return x;
    }
}
