package com.lee.leetcode.Q400;

/**
 * @author Pwenlee
 * @date 2019/3/28 16:14
 * @description
 */
public class Q461 {

//    461. 汉明距离
//    两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
//
//    给出两个整数 x 和 y，计算它们之间的汉明距离。
//
//    注意：
//            0 ≤ x, y < 2^31.
//
//    示例:
//
//    输入: x = 1, y = 4
//
//    输出: 2
//
//    解释:
//            1   (0 0 0 1)
//            4   (0 1 0 0)
//            ↑   ↑
//
//    上面的箭头指出了对应二进制位不同的位置。

    public static int hammingDistance(int x, int y) {
        int result = 0;
        //按照每一个位来  如果最后一位与1的值不相同 距离+1
        for(int i = 0; i<= 31; i++){
            int x1 = x >> i;
            int y1 = y >> i;
            if(x1 == 0 && y1 == 0){
                break;
            }
            if((x1 & 1) != (y1 & 1)){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
