package chapter1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/28/028 9:56
 * @UpdateDate: 2018/1/28/028 9:56
 */
public class DijkstraEvaluate {

    public static void main(String[] args) {

        Stack<String> operations = new Stack<>();
        Stack<Double> values = new Stack<>();

        while (!StdIn.isEmpty()){
            String s = StdIn.readString();
            if (    s.equals("+") ||
                    s.equals("-") ||
                    s.equals("*") ||
                    s.equals("/") ||
                    s.equals("sqrt"))
                operations.push(s);
            else if (s.equals("("));
            else if (s.equals("end"))
                break;
            else if (s.equals(")")){
                String op = operations.pop();
                double v = values.pop();
                switch (op){
                    case "+":
                        v = values.pop() + v;
                        break;
                    case "-":
                        v = values.pop() - v;
                        break;
                    case "*":
                        v = values.pop() * v;
                        break;
                    case "/":
                        v = values.pop() / v;
                        break;
                    case "sqrt":
                        v = Math.sqrt(v);
                        break;
                }
                values.push(v);
            }
            else
                values.push(Double.parseDouble(s));
        }
        System.out.println(values.pop());
    }
}
