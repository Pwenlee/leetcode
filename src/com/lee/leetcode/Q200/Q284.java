package com.lee.leetcode.Q200;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Pwenlee
 * @date 2019/3/21 10:28
 * @description
 */
public class Q284 {

//    284. 顶端迭代器
//    给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。设计并实现一个支持 peek() 操作的顶端迭代器 -- 其本质就是把原本应由 next() 方法返回的元素 peek() 出来。
//
//    示例:
//
//    假设迭代器被初始化为列表 [1,2,3]。
//
//    调用 next() 返回 1，得到列表中的第一个元素。
//    现在调用 peek() 返回 2，下一个元素。在此之后调用 next() 仍然返回 2。
//    最后一次调用 next() 返回 3，末尾元素。在此之后调用 hasNext() 应该返回 false。
//    进阶：你将如何拓展你的设计？使之变得通用化，从而适应所有的类型，而不只是整数型？

    // Java Iterator interface reference:
    // https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

    class PeekingIterator implements Iterator<Integer> {

        private List<Integer> list = new ArrayList<>();

        private int index = -1;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            while(iterator.hasNext()){
                list.add(iterator.next());
            }
        }

        // Returns the next element in the iteration without advancing the iterator.

        public Integer peek() {
            return list.get(index);
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.

        @Override
        public Integer next() {
            index++;
            return list.get(index);
        }

        @Override
        public boolean hasNext() {
            return index < list.size() - 1;
        }
    }
}
