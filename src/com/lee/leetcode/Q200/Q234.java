package com.lee.leetcode.Q200;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Pwenlee
 * @date 2019/3/11 20:39
 * @description
 */
public class Q234 {
//    234. 回文链表
//    请判断一个链表是否为回文链表。
//
//    示例 1:
//
//    输入: 1->2
//    输出: false
//    示例 2:
//
//    输入: 1->2->2->1
//    输出: true
//    进阶：
//    你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(Objects.nonNull(head)){
            list.add(head.val);
            head = head.next;
        }
        return isPalindrome(list);
    }

    private boolean isPalindrome(List<Integer> list){
        if(list.size() == 1){
            return true;
        }
        for (int i = 0; i < list.size()/2; i++) {
            if(list.get(i).intValue() != list.get(list.size()-1-i).intValue()){
                return false;
            }
        }
        return true;
    }
}
