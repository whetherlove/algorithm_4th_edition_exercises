package chapter1_4;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/2/2/002 15:44
 * @UpdateDate: 2018/2/2/002 15:44
 */
public class Ex15_3sumFaster {

    public static void main(String[] args) {

        int[] a = {-7,-3,2,3,5,10};
        int count = 0;
        //2-sum fast complexity:N
        for (int i=0,j=a.length-1;i<j;){
            if (a[i] + a[j] == 0){
                count++;
                i++;
                j--;
                continue;
            }
            if (a[i] +a[j] < 0){
                i++;
                continue;
            }
            if (a[i] + a[j] > 0){
                j--;
                continue;
            }
        }
        System.out.println(count);

        //3-sum fast complexity:N^2
        count = 0;
        for (int k=0;k<a.length;k++)
            for (int m=k+1,n=a.length-1;m<n;){
                if (a[m] + a[n] == -a[k]){
                    count++;
                    m++;
                    n--;
                    continue;
                }
                if (a[m] +a[n] < -a[k]){
                    m++;
                    continue;
                }
                if (a[m] + a[n] > -a[k]){
                    n--;
                    continue;
                }
            }
        System.out.println(count);

    }
}
