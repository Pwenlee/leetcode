package com.lee.leetcode;

import com.lee.leetcode.Q900.Q965;

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
}
