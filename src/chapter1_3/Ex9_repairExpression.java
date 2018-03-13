package chapter1_3;

import edu.princeton.cs.algs4.Stack;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/28/028 12:44
 * @UpdateDate: 2018/1/28/028 12:44
 */
class Ex9_repairExpression {

    public static void main(String[] args) {

        String test = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        System.out.println(repair(test));
    }

    private static String repair(String e){
        //仿Dijkstra法
        Stack<String> ops = new Stack<>();
        Stack<String> vals = new Stack<>();
        String[] elems = e.split(" ");
        String availableOp = "+-*/";

        for (String elem : elems) {
            //用4个判断语句写的太累，此处直接调用indexOf方法
            if (availableOp.contains(elem))
                ops.push(elem);
            else if (elem.equals(")")) {
                String op = ops.pop();
                //exp: val1 op val2
                String val2 = vals.pop();
                String val1 = vals.pop();
                //不需要运算,而是将一串整合字符串作为新操作数存入
                vals.push("( " + val1 + " " + op + " " + val2 + " )");
            } else
                vals.push(elem);
        }
        return vals.pop();
    }
}
