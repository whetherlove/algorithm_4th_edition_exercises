
import java.io.*;
import java.util.Arrays;


/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: PACKAGE_NAME
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/24/024 15:33
 * @UpdateDate: 2018/1/24/024 15:33
 */
@SuppressWarnings("EmptyMethod")
class test{

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int[][] a = {{1,2},{3,4}};
        int[][] b = {{1,2},{3,4}};
        System.out.println(Arrays.equals(a,b));
        System.out.println(Arrays.deepEquals(a,b));
    }


}
