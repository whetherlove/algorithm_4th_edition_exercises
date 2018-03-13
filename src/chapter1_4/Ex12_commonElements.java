package chapter1_4;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/2/2/002 14:54
 * @UpdateDate: 2018/2/2/002 14:54
 */
class Ex12_commonElements {

    public static void main(String[] args) {
        //test commonElements = 3,4,5,7,10
        int[] a = {1,3,4,5,7,9,10};
        int[] b = {3,4,5,6,7,8,10};

        for (int i=0,j=0;i<a.length && j<b.length;){
            if (a[i] == b[j]){
                System.out.println(a[i]);
                i++;
                j++;
                continue;
            }
            if (a[i] < b[j]){
                i++;
                continue;
            }
            if (a[i] > b[j]){
                j++;
            }
        }

    }
}
