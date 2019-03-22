package com.lee.leetcode.Q800;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Pwenlee
 * @date 2019/3/22 14:39
 * @description
 */
public class Q855 {

//    855. 考场就座
//    在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
//
//    当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
//
//    返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。请确保每次调用 ExamRoom.leave(p) 时都有学生坐在座位 p 上。
//
//    示例：
//
//    输入：["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
//    输出：[null,0,9,4,2,null,5]
//    解释：
//    ExamRoom(10) -> null
//    seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。
//    seat() -> 9，学生最后坐在 9 号座位上。
//    seat() -> 4，学生最后坐在 4 号座位上。
//    seat() -> 2，学生最后坐在 2 号座位上。
//    leave(4) -> null
//    seat() -> 5，学生最后坐在 5 号座位上。
//
//    提示：
//
//            1 <= N <= 10^9
//    在所有的测试样例中 ExamRoom.seat() 和 ExamRoom.leave() 最多被调用 10^4 次。
//    调用 ExamRoom.leave(p) 时需要确保当前有学生坐在座位 p 上。

    static class ExamRoom {

        private List<Integer> list;

        private int N;

        public ExamRoom(int N) {
            //记录已经入座的位置
            this.list = new ArrayList<>();
            //记录总的座位个数
            this.N = N;
        }

        public int seat() {
            //如果入座的人数为0，则直接入座第一个
            if(list.size() == 0){
                list.add(0);
                return 0;
            }
            //初始化相隔空间
            int space = -1;
            int result = 0;
            //如果第一个入座的位置不是第0个位置
            if(list.get(0).intValue() != 0 ) {
                //计算出空间 第一个位置-0-1
                space = list.get(0) - 0 - 1;
                //space肯定大于-1 暂定第0个位置
                result = 0;
            }
            for (int i = 1; i < list.size(); i++) {
                //如果第二个入座的位置开始  往前计算空间
                int current = list.get(i);
                int last = list.get(i-1);
                //如果当前入座的的位置和上一个入座的位置必须有一个空的位置
                if(current > last + 1) {
                    int currentSpace = (current - last - 1 - 1) >> 1;
                    if (currentSpace > space) {
                        space = currentSpace;
                        result = (current + last) >> 1;
                    }
                }
            }
            //如果最后一个入座的位置不是n-1 计算最后一个入座的位置与n-1的控件
            if(list.get(list.size()-1) != N - 1) {
                int lastSpace = N - 1 - list.get(list.size() - 1) - 1;
                //如果空间大于之前的暂定空间  则直接入座最后一个位置
                if (lastSpace > space) {
                    result = N - 1;
                }
            }
            //入座
            list.add(result);
            //重新排序
            list.sort(Comparator.naturalOrder());
            return result;
        }

        public void leave(int p) {
            list.remove(new Integer(p));
        }
    }

    public static void main(String[] args) {
        ExamRoom x = new ExamRoom(10);
        System.out.println("null");
        System.out.println(x.seat());
        System.out.println(x.seat());
        System.out.println(x.seat());
        x.leave(0);
        x.leave(4);
        System.out.println("null");
        System.out.println("null");
        System.out.println(x.seat());
        System.out.println(x.seat());
        System.out.println(x.seat());
        System.out.println(x.seat());
        System.out.println(x.seat());
        System.out.println(x.seat());
        System.out.println(x.seat());
        System.out.println(x.seat());
        System.out.println(x.seat());
        x.leave(0);
        System.out.println("null");
    }
}
