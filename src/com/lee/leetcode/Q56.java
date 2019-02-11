package com.lee.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lipan
 * @date 2019/2/11 14:43
 * @description
 */
public class Q56 {
//    56. 合并区间
//    给出一个区间的集合，请合并所有重叠的区间。
//
//    示例 1:
//
//    输入: [[1,3],[2,6],[8,10],[15,18]]
//    输出: [[1,6],[8,10],[15,18]]
//    解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//    示例 2:
//
//    输入: [[1,4],[4,5]]
//    输出: [[1,5]]
//    解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

    static class Interval{
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        intervals = intervals.stream().sorted(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        }).collect(Collectors.toList());
        List<Interval> result = new ArrayList<>();
        for(int i=0;i<intervals.size();i++){
            Interval interval = intervals.get(i);
            while(i < intervals.size()){
                Interval next = intervals.get(i + 1);
                if(next.start > interval.end){
                    break;
                }else{
                    int end = Math.max(interval.end, next.end);
                    interval = new Interval(interval.start, end);
                }
                i++;
            }
            result.add(interval);

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
