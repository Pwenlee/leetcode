package com.lee.leetcode.Q200;

import com.lee.leetcode.Common.ListNode;

/**
 * @author Pwenlee
 * @date 2019/6/28 15:05
 * @description
 */
public class Q203 {
//    203. 移除链表元素
//    删除链表中等于给定值 val 的所有节点。
//
//    示例:
//
//    输入: 1->2->6->3->4->5->6, val = 6
//    输出: 1->2->3->4->5

    public static ListNode removeElements(ListNode head, int val) {
        if(null == head){
            return head;
        }else{
            if(head.val == val){
                return removeElements(head.next, val);
            }else{
                ListNode preNode = head;
                ListNode currNode = head.next;
                while(null != currNode){
                    if(currNode.val == val){
                        preNode.next = currNode.next;
                    }else{
                        preNode = currNode;
                    }
                    currNode = currNode.next;
                }
                return head;
            }
        }
    }

    public static void main(String[] args) {
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(6);
        ListNode node1 = new ListNode(2);
        ListNode node0 = new ListNode(1);
        node5.next = node6;
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        node0.next = node1;
        System.out.println(removeElements(node0, 6));
    }
}
