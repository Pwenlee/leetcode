package com.lee.leetcode.Q1300;

/**
 * @author Pwenlee
 * @date 2020-04-24 15:03
 * @description
 */
public class Q1395 {
//    1395. 统计作战单位数
//     n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
//
//    每 3 个士兵可以组成一个作战单位，分组规则如下：
//
//    从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
//    作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中  0 <= i < j < k < n
//    请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
//
//    示例 1：
//
//    输入：rating = [2,5,3,4,1]
//    输出：3
//    解释：我们可以组建三个作战单位 (2,3,4)、(5,4,1)、(5,3,1) 。
//    示例 2：
//
//    输入：rating = [2,1,3]
//    输出：0
//    解释：根据题目条件，我们无法组建作战单位。
//    示例 3：
//
//    输入：rating = [1,2,3,4]
//    输出：4
//             
//    提示：
//
//    n == rating.length
//    1 <= n <= 200
//            1 <= rating[i] <= 10^5
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/count-number-of-teams
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int numTeams(int[] rating) {
        if (rating == null || rating.length < 3) {
            return 0;
        }
        int[] result = new int[rating.length];
        result[2] = isTeam(rating[0], rating[1], rating[2]) ? 1 : 0;
        for (int i = 3; i < rating.length; i++) {
            result[i] = result[i - 1] + numTeams(rating, i);
        }
        return result[rating.length - 1];
    }

    private int numTeams(int[] nums, int i) {
        int number = 0;
        int a = nums[i];
        for (int j = 0; j < i - 1; j++) {
            for (int k = j + 1; k < i; k++) {
                if (isTeam(nums[j], nums[k], a)) {
                    number++;
                }
            }
        }
        return number;
    }

    private boolean isTeam(int a, int b, int c) {
        return (a > b && b > c) || (a < b && b < c);
    }

    public static void main(String[] args) {
        System.out.println(new Q1395().numTeams(new int[]{2, 5, 3, 4, 1}));
        System.out.println(new Q1395().numTeams(new int[]{2, 1, 3}));
        System.out.println(new Q1395().numTeams(new int[]{1, 2, 3, 4}));
    }

}
