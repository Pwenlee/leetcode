package com.lee.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Pwenlee
 * @date 2019/1/28 15:20
 * @description
 */
public class Q967 {

//    967. 连续差相同的数字
//    返回所有长度为 N 且满足其每两个连续位上的数字之间的差的绝对值为 K 的非负整数。
//
//    请注意，除了数字 0 本身之外，答案中的每个数字都不能有前导零。例如，01 因为有一个前导零，所以是无效的；但 0 是有效的。
//
//    你可以按任何顺序返回答案。
//
//
//
//    示例 1：
//
//    输入：N = 3, K = 7
//    输出：[181,292,707,818,929]
//    解释：注意，070 不是一个有效的数字，因为它有前导零。
//    示例 2：
//
//    输入：N = 2, K = 1
//    输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
//
//
//    提示：
//
//            1 <= N <= 9
//            0 <= K <= 9


    public static int[] numsSameConsecDiff(int N, int K) {
        if(N == 1){
            return new int[]{0,1,2,3,4,5,6,7,8,9};
        }
        List<String> list = new LinkedList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        List<String> list1 = new LinkedList<>();
        for(int i=1;i<N;i++) {
            for (String s : list) {
                int temp = Integer.valueOf(s.substring(s.length() -1, s.length()));
                for(int j=0;j<=9;j++){
                    if(K == Math.abs(temp - j)){
                        String newStr = new String(s) + j;
                        list1.add(newStr);
                    }
                }
            }
            list = list1;
            list1 = new LinkedList<>();
        }
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = Integer.valueOf(list.get(i)).intValue();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(numsSameConsecDiff(3, 0)));
    }
}
