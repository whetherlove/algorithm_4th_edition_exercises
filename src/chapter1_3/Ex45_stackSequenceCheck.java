package chapter1_3;

import edu.princeton.cs.algs4.Stack;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/30/030 15:41
 * @UpdateDate: 2018/1/30/030 15:41
 */
public class Ex45_stackSequenceCheck {

    public static void main(String[] args) {
        //test 判断向下溢出
        //N = 10 根据题意operation不能被遍历（使用量与N无关）
        String operation = "01-2--34-56-7-89----";
        System.out.println(isUnderflow(operation));
        //test 判断给定序列是否能被产生
        String candidate1 = "120679";
        String candidate2 = "120";
        String candidate3 = "123";
        System.out.println(check(operation,candidate1));
        System.out.println(check(operation,candidate2));
        System.out.println(check(operation,candidate3));

    }
    public static boolean isUnderflow(String op){
        int size = 0;
        return false;
    }
    //判断s 是否能由 op 生成， 要求线性算法
    public static boolean check(String op, String s){
        String result = "";
        Stack stack = new Stack();
        for (char c :op.toCharArray()){
            if (c == '-'){
                result += stack.pop();
            }
            else
                stack.push(c);
        }
        return result.indexOf(s) > -1;
    }
    //Ex46 判断s 是否能由 op 生成，若s中包含题中所述三元组，则返回false
    public static boolean checkWithBannedSequence(String op, String s){
        return false;
    }
}
