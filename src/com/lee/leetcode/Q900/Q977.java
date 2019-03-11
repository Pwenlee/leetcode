package com.lee.leetcode.Q900;

import java.util.Arrays;

/**
 * @author Pwenlee
 * @date 2019/3/4 19:56
 * @description
 */
public class Q977 {
//    977. 有序数组的平方
//    给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
//
//    示例 1：
//
//    输入：[-4,-1,0,3,10]
//    输出：[0,1,9,16,100]
//    示例 2：
//
//    输入：[-7,-3,2,3,11]
//    输出：[4,9,9,49,121]
//
//    提示：
//
//            1 <= A.length <= 10000
//            -10000 <= A[i] <= 10000
//    A 已按非递减顺序排序。
    //不占用额外空间版本
    public static int[] sortedSquares(int[] A) {
        if(null == A || A.length == 0){
            return A;
        }
        if(A.length == 1){
            return new int[]{A[0] * A[0]};
        }
        while(A[0] < 0){
            int value = Math.abs(A[0]);
            if(A[A.length - 1] <= value){
                int i = A.length - 1;
                leftMove(A, i);
                A[i] = value;
                continue;
            }
            for(int i=1; i<A.length;i++){
                if(A[i] >= 0){
                    if(value <= A[i]){
                        leftMove(A, i-1);
                        A[i-1] = value;
                        break;
                    }
                    if(A[i] <= value && (A[i+1] >= value || i==A.length-1)){
                        leftMove(A, i);
                        A[i] = value;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        return A;
    }

    private static int[] leftMove(int[] A, int i){
        int value = A[i];
        for (int j = i; j > 0; j--) {
            int value1 = A[j - 1];
            A[j-1] = value;
            value = value1;
        }
        return A;
    }

    public static int[] sortedSquares1(int[] A) {
        if(null == A || A.length == 0){
            return A;
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-2,-1,3})));
    }
}
