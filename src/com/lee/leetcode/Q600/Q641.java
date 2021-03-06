package com.lee.leetcode.Q600;

/**
 * @author Pwenlee
 * @date 2019/7/12 14:10
 * @description
 */
public class Q641 {
//    641. 设计循环双端队列
//    设计实现双端队列。
//    你的实现需要支持以下操作：
//
//    MyCircularDeque(k)：构造函数,双端队列的大小为k。
//    insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
//    insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
//    deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
//    deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
//    getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
//    getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
//    isEmpty()：检查双端队列是否为空。
//    isFull()：检查双端队列是否满了。
//    示例：
//
//    MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//    circularDeque.insertLast(1);			        // 返回 true
//    circularDeque.insertLast(2);			        // 返回 true
//    circularDeque.insertFront(3);			        // 返回 true
//    circularDeque.insertFront(4);			        // 已经满了，返回 false
//    circularDeque.getRear();  				// 返回 2
//    circularDeque.isFull();				        // 返回 true
//    circularDeque.deleteLast();			        // 返回 true
//    circularDeque.insertFront(4);			        // 返回 true
//    circularDeque.getFront();				// 返回 4
// 
//    提示：
//
//    所有值的范围为 [1, 1000]
//    操作次数的范围为 [1, 1000]
//    请不要使用内置的双端队列库。

    class MyCircularDeque {

        private Node head;

        private Node tail;

        private int size;

        private int maxSize;

        class Node {
            int val;

            Node next;

            Node last;

            public Node(int val, Node next, Node last) {
                this.val = val;
                this.next = next;
                this.last = last;
            }
        }

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            this.maxSize = k;
            head = null;
            tail = null;
            size = 0;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if(size == maxSize){
                return false;
            }
            if(size == 0){
                Node node = new Node(value, null, null);
                head = node;
                tail = node;
            }else{
                Node node = new Node(value, this.head, null);
                head.last = node;
                head = node;
            }
            size++;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if(size == maxSize){
                return false;
            }
            if(size == 0){
                Node node = new Node(value, null, null);
                head = node;
                tail = node;
            }else{
                Node node = new Node(value, null, this.tail);
                tail.next = node;
                tail = node;
            }
            size++;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if(size < 1){
                return false;
            }else if(size == 1){
                head = null;
                tail = null;
            }else{
                head = head.next;
            }
            size--;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if(size < 1){
                return false;
            }else if(size == 1){
                head = null;
                tail = null;
            }else{
                tail = tail.last;
            }
            size--;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            return size == 0 ? -1 : head.val;
        }

        /** Get the last item from the deque. */
        public int getRear() {
            return size == 0 ? -1 : tail.val;
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return size == 0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return size == maxSize;
        }
    }
}
