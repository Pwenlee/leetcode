package com.lee.leetcode;

/**
 * @author Pwenlee
 * @date 2019/2/12 14:43
 * @description
 */
public class Q2 {
//    2. 两数相加
//    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//    示例：
//
//    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//    输出：7 -> 0 -> 8
//    原因：342 + 465 = 807

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flow = 0;
        ListNode result1 = new ListNode(0);
        ListNode result2 = result1;
        while(null != l1 || null != l2 || flow !=0){
            int l1Value = (null != l1) ? l1.val : 0;
            int l2Value = (null != l2) ? l2.val : 0;
            int ele = l1Value + l2Value + flow;
            if(ele >= 10){
                ele = ele - 10;
                flow = 1;
            }else{
                flow = 0;
            }
            result1.next = new ListNode(ele);
            result1 = result1.next;
            l1 = (null != l1) ? l1.next : null;
            l2 = (null != l2) ? l2.next : null;
        }
        return result2.next;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
