package com.lee.leetcode.Q800;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Pwenlee
 * @date 2019/3/28 15:34
 * @description
 */
public class Q840 {
//    840. 矩阵中的幻方
//    3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
//
//    给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
//
//    示例：
//
//    输入: [[4,3,8,4],
//            [9,5,1,9],
//            [2,7,6,2]]
//    输出: 1
//    解释:
//    下面的子矩阵是一个 3 x 3 的幻方：
//            438
//            951
//            276
//
//    而这一个不是：
//            384
//            519
//            762
//
//    总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
//    提示:
//
//            1 <= grid.length <= 10
//            1 <= grid[0].length <= 10
//            0 <= grid[i][j] <= 15

    public int numMagicSquaresInside(int[][] grid) {
        int result = 0;
        for(int i = 0; i + 2 < grid.length; i++){
            for(int j = 0; j + 2 < grid[0].length; j++){
                int[][] sub = new int[][]{new int[]{grid[i][j], grid[i][j+1], grid[i][j+2]},
                                          new int[]{grid[i+1][j], grid[i+1][j+1], grid[i+1][j+2]},
                                          new int[]{grid[i+2][j], grid[i+2][j+1], grid[i+2][j+2]}};
                if(check(sub)){
                    result++;
                }
            }
        }
        return result;
    }

    private boolean check(int[][] grid){
        if(grid[1][1] != 5){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i <= 2; i++){
            int sumX = 0;
            int sumY = 0;
            for(int j = 0; j <= 2; j++){
                if(grid[i][j] >= 1 && grid[i][j] <= 9 && grid[j][i] >= 1 && grid[j][i] <= 9) {
                    set.add(grid[i][j]);
                    set.add(grid[j][i]);
                    sumX = sumX + grid[i][j];
                    sumY = sumY + grid[j][i];
                }else{
                    return false;
                }
            }
            if(sumX != 15){
                return false;
            }
            if(sumY != 15){
                return false;
            }
        }
        if(set.size() != 9){
            return false;
        }
        if(grid[0][0] + grid[1][1] + grid[2][2] != 15){
            return false;
        }
        if(grid[0][2] + grid[1][1] + grid[2][0] != 15){
            return false;
        }
        return true;
    }
}
