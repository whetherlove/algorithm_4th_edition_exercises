package chapter1_4;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/2/2/002 16:44
 * @UpdateDate: 2018/2/2/002 16:44
 */
public class Ex18_localMin {

    public static void main(String[] args) {

//        题目给出的思路感觉有问题，比如以下这个数组，局部最小为a[3] = 3
//        按照题目思路 N = a.length / 2 = 5. 由于a[5] = 6 不满足题意
//        又有a[4] = 9 > a[6] = 6, 则应向a[5]右侧进行查找
//        之后a[mid]依次等于54，7，3，最终返回结果为没有局部最小
//        正确解法应对数组左右两侧均使用二分法
//        以下数组有且仅有一个局部最小 a[3] = 3
        int a[] = {1,4,7,3,9,6,6,8,54,7,3};
        System.out.println(a[localMin(a)]);
    }

    public static int localMin(int[] a){
        int lo = 0;
        int hi = a.length - 1;
        return localMin(a,lo,hi);
    }
    public static int localMin(int[] a, int lo, int hi) {
        int mid = (hi - lo) / 2 + lo;
        if (mid == lo || mid == hi) return -1;
        else if (a[mid] < a[mid - 1] && a[mid] < a[mid + 1])
            return mid;
        else {
            return localMin(a,lo,mid) == -1 ? localMin(a,mid,hi):localMin(a,lo,mid);
        }
    }
}
