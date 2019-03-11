package com.lee.leetcode.Q900;

/**
 * @author Pwenlee
 * @date 2019/2/20 20:15
 * @description
 */
public class Q930 {

    //930.和相同的二元子数组
    //在由若干 0 和 1  组成的数组 A 中，有多少个和为 S 的非空子数组。

    //示例：

    //输入：A = [1,0,1,0,1], S = 2
    //输出：4
    //解释：
    //如下面黑体所示，有 4 个满足题目要求的子数组：
            //[1,0,1,0,1]
            //[1,0,1,0,1]
            //[1,0,1,0,1]
            //[1,0,1,0,1]

    //提示：

    //A.length <= 30000
    //0 <= S <= A.length
    //A[i] 为 0 或 1

    public static int numSubarraysWithSum(int[] A, int S) {
        if(null == A || A.length ==0){
            return 0;
        }
        int result = 0;
        for(int i=0; i<A.length-1; i++){
            int sum = A[i];
            if(sum == S){
                result = result + 1;
            }
            for(int j=i+1; j<A.length; j++){
               sum = sum + A[j];
               if(sum < S){
                   continue;
               }else if(sum == S){
                   result = result + 1;
               }else{
                   break;
               }
            }
        }
        if(A[A.length-1] == S){
            result = result + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{0,0,0,0,0},0));
    }
}
