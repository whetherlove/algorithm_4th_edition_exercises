package chapter1_3;

import edu.princeton.cs.algs4.Stack;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/28/028 12:27
 * @UpdateDate: 2018/1/28/028 12:27
 */
@SuppressWarnings("SameParameterValue")
class Ex5_toBinaryString {

    public static void main(String[] args) {

        toBinary(50);
    }

    private static void toBinary(int n){
        Stack<Integer> stack = new Stack<>();
        while (n>0){
            stack.push(n%2);
            n /= 2;
        }
        for (int i : stack)
            System.out.print(i);
    }
}
