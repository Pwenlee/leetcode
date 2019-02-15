package com.lee.leetcode.Q500;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author lipan
 * @date 2019/2/15 10:10
 * @description
 */
public class Q506 {
//    506.相对名次
//    给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
//
//            (注：分数越高的选手，排名越靠前。)
//
//    示例 1:
//
//    输入: [5, 4, 3, 2, 1]
//    输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
//    解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
//    余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
//    提示:
//
//    N 是一个正整数并且不会超过 10000。
//    所有运动员的成绩都不相同。

    public static String[] findRelativeRanks(int[] nums) {
        String[] result = new String[nums.length];
        if(Objects.nonNull(nums) && nums.length > 0){
            List<Integer> sort = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            for (int i=0;i<nums.length;i++) {
                int index = sort.indexOf(nums[i]) + 1;
                switch (index){
                    case 1:
                        result[i] = "Gold Medal";
                        break;
                    case 2:
                        result[i] = "Silver Medal";
                        break;
                    case 3:
                        result[i] = "Bronze Medal";
                        break;
                    default:
                        result[i] = String.valueOf(index);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{5,4,3,2,1})));
    }
}
