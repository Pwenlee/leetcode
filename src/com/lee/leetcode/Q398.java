package com.lee.leetcode;

import java.util.*;

/**
 * @author Pwenlee
 * @date 2019/2/14 10:00
 * @description
 */
public class Q398 {
//398. 随机数索引
//    给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
//
//    注意：
//    数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
//
//    示例:
//
//    int[] nums = new int[] {1,2,3,3,3};
//    Solution solution = new Solution(nums);
//
//    pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
//    solution.pick(3);
//
//    pick(1) 应该返回 0。因为只有nums[0]等于1。
//    solution.pick(1);

    static class Solution {

        private Map<Integer, List<Integer>> map = new HashMap<>();

        public Solution(int[] nums) {
            if(Objects.nonNull(nums) && nums.length > 0){
                for(int i=0;i<nums.length;i++){
                    List<Integer> indexList = map.get(nums[i]);
                    if(Objects.isNull(indexList)){
                        indexList = new ArrayList<>();
                    }
                    indexList.add(i);
                    map.put(nums[i], indexList);
                }
            }
        }

        public int pick(int target) {
            List<Integer> indexList = map.get(target);
            if(Objects.isNull(indexList) || indexList.size() == 0){
                return -1;
            }
            if(indexList.size() == 1){
                return indexList.get(0);
            }
            return indexList.get(new Random().nextInt(indexList.size()));
        }
    }
}
