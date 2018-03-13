package chapter1_4;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @date 5/02/2018 10:20 AM
 */
@SuppressWarnings("UnusedAssignment")
class Ex22_MihaiPatrascu {

    public static void main(String[] args) {

        int[] a = {1,2,3,4,5,6,7,8,9};
        System.out.println(mihaiPatrascu(a,2));
        System.out.println(mihaiPatrascu(a,0));
    }

    private static boolean mihaiPatrascu(int[] a, int key){
        int fn = 1;
        int fn_1 = 1;
        int fn_2 = 0;
        //找到fibonacci数列中大于数列a长度的最小项fn
        while(fn < a.length){
            fn = fn + fn_1;
            fn_1 = fn_1 + fn_2;
            fn_2 = fn - fn_1;
        }

        int lo = 0;
        int current = 0;
        while (fn_2 > 0){
            current = lo + fn_2 > a.length -1 ? a.length - 1 : lo + fn_2;
            if (a[current] == key)
                return true;
            else if (a[current] < key){
                lo = fn_2;
            }
            fn = fn_1;
            fn_1 = fn_2;
            fn_2 = fn - fn_1;
        }
        return false;
    }
}
