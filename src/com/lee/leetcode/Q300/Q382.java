package com.lee.leetcode.Q300;

import java.util.Objects;
import java.util.Random;
import com.lee.leetcode.Common.ListNode;

/**
 * @author Pwenlee
 * @date 2019/3/20 15:40
 * @description
 */
public class Q382 {
//    382. 链表随机节点
//    给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
//
//    进阶:
//    如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
//
//    示例:
//
//    // 初始化一个单链表 [1,2,3].
//    ListNode head = new ListNode(1);
//    head.next = new ListNode(2);
//    head.next.next = new ListNode(3);
//    Solution solution = new Solution(head);
//
//    // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
//    solution.getRandom();

    static class Solution {

        private ListNode head;

        private int length = 0;

        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
            while(Objects.nonNull(head)){
                this.length++;
                head = head.next;
            }
        }

        /** Returns a random node's value. */
        public int getRandom() {
            int index = new Random().nextInt(length) + 1;
            ListNode copy = new ListNode(head.val);
            copy.next = head.next;
            while(index != 1){
                copy = copy.next;
                index--;
            }
            return copy.val;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Solution solution = new Solution(head);
        System.out.println(solution.getRandom());
    }
}
