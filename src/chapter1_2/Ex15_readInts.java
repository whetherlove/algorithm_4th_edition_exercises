package chapter1_2;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_2
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/27/027 17:27
 * @UpdateDate: 2018/1/27/027 17:27
 */
class Ex15_readInts {

    public static void main(String[] args) {
        String s = "1 2 3";
        int[] ints = readInts(s);
        for (int i: ints)
            System.out.println(i);
    }

    private static int[] readInts(String s){
        String[] words = s.split(" ");
        int[] ints = new int[words.length];
        for (int i=0;i<ints.length;i++)
            ints[i] = Integer.parseInt(words[i]);
        return ints;
    }
}
