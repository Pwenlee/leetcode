package com.lee.leetcode.Q;

import com.lee.leetcode.Common.ListNode;
import java.util.Objects;

/**
 * @author Pwenlee
 * @date 2019/4/17 14:43
 * @description
 */
public class Q82 {
//    82. 删除排序链表中的重复元素 II
//    给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
//
//    示例 1:
//
//    输入: 1->2->3->3->4->4->5
//    输出: 1->2->5
//    示例 2:
//
//    输入: 1->1->1->2->3
//    输出: 2->3

    public static ListNode deleteDuplicates(ListNode head) {
        if(Objects.isNull(head)){
            return head;
        }
        Integer duplicate = null;
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode pre = result;
        ListNode next = null;
        while(Objects.nonNull(head)){
            next = head.next;
            if(Objects.nonNull(duplicate) && duplicate.intValue() == head.val){
                 pre.next = next;
                 head = next;
            }else{
                if(Objects.isNull(next)){
                    break;
                }
                if(head.val == next.val){
                    pre.next = next;
                    head = next;
                    duplicate = head.val;
                }else {
                    duplicate = null;
                    pre = head;
                    head = head.next;
                }
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        System.out.println(deleteDuplicates(l1));
    }
}
