package chapter1_4;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/2/3/003 15:45
 * @UpdateDate: 2018/2/3/003 15:45
 */
public class Ex19_localMin2d {

    public static void main(String[] args) {

        int a[] = {1,4,7,3,9,6,6,8,54,7,3};
        System.out.println(a[localMin(a)]);
    }
    public static int localMin(int[] a){
        int mid = a.length / 2;
        return localMin(a,mid);
    }
    public static int localMin(int[] a, int mid) {
        if (mid == 0 || mid == a.length - 1) return -1;
        else if (a[mid] < a[mid - 1] && a[mid] < a[mid + 1])
            return mid;
        else {
            int lo = mid / 2;
            int hi = (a.length - mid) / 2 + mid;
            return localMin(a,lo) == -1 ? localMin(a,hi):localMin(a,lo);
        }
    }
}
