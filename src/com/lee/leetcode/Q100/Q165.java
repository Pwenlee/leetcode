package com.lee.leetcode.Q100;

/**
 * @author Pwenlee
 * @date 2019/5/13 17:29
 * @description
 */
public class Q165 {
//    165. 比较版本号
//    比较两个版本号 version1 和 version2。
//    如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
//
//    你可以假设版本字符串非空，并且只包含数字和 . 字符。
//
//            . 字符不代表小数点，而是用于分隔数字序列。
//
//    例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
//
//    你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
//
//
//    示例 1:
//
//    输入: version1 = "0.1", version2 = "1.1"
//    输出: -1
//    示例 2:
//
//    输入: version1 = "1.0.1", version2 = "1"
//    输出: 1
//    示例 3:
//
//    输入: version1 = "7.5.2.4", version2 = "7.5.3"
//    输出: -1
//    示例 4：
//
//    输入：version1 = "1.01", version2 = "1.001"
//    输出：0
//    解释：忽略前导零，“01” 和 “001” 表示相同的数字 “1”。
//    示例 5：
//
//    输入：version1 = "1.0", version2 = "1.0.0"
//    输出：0
//    解释：version1 没有第三级修订号，这意味着它的第三级修订号默认为 “0”。
//
//
//    提示：
//
//    版本字符串由以点 （.） 分隔的数字字符串组成。这个数字字符串可能有前导零。
//    版本字符串不以点开始或结束，并且其中不会有两个连续的点。

    public static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int length1 = arr1.length;
        int length2 = arr2.length;

        int[] v1 = new int[length1];
        int[] v2 = new int[length2];
        for (int i = 0; i < arr1.length; i++) {
            v1[i] = Integer.valueOf(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            v2[i] = Integer.valueOf(arr2[i]);
        }
        for(int i=0;i<Math.max(length1, length2);i++){
            int value1 = i < length1 ? v1[i] : 0;
            int value2 = i < length2 ? v2[i] : 0;
            if(value1 > value2){
                return 1;
            }else if(value1 < value2){
                return -1;
            }
        }
        return 0;
    }


    public static void main(String[] args){
        System.out.println(compareVersion("01", "1"));
    }
}
