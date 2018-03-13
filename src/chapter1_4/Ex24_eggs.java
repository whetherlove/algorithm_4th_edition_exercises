package chapter1_4;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @date 5/02/2018 12:16 PM
 */
class Ex24_eggs {

    private static int findFLgN(boolean[] floors){
        int lo = 0;
        int hi = floors.length - 1;
        while (lo < hi){
            int mid = (hi - lo) / 2 + lo;
            //noinspection PointlessBooleanExpression
            if (floors[mid] == false)
                lo = mid + 1;
            else {
                hi = mid;
            }
        }
        //noinspection PointlessBooleanExpression
        return floors[hi] == true ? hi : -1;
    }

    private static int findF2LgF(boolean[] floors){
        //~lgF
        int f = 1;
        //noinspection PointlessBooleanExpression
        while (f < floors.length && floors[f-1] != true)
                f *= 2;
        //lgF
        int lo = Math.max(f / 2 - 1,0);
        int hi = Math.min(f-1,floors.length-1);
        while (lo < hi){
            int mid = (hi - lo) / 2 + lo;
            //noinspection PointlessBooleanExpression
            if (floors[mid] == false)
                lo = mid + 1;
            else {
                hi = mid;
            }
        }
        //noinspection PointlessBooleanExpression
        return floors[hi] == true ? hi : -1;
    }
    //Ex25 2 eggs ~2sqrt(N)
    private static int findFSqrtN(boolean[] floors){
        //sqrt(N)
        int sqrtN = (int)Math.sqrt(floors.length);
        int f = 0;
        //noinspection PointlessBooleanExpression
        while (f < floors.length && floors[f] != true)
            f += sqrtN;
        //sqrt(N)
        int lo = Math.max(f - sqrtN, 0);
        int hi = Math.min(f,floors.length-1);
        for (int i=lo;i<=hi;i++){
            //noinspection PointlessBooleanExpression
            if (floors[i] == true)
                return i;
        }
        return -1;
    }
    //Ex25 2 eggs ~csqrt(F)
    //由于只有2个鸡蛋，最多尝试失败2次
    //由于F未知，需要通过第一次尝试确定一个小范围，第二次尝试确定具体值
    //则需构造一个递增数列，其函数满足
    //当f(n）> F && f(n-1) < F时，
    //第一次尝试的次数为n次,
    //第二次尝试的最多次数为 f(n）- f(n-1) - 1次
    //即 n + f(n）- f(n-1) - 1 ~ csqrt(F)
    //由于f(n）> F && f(n-1) < F
    //该条件可以转化为 c*sqrt(f(n-1)) < n + f(n）- f(n-1) - 1 <c*sqrt(f(n))
    //可以找到这样一个数列 1 3 6 10 15 21 28 36 45 55 66 78 91 105 （等差数列和）
    //f(n) = n*(n+1)/2       f(n) - f(n-1) = n
    //有  n + f(n）- f(n-1) - 1  =  2n - 1
    //令c = 16， 有4(n-1)n < (2n-1)^2 < 4n(n+1)
    //即 n + f(n）- f(n-1) - 1 ~ csqrt(F)
    //若要求c尽量小，可令f(n) = 4n(n+1) 则c = 1
    private static int findFSqrtF(boolean[] floors){
        int N = 1;
        int f = (1 + N) * N / 2 - 1;
        //noinspection PointlessBooleanExpression
        while (f < floors.length && floors[f] != true){
            N++;
            f = (1 + N) * N / 2 - 1;
        }
        int lo = Math.max(N * (N - 1) / 2, 0);
        int hi = Math.min(f,floors.length-1);
        for (int i=lo;i<=hi;i++){
            //noinspection PointlessBooleanExpression
            if (floors[i] == true)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        boolean[] floors = {false,false,false,false,true,true,true};
        boolean[] floors2 = {true,true,true,true,true,true,true,true};
        boolean[] floors3 = {false,false,false,false,false,false,false};
        //~lgN
        System.out.println(findFLgN(floors));
        System.out.println(findFLgN(floors2));
        System.out.println(findFLgN(floors3));
        //~2lgF
        System.out.println(findF2LgF(floors));
        System.out.println(findF2LgF(floors2));
        System.out.println(findF2LgF(floors3));
        //Ex25 2 eggs ~2sqrt(N)
        System.out.println(findFSqrtN(floors));
        System.out.println(findFSqrtN(floors2));
        System.out.println(findFSqrtN(floors3));
        //Ex25 2 eggs ~16sqrt(F)
        System.out.println(findFSqrtF(floors));
        System.out.println(findFSqrtF(floors2));
        System.out.println(findFSqrtF(floors3));
    }
}
