package com.lee.leetcode.Q900;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Pwenlee
 * @date 2019/4/15 09:52
 * @description
 */
public class Q937 {
//    937. 重新排列日志文件
//    你有一个日志数组 logs。每条日志都是以空格分隔的字串。
//
//    对于每条日志，其第一个字为字母数字标识符。然后，要么：
//
//    标识符后面的每个字将仅由小写字母组成，或；
//    标识符后面的每个字将仅由数字组成。
//    我们将这两种日志分别称为字母日志和数字日志。保证每个日志在其标识符后面至少有一个字。
//
//    将日志重新排序，使得所有字母日志都排在数字日志之前。字母日志按字母顺序排序，忽略标识符，标识符仅用于表示关系。数字日志应该按原来的顺序排列。
//
//    返回日志的最终顺序。
//
//    示例 ：
//
//    输入：["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
//    输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
//
//    提示：
//
//            0 <= logs.length <= 100
//            3 <= logs[i].length <= 100
//    logs[i] 保证有一个标识符，并且标识符后面有一个字。

    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, 0, logs.length, (o1, o2) ->{
            String s1 = o1.substring(o1.indexOf(" ") + 1);
            String s2 = o2.substring(o2.indexOf(" ") + 1);
            String v1 = s1.contains(" ") ? s1.substring(0, s1.indexOf(" ")) : s1;
            String v2 = s2.contains(" ") ? s2.substring(0, s2.indexOf(" ")) : s2;
            if(v1.toUpperCase().equals(v1)){
                if(v2.toUpperCase().equals(v2)){
                    return 0;
                }else{
                    return 1;
                }
            }else{
                if(v2.toUpperCase().equals(v2)){
                    return -1;
                }else{
                    return s1.compareTo(s2);
                }
            }
        });
        return logs;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reorderLogFiles(new String[]{"1 n u", "r 527", "j 893", "6 14" ,"6 82"})));
    }
}
