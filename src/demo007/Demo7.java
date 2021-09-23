package demo007;

import java.util.function.Function;

/**
 * @author by zhangyuhang
 * @Classname Demo7
 * @Description TODO
 * @Date 2021/9/1 15:55
 */
public class Demo7 {
    public static void main(String[] args) {
        //System.out.println(measureSumperf(ParallelStreams::sequentialSum, 10_000_000));
        //System.out.println(measureSumperf(ParallelStreams::forkJoinSum, 10_000_000));
        System.out.println(ParallelStreams.forkJoinSum(100000));

    }

    public static long measureSumperf(Function<Long, Long> adder, long n){
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++){
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }
}
