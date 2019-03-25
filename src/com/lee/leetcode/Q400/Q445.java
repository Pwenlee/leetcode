package com.lee.leetcode.Q400;

import com.lee.leetcode.Common;
import com.lee.leetcode.Common.ListNode;
import com.lee.leetcode.Q.Q2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import java.util.stream.Collectors;

/**
 * @author Pwenlee
 * @date 2019/3/25 16:00
 * @description
 */
public class Q445 {

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        //两条链表逆序 再用Q2的加法相加 结果再逆序
        return Common.reverse(Q2.addTwoNumbers(Common.reverse(l1), Common.reverse(l2)));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        while(Objects.nonNull(l1)){
            list1.add(l1.val);
            l1 = l1.next;
        }
        while(Objects.nonNull(l2)){
            list2.add(l2.val);
            l2 = l2.next;
        }
        int flow = 0;
        for(int i=1,j=1; i <= list1.size() || j <= list2.size(); i++,j++){
            int v1 = 0;
            int v2 = 0;
            if(i <= list1.size()){
                v1 = list1.get(list1.size() - i);
            }
            if(j <= list2.size()){
                v2 = list2.get(list2.size() - j);
            }
            int value = v1 + v2 + flow;
            if(value >= 10){
                value = value - 10;
                flow = 1;
            }else {
                flow = 0;
            }
            result.add(value);
        }
        if(flow > 0){
            result.add(flow);
        }
        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(",")));
        ListNode node = new ListNode(result.get(0));
        for (int i = 1; i < result.size(); i++) {
            ListNode newNode = new ListNode(result.get(i));
            newNode.next = node;
            node = newNode;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(4);

        l3.next = l4;
        l2.next = l3;
        l1.next = l2;

        l6.next = l7;
        l5.next = l6;
        //7243+564 = 7807
        //System.out.println(addTwoNumbers1(l1, l5).toString());
        System.out.println(addTwoNumbers(l1, l5).toString());
    }
}
