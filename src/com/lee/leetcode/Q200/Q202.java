package com.lee.leetcode.Q200;

import java.util.HashSet;

/**
 * @author Pwenlee
 * @date 2020/10/10 16:03
 * @description
 */
public class Q202 {
//    202. 快乐数
//    编写一个算法来判断一个数 n 是不是快乐数。
//
//            「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
//
//    如果 n 是快乐数就返回 True ；不是，则返回 False 。
//
//    示例：
//
//    输入：19
//    输出：true
//    解释：
//            12 + 92 = 82
//            82 + 22 = 68
//            62 + 82 = 100
//            12 + 02 + 02 = 1
//    通过次数102,112提交次数168,226
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/happy-number
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while(true){
            if(n == 1){
                return true;
            }else{
                if(hashSet.contains(n)){
                    return false;
                }
                hashSet.add(n);
                n = getNew(n);
            }
        }
    }

    public static int getNew(int n){
        int result = 0;
        while(n != 0){
            int mod = n % 10;
            result += mod * mod;
            n = n / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
