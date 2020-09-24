package com.lee.leetcode.Q100;

/**
 * @author Pwenlee
 * @date 2020/9/24 09:11
 * @description
 */
public class Q180 {
//    180. 连续出现的数字
//    编写一个 SQL 查询，查找所有至少连续出现三次的数字。
//
//            +----+-----+
//            | Id | Num |
//            +----+-----+
//            | 1  |  1  |
//            | 2  |  1  |
//            | 3  |  1  |
//            | 4  |  2  |
//            | 5  |  1  |
//            | 6  |  2  |
//            | 7  |  2  |
//            +----+-----+
//    例如，给定上面的 Logs 表， 1 是唯一连续出现至少三次的数字。
//
//            +-----------------+
//            | ConsecutiveNums |
//            +-----------------+
//            | 1               |
//            +-----------------+
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/consecutive-numbers
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//    select distinct(num1) ConsecutiveNums from
//    (select a.num num1, b.num num2, c.num num3 from Logs a
//        join Logs  b on(a.id - 1 = b.id)
//        join Logs  c on(a.id + 1 = c.id)) tmp
//    where num1 = num2 and num2 = num3

}
