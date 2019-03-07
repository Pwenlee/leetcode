package com.lee.leetcode.Q300;

import java.util.*;

/**
 * @author Pwenlee
 * @date 2019/3/7 16:41
 * @description
 */
public class Q381 {
//    设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
//
//    注意: 允许出现重复元素。
//
//    insert(val)：向集合中插入元素 val。
//    remove(val)：当 val 存在时，从集合中移除一个 val。
//    getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
//    示例:
//
//    // 初始化一个空的集合。
//    RandomizedCollection collection = new RandomizedCollection();
//
//    // 向集合中插入 1 。返回 true 表示集合不包含 1 。
//    collection.insert(1);
//
//    // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
//    collection.insert(1);
//
//    // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
//    collection.insert(2);
//
//    // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
//    collection.getRandom();
//
//    // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
//    collection.remove(1);
//
//    // getRandom 应有相同概率返回 1 和 2 。
//    collection.getRandom();

    static class RandomizedCollection {

        private List<Integer> list;

        private Set<Integer> set;

        /** Initialize your data structure here. */
        public RandomizedCollection() {
            set = new HashSet<>();
            list = new ArrayList();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            Integer ele = new Integer(val);
            if(set.contains(ele)){
                list.add(ele);
                return false;
            }else{
                set.add(ele);
                return true;
            }
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            Integer ele = new Integer(val);
            boolean result = list.remove(ele);
            return result ? result : set.remove(ele);
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            int index = new Random().nextInt(set.size()+list.size());
            if(index < set.size()){
                List<Integer> setList = new ArrayList<>(set);
                return setList.get(index);
            }else{
                index = index - set.size();
                return list.get(index);
            }
        }
    }

    public static void main(String[] args) {
        // 初始化一个空的集合。
        RandomizedCollection collection = new RandomizedCollection();

// 向集合中插入 1 。返回 true 表示集合不包含 1 。
        collection.insert(1);

// 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
        collection.remove(2);

// 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
        collection.insert(2);

// getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
        collection.getRandom();

// 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
        collection.remove(1);
        // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
        collection.insert(2);

// getRandom 应有相同概率返回 1 和 2 。
        collection.getRandom();
    }
}
