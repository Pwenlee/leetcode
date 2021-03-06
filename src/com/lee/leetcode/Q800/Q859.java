package com.lee.leetcode.Q800;

/**
 * @author Pwenlee
 * @date 2019/2/11 14:43
 * @description
 */
public class Q859 {
//    859. 亲密字符串
//    给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
//
//    示例 1：
//
//    输入： A = "ab", B = "ba"
//    输出： true
//    示例 2：
//
//    输入： A = "ab", B = "ab"
//    输出： false
//    示例 3:
//
//    输入： A = "aa", B = "aa"
//    输出： true
//    示例 4：
//
//    输入： A = "aaaaaaabc", B = "aaaaaaacb"
//    输出： true
//    示例 5：
//
//    输入： A = "", B = "aa"
//    输出： false
//
//    提示：
//
//            0 <= A.length <= 20000
//            0 <= B.length <= 20000
//    A 和 B 仅由小写字母构成。

    public static boolean buddyStrings(String A, String B) {
        if(A.length() != B.length() || A.length() == 0 || B.length() ==0){
            return false;
        }
        if(A.equals(B)){
            for(int i=0;i<A.length();i++){
                String temp = String.valueOf(A.charAt(i));
                if(A.indexOf(temp) != A.lastIndexOf(temp)){
                    return true;
                }
            }
            return false;
        }else{
            char[] a = A.toCharArray();
            char[] b = B.toCharArray();
            char other1A =a[1];
            char other1B =b[1];
            char other2A =a[1];
            char other2B =b[1];
            int flag = 0;
            for(int i=0;i<a.length;i++){
                if(a[i] != b[i]){
                    flag++;
                    if(flag == 1){
                        other1A = a[i];
                        other1B = b[i];
                    }else if(flag == 2){
                        other2A = a[i];
                        other2B = b[i];
                    }else if(flag > 2){
                        return false;
                    }
                }

            }
            if(other1A == other2B && other1B == other2A && flag == 2){
                return true;
            }else{
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
