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
class DijkstraEvaluate {

    public static void main(String[] args) {

        Stack<String> operations = new Stack<>();
        Stack<Double> values = new Stack<>();

        label:
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            switch (s) {
                case "+":
                case "-":
                case "*":
                case "/":
                case "sqrt":
                    operations.push(s);
                    break;
                case "(":
                    break;
                case "end":
                    break label;
                case ")":
                    String op = operations.pop();
                    double v = values.pop();
                    switch (op) {
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
                    break;
                default:
                    values.push(Double.parseDouble(s));
                    break;
            }
        }
        System.out.println(values.pop());
    }
}
