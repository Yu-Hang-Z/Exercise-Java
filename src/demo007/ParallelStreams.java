package demo007;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author by zhangyuhang
 * @Classname ParallelStreams
 * @Description TODO
 * @Date 2021/9/1 16:39
 */
public class ParallelStreams {
    public static long sequentialSum(long n){
        return LongStream.rangeClosed(1,n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    /*public static long parallelSum(long n){
    }*/

    public static long sideEffectParallelSum (long n){
        Accumulator aceumulator = new Accumulator ();
        LongStream.rangeClosed(1, n)
                .parallel()
                .forEach (aceumulator :: add);
        return aceumulator.total;
    }

    public static class Accumulator {
        public long total = 0;

        public void add(long value) {
            total += value;
        }
    }

    public static long forkJoinSum(long n){
        long [] numbers = LongStream.rangeClosed(1,n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumTask(numbers);
        return new ForkJoinPool().invoke(task);
    }

}
