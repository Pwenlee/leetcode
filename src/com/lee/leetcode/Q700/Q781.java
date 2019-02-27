package com.lee.leetcode.Q700;

import java.util.*;

/**
 * @author lipan
 * @date 2019/2/27 16:29
 * @description
 */
public class Q781 {

//    781. 森林中的兔子
//    森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
//
//    返回森林中兔子的最少数量。
//
//    示例:
//    输入: answers = [1, 1, 2]
//    输出: 5
//    解释:
//    两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
//    之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
//    设回答了 "2" 的兔子为蓝色。
//    此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
//    因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
//
//    输入: answers = [10, 10, 10]
//    输出: 11
//
//    输入: answers = []
//    输出: 0
//    说明:
//
//    answers 的长度最大为1000。
//    answers[i] 是在 [0, 999] 范围内的整数。

    public static int numRabbits(int[] answers) {
        if(Objects.isNull(answers) || answers.length == 0){
            return 0;
        }
        if(answers.length == 1){
            return 1+answers[0];
        }
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == 0){
                result = result + 1;
            }else if(!map.containsKey(answers[i])){
                map.put(answers[i], 1);
            }else{
                int time = map.get(answers[i]);
                time = time + 1;
                map.put(answers[i], time);
            }
        }
        for (Integer key : map.keySet()) {
            int value = map.get(key);
            if(value < key + 1){
                result = result + 1 + key;
            }else{
                if(value % (key + 1) == 0){
                    result = result + (value / (key + 1)) * (key + 1);
                }else{
                    result = result + (value / (key + 1) + 1) * (key + 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numRabbits(new int[]{2,1,2,2,2,2,2,2,1,1}));
    }
}
