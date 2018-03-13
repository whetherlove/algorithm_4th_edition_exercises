package chapter1_1;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/24/024 11:45
 * @UpdateDate: 2018/1/24/024 11:45
 */
class Ex29_binarySearchWithRankAndCount {

    public static void main(String[] args) {

        int[] a = {1,2,3,3,3,3,5,6,7};
        int[] single = {1};

        //System.out.println(rank(2,single));
        //System.out.println(rank(4,a));

        System.out.println(count(1,a));
        System.out.println(count(3,a));
    }

    public static int rank(int key, int[] a){
        int lo = 0;
        int hi = a.length-1;
        //如果a中只有一个元素，则不存在a[mid+1]
        if (hi == 0) return key>a[hi]?1:0;
        if (key > a[hi]) return a.length;
        if (key <= a[lo]) return 0;
        return rank(key,a,lo,hi);
    }

    private static int rank(int key, int[] a, int lo, int hi){
        int mid = lo + (hi-lo)/2;
        //key可能不属于a，此处不能用key==a[mid]作为条件
        if (key>a[mid] && key<=a[mid+1]) return mid+1;
        else if (key > a[mid]) return rank(key,a,mid+1,hi);
        else if (key <= a[mid]) return rank(key,a,lo,mid-1);
        return 0;
    }

    private static int count(int key, int[] a){
        return count(key,a,0,a.length-1);
    }

    private static int count(int key, int[] a, int lo, int hi){
        if (lo > hi) {
            System.out.println("lo>hi");
            return 0;
        }
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return count(key,a,lo,mid-1);
        else if (key > a[mid]) return count(key,a,mid+1,hi);
        //当key == a[mid]时，向左右依次查询是否为同一数字
        else {
            int count = 1;
            int rpos = mid+1;
            if (mid != a.length-1)
                while (key == a[rpos]){
                    rpos++;
                    count++;
                }
            int lpos = mid-1;
            if (mid != 0){
                while (key == a[lpos]) {
                    lpos--;
                    count++;
                }
            }
            return count;
        }
    }

}
