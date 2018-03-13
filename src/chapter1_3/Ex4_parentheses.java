package chapter1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_3
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/28/028 11:46
 * @UpdateDate: 2018/1/28/028 11:46
 */
class Ex4_parentheses {

    public static void main(String[] args) {

        String s = StdIn.readString();
        System.out.println(isPaired(s));
    }

    private static boolean isPaired(String s){
        Stack<Character> parentheses = new Stack<>();
        for (int i=0;i<s.length();i++){
            char current = s.charAt(i);
            if (current == '(' || current == '[' || current == '{')
                parentheses.push(current);
            if (current == ')' || current == ']' || current == '}'){
                if (parentheses.size() == 0)
                    return false;
                char c = parentheses.pop();
                //')' = 40 ')' = 41
                if (c == ')' && current != ')')
                    return false;
                //'[' = 91 ']'=93 '{'=123 '}'=125
                else if (current != c + 2)
                    return false;
            }
        }
        return parentheses.size() == 0;
    }
}
