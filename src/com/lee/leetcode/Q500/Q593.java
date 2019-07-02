package com.lee.leetcode.Q500;

import java.util.Arrays;

/**
 * @author Pwenlee
 * @date 2019/7/1 17:28
 * @description
 */
public class Q593 {
//    593. 有效的正方形
//    给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。
//
//    一个点的坐标（x，y）由一个有两个整数的整数数组表示。
//
//    示例:
//
//    输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
//    输出: True
// 
//
//    注意:
//
//    所有输入整数都在 [-10000，10000] 范围内。
//    一个有效的正方形有四个等长的正长和四个等角（90度角）。
//    输入点没有顺序。

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] distances = new int[6];
        distances[0] = getDistance(p1, p2);
        distances[1] = getDistance(p1, p3);
        distances[2] = getDistance(p1, p4);
        distances[3] = getDistance(p2, p3);
        distances[4] = getDistance(p2, p4);
        distances[5] = getDistance(p3, p4);
        if(distances[0] == 0 || distances[1] == 0 || distances[2] == 0
                || distances[3] == 0 || distances[4] == 0 ||distances[5] == 0){
            return false;
        }
        Arrays.sort(distances);
        return (distances[0] == distances[1]) && (distances[0] == distances[2]) && (distances[0] == distances[3])
                && (distances[4] == 2 * distances[0]) && (distances[4] == distances[5]);
    }

    private static int getDistance(int[] p1, int[] p2){
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }


    public static void main(String[] args) {
        System.out.println(validSquare(new int[]{1,1}, new int[]{1,2}, new int[]{0,1}, new int[]{0, 0}));
    }
}
