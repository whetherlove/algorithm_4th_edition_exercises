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
class Ex45_stackSequenceCheck {

    public static void main(String[] args) {
        //test
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
    //判断给定序列是否会导致数组向下溢出，要求使用空间量与N无关
    private static boolean isUnderflow(String op){
        int size = 0;
        int tail = 0;
        while (tail<op.length()){
            size += op.charAt(tail) == '-'?-1:1;
            if (size<0)
                return true;
            tail++;
        }
        return false;
    }
    //判断s 是否能由 op 生成， 要求线性算法 O(n) = N
    @SuppressWarnings("unchecked")
    private static boolean check(String op, String s){
        StringBuilder result = new StringBuilder();
        Stack stack = new Stack();
        for (char c :op.toCharArray()){
            if (c == '-'){
                result.append(stack.pop());
            }
            else
                stack.push(c);
        }
        return result.toString().contains(s);
    }
    //Ex46 判断s 是否能由 op 生成，若s中包含题中所述三元组，则返回false
    //由于序列中数字的入栈顺序固定(0,1,2,...,N),若栈中存在这样的数组，
    //c>b>a， c入栈时a,b已在栈中， 则b必定会在a之后入栈，亦即b必定会在a之前出栈
    @SuppressWarnings("SameReturnValue")
    public static boolean checkWithBannedSequence(String op, String s){
        return false;
    }
}
