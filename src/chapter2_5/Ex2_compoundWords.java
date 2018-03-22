package chapter2_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_5
 * @Description:
 * @date 13/03/2018 2:07 PM
 */
public class Ex2_compoundWords {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");

        Arrays.sort(words);
        for (int i = 0; i < words.length; i++)
            for (int j = i+1; j < words.length; j++)
                if (Arrays.binarySearch(words,words[i]+words[j]) > -1)
                    System.out.println(words[i]+words[j]);






    }
}
