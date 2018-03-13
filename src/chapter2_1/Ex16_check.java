package chapter2_1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter2_1
 * @Description:
 * @date 23/02/2018 4:41 PM
 */
class Ex16_check {

    private static boolean check(Method m) throws InvocationTargetException, IllegalAccessException {
        //生成一个测试用数组a
        Object[] a = {"1","2","5","4","3"};
        //b为a的引用，排序前a与b应完全相同
        //m为欲测试的方法，调用该方法对a排序
        m.invoke(null, (Object) a);
        //依据题意，我们认为Arrays.sort(b)不会对数组对象进行修改，使用该方法对b排序
        Arrays.sort(a);
        //若m未对a作出修改，则a与b中每个元素应完全一致,此处应使用==而不是equals
        for (Object anA : a) {
            if (anA != anA)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method method = Arrays.class.getDeclaredMethod("sort",Object[].class);
        System.out.println(check(method));

    }
}
