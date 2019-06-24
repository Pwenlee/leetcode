package com.lee.leetcode.Q100;

/**
 * @author Pwenlee
 * @date 2019/6/24 16:40
 * @description
 */
public class Q182 {

//    182. 查找重复的电子邮箱
//    编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。
//
//    示例：
//
//            +----+---------+
//            | Id | Email   |
//            +----+---------+
//            | 1  | a@b.com |
//            | 2  | c@d.com |
//            | 3  | a@b.com |
//            +----+---------+
//    根据以上输入，你的查询应返回以下结果：
//
//            +---------+
//            | Email   |
//            +---------+
//            | a@b.com |
//            +---------+
//    说明：所有电子邮箱都是小写字母。
//

    //select email from person group by email having count(id) > 1
}
