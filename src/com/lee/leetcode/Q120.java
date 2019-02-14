package com.lee.leetcode;

import java.util.List;

/**
 * @author Pwenlee
 * @date 2019/1/28 15:44
 * @description
 */
public class Q120 {
//    120. 三角形最小路径和
//    给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
//    例如，给定三角形：
//
//            [
//              [2],
//             [3,4],
//            [6,5,7],
//           [4,1,8,3]
//            ]
//    自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
//    说明：
//
//    如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。

    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=triangle.size()-2;i>=0;i--){
            List<Integer> row = triangle.get(i);
            List<Integer> nextRow = triangle.get(i+1);
            for(int j=0;j<row.size();j++){
                row.set(j, row.get(j) + Math.min(nextRow.get(j), nextRow.get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {

    }
}
