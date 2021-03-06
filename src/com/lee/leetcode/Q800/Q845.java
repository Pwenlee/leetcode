package com.lee.leetcode.Q800;

/**
 * @author Pwenlee
 * @date 2019/3/20 10:12
 * @description
 */
public class Q845 {
//    845. 数组中的最长山脉
//    我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
//
//    B.length >= 3
//    存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
//            （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
//
//    给出一个整数数组 A，返回最长 “山脉” 的长度。
//
//    如果不含有 “山脉” 则返回 0。
//
//    示例 1：
//
//    输入：[2,1,4,7,3,2,5]
//    输出：5
//    解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
//    示例 2：
//
//    输入：[2,2,2]
//    输出：0
//    解释：不含 “山脉”。
//
//    提示：
//
//            0 <= A.length <= 10000
//            0 <= A[i] <= 10000
    public static int longestMountain(int[] A) {
        int result = 0;
        if(A.length < 3){
            return result;
        }
        int sub = 0;
        for (int i = 0; i <= A.length - 3; i++) {
            if(A[i+1] > A[i]){
                if(A[i+1] > A[i+2]){
                    //如果第二项大于第一项 并且第三项小于第二项 则长度加3
                    sub = sub + 3;
                    //如果后面的元素满足 后一个元素小于前一个元素 则长度递增
                    for(int j = i + 2; j < A.length - 1; j++){
                        if(A[j+1] < A[j]){
                            i++;
                            sub++;
                        }else{
                            break;
                        }
                    }
                    result = Math.max(result, sub);
                }else{
                    //如果第二项大于第一项 并且第三项大于第二项 则长度加1
                    sub++;
                }
            }else{
                sub = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestMountain(new int[]{2,2,2}));
    }
}
