package chapter1_3;

import edu.princeton.cs.algs4.Stack;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/28/028 14:32
 * @UpdateDate: 2018/1/28/028 14:32
 */
class Ex10_infixTopPostfix {

    public static void main(String[] args) {

        String s = "( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )";
        System.out.println(infixTopPostfix(s));
    }
    private static String infixTopPostfix(String s){
        StringBuilder postfix = new StringBuilder();
        String[] elems = s.split(" ");
        Stack<String> stack = new Stack<>();
        String availableOp = "+-*/";

        for (String e : elems) {
            if (availableOp.contains(e))
                stack.push(e);
            else if (e.equals(")"))
                postfix.append(stack.pop()).append(")");
            else
                postfix.append(e);
        }
        return postfix.toString();
    }
}
