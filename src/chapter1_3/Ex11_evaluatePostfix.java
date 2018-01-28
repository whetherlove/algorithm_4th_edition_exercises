package chapter1_3;

import edu.princeton.cs.algs4.Stack;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/28/028 14:49
 * @UpdateDate: 2018/1/28/028 14:49
 */
public class Ex11_evaluatePostfix {

    public static void main(String[] args) {

        String s = "( ( 1 2 + ) ( ( 3 4 - ) ( 5 6 - ) * ) * )";
        System.out.println(evaluatePostfix(s));
    }

    public static double evaluatePostfix(String s){
        String[] elems = s.split(" ");
        Stack<String> stack = new Stack();

        for (int i=0; i<elems.length;i++){
            String e = elems[i];
            if (e.equals("("));
            else if (e.equals(")")){
                String op = stack.pop();
                double val2 = Double.parseDouble(stack.pop());
                double val1 = Double.parseDouble(stack.pop());
                double result = 0;
                switch (op){
                    case "+":
                        result = val1 + val2;
                        break;
                    case "-":
                        result = val1 - val2;
                        break;
                    case "*":
                        result = val1 * val2;
                        break;
                    case "/":
                        result = val1 / val2;
                        break;
                }
                stack.push(result + "");
            }
            else
                stack.push(e);
        }
        return Double.parseDouble(stack.pop());
    }
}
