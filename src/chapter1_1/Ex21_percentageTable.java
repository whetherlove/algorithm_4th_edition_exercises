package chapter1_1;

import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/23/023 17:34
 * @UpdateDate: 2018/1/23/023 17:34
 */
class Ex21_percentageTable {

    public static void main(String[] args) {

        ArrayList<String> content = new ArrayList<>();
        while (true){
             String line = StdIn.readLine();
             if (line.length() == 0) break;
             content.add(line);
        }
        for (String entry: content){
            String[] info = entry.split(" ");
            double percent = Double.parseDouble(info[1]) /  Double.parseDouble(info[2]);
            System.out.printf("%s %.3f",entry,percent);
        }
    }
}
