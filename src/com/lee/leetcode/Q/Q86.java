package com.lee.leetcode.Q;

import com.lee.leetcode.Common.ListNode;

import java.util.Objects;

/**
 * @author Pwenlee
 * @date 2019/5/9 09:36
 * @description
 */
public class Q86 {
//    86. 分隔链表
//    给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
//
//    你应当保留两个分区中每个节点的初始相对位置。
//
//    示例:
//
//    输入: head = 1->4->3->2->5->2, x = 3
//    输出: 1->2->2->4->3->5

    public static ListNode partition(ListNode head, int x) {
        ListNode front = new ListNode(0);
        ListNode head1 = front;
        ListNode behind = new ListNode(0);
        ListNode head2 = behind;
        while(Objects.nonNull(head)){
            if(head.val >= x){
                head2.next = new ListNode(head.val);
                head2 = head2.next;
            }else{
                head1.next = new ListNode(head.val);
                head1 = head1.next;
            }
            head = head.next;
        }
        head1.next = behind.next;
        return front.next;
    }

    public static void main(String[] args) {
        //1->4->3->2->5->2
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        partition(listNode1,3);
    }
}
