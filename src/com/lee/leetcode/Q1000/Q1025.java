package com.lee.leetcode.Q1000;

/**
 * @author Pwenlee
 * @date 2019/7/10 15:35
 * @description
 */
public class Q1025 {
//    1025. 除数博弈
//    爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
//
//    最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
//
//    选出任一 x，满足 0 < x < N 且 N % x == 0 。
//    用 N - x 替换黑板上的数字 N 。
//    如果玩家无法执行这些操作，就会输掉游戏。
//
//    只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
//
//    示例 1：
//
//    输入：2
//    输出：true
//    解释：爱丽丝选择 1，鲍勃无法进行操作。
//    示例 2：
//
//    输入：3
//    输出：false
//    解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
//
//    提示：
//            1 <= N <= 1000

    private static byte[] result = new byte[1000];

    private static int CURRENT_VALUE = 3;

    static {
        result[0] = 0;
        result[1] = 1;
        result[2] = 0;
    }

    public static boolean divisorGame(int N) {
        if(CURRENT_VALUE >= N){
            return result[N - 1] > 0;
        }
        for (int i = CURRENT_VALUE + 1; i <= N; i++) {
            for(int j = 1; j<= i/2; j++) {
                if (i % j == 0) {
                    if (result[i - j - 1] == 0) {
                        result[i - 1] = 1;
                        break;
                    }
                }
            }
            CURRENT_VALUE++;
        }
        return divisorGame(N);
    }

    //4 true
    //5 false
    //9 false

    public static void main(String[] args) {
        System.out.println(divisorGame(9));
    }
}
