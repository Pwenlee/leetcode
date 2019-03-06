package com.lee.leetcode.Q400;

/**
 * @author Pwenlee
 * @date 2019/3/6 14:55
 * @description
 */
public class Q400 {
//    400. 第N个数字
//    在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
//
//    注意:
//    n 是正数且在32为整形范围内 ( n < 231)。
//
//    示例 1:
//
//    输入:
//            3
//
//    输出:
//            3
//    示例 2:
//
//    输入:
//            11
//
//    输出:
//            0
//
//    说明:
//    第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。


    public static int findNthDigit(int n) {
        if(n<=9){
            return n;
        }
        long count = 0;
        for(int i=1;i<=n;i++){
            long currentCount = i*9*(int)Math.pow(10, i-1);
            if(currentCount + count > n || currentCount < 0){
                int min = (int)Math.pow(10, i-1);
                int max = (int)Math.pow(10, i) - 1;
                long leftCount = n - count;
                for(;min<=max;min++){
                    if(leftCount <= i){
                        char[] chars = String.valueOf(min).toCharArray();
                        return Integer.valueOf(String.valueOf(new char[]{chars[(int)leftCount-1]}));
                    }else{
                        leftCount = leftCount - i;
                    }
                }
            }
            count = count + currentCount;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(1000000000));
    }
}
