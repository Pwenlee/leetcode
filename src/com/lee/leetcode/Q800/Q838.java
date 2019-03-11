package com.lee.leetcode.Q800;

import java.util.Objects;

/**
 * @author Pwenlee
 * @date 2019/2/20 20:37
 * @description
 */
public class Q838 {

//    一行中有 N 张多米诺骨牌，我们将每张多米诺骨牌垂直竖立。
//
//    在开始时，我们同时把一些多米诺骨牌向左或向右推。
//
//    每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。
//
//    同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
//
//    如果同时有多米诺骨牌落在一张垂直竖立的多米诺骨牌的两边，由于受力平衡， 该骨牌仍然保持不变。
//
//    就这个问题而言，我们会认为正在下降的多米诺骨牌不会对其它正在下降或已经下降的多米诺骨牌施加额外的力。
//
//    给定表示初始状态的字符串 "S" 。如果第 i 张多米诺骨牌被推向左边，则 S[i] = 'L'；如果第 i 张多米诺骨牌被推向右边，则 S[i] = 'R'；如果第 i 张多米诺骨牌没有被推动，则 S[i] = '.'。
//
//    返回表示最终状态的字符串。
//
//    示例 1：
//
//    输入：".L.R...LR..L.."
//    输出："LL.RR.LLRRLL.."
//    示例 2：
//
//    输入："RR.L"
//    输出："RR.L"
//    说明：第一张多米诺骨牌没有给第二张施加额外的力。
//    提示：
//
//            0 <= N <= 10^5
//    表示多米诺骨牌状态的字符串只含有 'L'，'R'; 以及 '.';

    public static String pushDominoes(String dominoes) {
        if(Objects.isNull(dominoes) || dominoes.length() <= 1){
            return dominoes;
        }
        String result  = change(dominoes);
        while(!result.equals(dominoes)){
            dominoes = result;
            result = change(result);
        }
        char[] chars = result.toCharArray();
        if(chars[0] == '.' && chars[1] == 'L'){
            chars[0] = 'L';
        }
        if(chars[chars.length-1] == '.' && chars[chars.length-2] == 'R'){
            chars[chars.length-1] = 'R';
        }
        return new String(chars);
    }

    private static String change(String old){
        char[] target = old.toCharArray();
        char[] origin = old.toCharArray();
        for(int i=1; i<=target.length-2; i++){
            if(origin[i] == 'L' && origin[i-1] == '.'){
                if(i == 1){
                    target[0] = 'L';
                }else{
                    if(origin[i-2] != 'R'){
                        target[i-1] = 'L';
                    }
                }
            }

            if(origin[i] == '.'){
                if(origin[i+1] == 'L' && origin[i-1] != 'R'){
                    target[i] = 'L';
                }else if(origin[i-1] == 'R' && origin[i+1] != 'L'){
                    target[i] = 'R';
                }
            }

            if(origin[i] == 'R' && origin[i+1] == '.'){
                if(i == origin.length-2){
                    target[target.length-1] = 'R';
                }else{
                    if(origin[i+2] != 'L'){
                        target[i+1] = 'R';
                    }
                }
            }
        }
        return new String(target);
    }

    public static void main(String[] args) {
        System.out.println(pushDominoes("R.R.L"));
    }
}
