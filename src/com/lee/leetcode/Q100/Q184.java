package com.lee.leetcode.Q100;

/**
 * @author Pwenlee
 * @date 2020/9/25 10:34
 * @description
 */
public class Q184 {
//    184. 部门工资最高的员工
//    Employee 表包含所有员工信息，每个员工有其对应的 Id, salary 和 department Id。
//
//            +----+-------+--------+--------------+
//            | Id | Name  | Salary | DepartmentId |
//            +----+-------+--------+--------------+
//            | 1  | Joe   | 70000  | 1            |
//            | 2  | Jim   | 90000  | 1            |
//            | 3  | Henry | 80000  | 2            |
//            | 4  | Sam   | 60000  | 2            |
//            | 5  | Max   | 90000  | 1            |
//            +----+-------+--------+--------------+
//    Department 表包含公司所有部门的信息。
//
//            +----+----------+
//            | Id | Name     |
//            +----+----------+
//            | 1  | IT       |
//            | 2  | Sales    |
//            +----+----------+
//    编写一个 SQL 查询，找出每个部门工资最高的员工。对于上述表，您的 SQL 查询应返回以下行（行的顺序无关紧要）。
//
//            +------------+----------+--------+
//            | Department | Employee | Salary |
//            +------------+----------+--------+
//            | IT         | Max      | 90000  |
//            | IT         | Jim      | 90000  |
//            | Sales      | Henry    | 80000  |
//            +------------+----------+--------+
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/department-highest-salary
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//    # Write your MySQL query statement below
//    select d.name `Department`, e.name `Employee`, e.salary `Salary` from
//            (select departmentId, max(salary) salary from Employee group by departmentid) temp
//    join Employee e on(e.salary = temp.salary and e.departmentid = temp.departmentid)
//    join Department d on(d.id = temp.departmentid)
}
