package com.lee.leetcode.Q;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Pwenlee
 * @date 2019/3/11 20:20
 * @description
 */
public class Q119 {
//    119. 杨辉三角 II
//    给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
//
//    在杨辉三角中，每个数是它左上方和右上方的数的和。
//
//    示例:
//
//    输入: 3
//    输出: [1,3,3,1]
//    进阶：
//
//    你可以优化你的算法到 O(k) 空间复杂度吗？

    private static Map<Integer, List<Integer>> map ;

    static {
        map = new HashMap(34);
        map.put(0, new ArrayList<>(Arrays.asList(1)));
        map.put(1, new ArrayList<>(Arrays.asList(1,1)));
        map.put(2, new ArrayList<>(Arrays.asList(1,2,1)));
        map.put(3, new ArrayList<>(Arrays.asList(1,3,3,1)));
        map.put(4, new ArrayList<>(Arrays.asList(1,4,6,4,1)));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = map.get(rowIndex);
        if(Objects.isNull(list)){
            List<Integer> last = getRow(rowIndex-1);
            list = new ArrayList<>(last.size()+1);
            list.add(1);
            for (int i = 0; i < last.size()-1; i++) {
                list.add(last.get(i)+last.get(i+1));
            }
            list.add(1);
            map.put(rowIndex, list);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getRow(5).stream().map(String::valueOf).collect(Collectors.joining(",","[","]")));
    }
}
