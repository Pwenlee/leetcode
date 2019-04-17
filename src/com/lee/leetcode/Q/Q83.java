package com.lee.leetcode.Q;

import com.lee.leetcode.Common.ListNode;
import java.util.Objects;

/**
 * @author Pwenlee
 * @date 2019/4/17 15:23
 * @description
 */
public class Q83 {
//    83. 删除排序链表中的重复元素
//    给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//
//    示例 1:
//
//    输入: 1->1->2
//    输出: 1->2
//    示例 2:
//
//    输入: 1->1->2->3->3
//    输出: 1->2->3

    public ListNode deleteDuplicates(ListNode head) {
        if(Objects.isNull(head)){
            return head;
        }
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode pre = result;
        ListNode next = null;
        while(Objects.nonNull(head)){
            next = head.next;
            if(Objects.isNull(next)){
                break;
            }
            if(head.val == next.val){
                pre.next = next;
                head = next;
            }else {
                pre = head;
                head = head.next;
            }
        }
        return result.next;
    }
}
