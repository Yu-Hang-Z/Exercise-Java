package demo007;

import java.util.concurrent.RecursiveTask;

/**
 * @author by zhangyuhang
 * @Classname ForkJoinSum
 * @Description TODO
 * @Date 2021/9/2 14:18
 */
public class ForkJoinSumTask extends RecursiveTask<Long> {
    private final long [] numbers;
    private final int start;
    private final int end;
    private static final long THRESHOLD = 10000;

    public ForkJoinSumTask(long [] numbers){
        this(numbers,0,numbers.length);
    }
    private ForkJoinSumTask(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD){
            return computeSequentially();
        }
        ForkJoinSumTask leftTask = new ForkJoinSumTask(numbers, start,start + length/2);
        leftTask.fork();
        ForkJoinSumTask rightTask = new ForkJoinSumTask(numbers,start + length/2, end);
        Long rightResult = rightTask.compute();
        Long leftResult = rightTask.join();
        return leftResult + rightResult;
    }

    private long computeSequentially(){
        long sum = 0;
        for (int i = start; i < end; i++){
            sum += numbers[i];
        }
        return sum;
    }
}
