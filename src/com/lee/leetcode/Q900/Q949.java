package com.lee.leetcode.Q900;

/**
 * @author Pwenlee
 * @date 2019/3/14 16:28
 * @description
 */
public class Q949 {

//    949. 给定数字能组成的最大时间
//    给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
//
//    最小的 24 小时制时间是 00:00，而最大的是 23:59。从 00:00 （午夜）开始算起，过得越久，时间越大。
//
//    以长度为 5 的字符串返回答案。如果不能确定有效时间，则返回空字符串。
//
//    示例 1：
//
//    输入：[1,2,3,4]
//    输出："23:41"
//    示例 2：
//
//    输入：[5,5,5,5]
//    输出：""
//
//
//    提示：
//
//    A.length == 4
//    0 <= A[i] <= 9

    public static String largestTimeFromDigits(int[] A) {
        String result = "";
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if(j!=i){
                    for (int k = 0; k < A.length; k++) {
                        if(k!=i && k!=j && A[k]<6){
                            for (int m = 0; m < A.length; m++) {
                                if(m!=i && m!=j && m!=k){
                                    String time = "" + A[i] + A[j] + ":" + A[k] + A[m];
                                    System.out.println(time);
                                    if(time.compareTo("23:59") < 0 && time.compareTo(result) > 0){
                                        result = time;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(largestTimeFromDigits(new int[]{1,9,6,0}));
    }
}
