package chapter1_4;

/**
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter1_4
 * @Description:
 * @Author: Jacob Zhang
 * @CreateDate: 2018/1/31/031 15:36
 * @UpdateDate: 2018/1/31/031 15:36
 */
class StopWatch {

    private final long start;

    public StopWatch(){
        start = System.currentTimeMillis();
    }

    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
