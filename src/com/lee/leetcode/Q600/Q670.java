package com.lee.leetcode.Q600;

/**
 * @author Administrator
 * @date 2019/2/17 21:41
 * @description
 */
public class Q670 {

    //670. 最大交换
    //给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。

    //示例 1 :

    //输入: 2736
    //输出: 7236
    //解释: 交换数字2和数字7。

    //示例 2 :

    //输入: 9973
    //输出: 9973
    //解释: 不需要交换。

    public static int maximumSwap(int num) {
        String numStr = String.valueOf(num);
        char[] chars = numStr.toCharArray();
        for (int i = 0; i<chars.length; i++) {
            char maxValue = chars[i];
            int maxIndex = i;
            for(int j=i+1; j<chars.length;j++){
                if(chars[j] >= maxValue){
                    maxValue = chars[j];
                    maxIndex = j;
                }
            }
            if(maxIndex != i && maxValue != chars[i]){
                char temp = chars[i];
                chars[i] = chars[maxIndex];
                chars[maxIndex] = temp;
                long result = Long.valueOf(new String(chars));
                if(result <= Integer.MAX_VALUE){
                    return (int)result;
                }else{
                    chars[maxIndex] = chars[i];
                    chars[i] = temp;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(1993));
    }
}
