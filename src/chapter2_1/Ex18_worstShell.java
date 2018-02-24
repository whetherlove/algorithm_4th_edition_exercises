package chapter2_1;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_1
 * @Description:
 * @date 24/02/2018 2:24 PM
 */
public class Ex18_worstShell {

    //返回值为总比较次数统计
    public static int sort(int[] a){
        int time = 0;
        int h = 1;
        while (h < a.length/3)
            h = h*3 + 1;
        while (h >=1 ){
            for (int i = h; i < a.length ; i++) {
                for (int j = i; j >=h && a[j] < a[j-h]; j-=h) {
                        time++;
                        int temp = a[j];
                        a[j] = a[j-h];
                        a[j-h] = temp;
                }
                time++;
            }
            h /= 3;
        }
        return time;
    }

    public static void main(String[] args) {
        //理论上最大比较次数为 n^(3/2)
        //完全逆序的数组 比较次数为572
        int[] a = new int[100];
        for (int i = 0; i < 100; i++) {
            a[i] = 100-i;
        }
        System.out.println(sort(a));
    }
}
