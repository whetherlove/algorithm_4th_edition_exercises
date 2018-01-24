package chapter1_1;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_1
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/24/024 16:15
 * @UpdateDate: 2018/1/24/024 16:15
 */
public class Ex33_matrix {

    /**
     *此代码来自https://github.com/jimmysuncpt/Algorithms/blob/master/src/com/jimmysun/algorithms/chapter1_1/Matrix.java
     * Author: JimmySun
     */

    public static double dot(double[] x, double[] y) {
        double result = 0;
        if (x.length == y.length) {
            for (int i = 0; i < y.length; i++) {
                result += x[i] * y[i];
            }
            return result;
        } else {
            System.out.println("Error!");
            return result;
        }
    }

    public static double[][] mult(double[][] a, double[][] b) {
        if (a[0].length == b.length) {
            double[][] s = new double[a.length][b[0].length];
            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < s[i].length; j++) {
                    for (int k = 0; k < b.length; k++) {
                        s[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
            return s;
        } else {
            System.out.println("Error!");
            return null;
        }
    }

    public static double[][] transpose(double[][] a) {
        double[][] s = new double[a[0].length][a.length];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                s[i][j] = a[j][i];
            }
        }
        return s;
    }

    public static double[] mult(double[][] a, double[] x) {
        if (a[0].length == x.length) {
            double[] y = new double[a.length];
            for (int i = 0; i < y.length; i++) {
                for (int j = 0; j < x.length; j++) {
                    y[i] += a[i][j] * x[j];
                }
            }
            return y;
        } else {
            return null;
        }
    }

    public static double[] mult(double[] y, double[][] a) {
        if (y.length == a.length) {
            double[] x = new double[a[0].length];
            for (int i = 0; i < x.length; i++) {
                for (int j = 0; j < y.length; j++) {
                    x[i] += y[j] * a[j][i];
                }
            }
            return x;
        } else {
            return null;
        }
    }
}
