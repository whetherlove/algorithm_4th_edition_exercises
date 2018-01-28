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
public class Ex9_repairExpression {

    public static void main(String[] args) {

        String test = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        System.out.println(repair(test));
    }

    public static String repair(String e){
        //仿Dijkstra法
        Stack<String> ops = new Stack<>();
        Stack<String> vals = new Stack<>();
        String[] elems = e.split(" ");
        String availableOp = "+-*/";

        for (int i=0;i<elems.length;i++){
            //用4个判断语句写的太累，此处直接调用indexOf方法
            if (availableOp.indexOf(elems[i]) > -1)
                ops.push(elems[i]);
            else if (elems[i].equals(")")){
                String op = ops.pop();
                //exp: val1 op val2
                String val2 = vals.pop();
                String val1 = vals.pop();
                //不需要运算,而是将一串整合字符串作为新操作数存入
                vals.push("( " + val1 + " " + op + " " + val2 + " )" );
            }
            else
                vals.push(elems[i]);
        }
        return vals.pop();
    }
}
