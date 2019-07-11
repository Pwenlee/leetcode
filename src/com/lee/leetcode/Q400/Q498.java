package com.lee.leetcode.Q400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Pwenlee
 * @date 2019/7/11 14:42
 * @description
 */
public class Q498 {
//    498. 对角线遍历
//    给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。 
//
//    示例:
//
//    输入:
//            [
//            [ 1, 2, 3 ],
//            [ 4, 5, 6 ],
//            [ 7, 8, 9 ]
//            ]
//
//    输出:  [1,2,4,7,5,3,6,8,9]
//
//    解释:
//
//    说明:
//
//    给定矩阵中的元素总数不会超过 100000 。

    public static int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0){
            return new int[0];
        }
        int maxX = matrix.length - 1;
        int maxY = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>(maxX * maxY);
        int x = 0;
        int y = 0;
        boolean flag = true;
        while (x <= maxX && y <= maxY){
            list.add(matrix[x][y]);
            if(flag){
                while(x > 0 && y < maxY){
                    x--;
                    y++;
                    list.add(matrix[x][y]);
                }
                if(y < maxY){
                    y++;
                }else{
                    x++;
                }
            }else{
                while(y > 0 && x < maxX){
                    x++;
                    y--;
                    list.add(matrix[x][y]);
                }
                if(x < maxX){
                    x++;
                }else{
                    y++;
                }
            }
            flag = !flag;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{new int[]{3}, new int[]{2}})));
    }
}
