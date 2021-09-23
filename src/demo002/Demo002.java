package demo002;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangyuhang
 */
public class Demo002 {
    public static <Task> void main(String[] args) throws InterruptedException {
        //Timer timer = new Timer();
        //org.apache.commons.lang3.concurrent.BasicThreadFactory
//        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
//                new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
//        executorService.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                //do something
//            }
//        },initialDelay,period, TimeUnit.HOURS);
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(5);
        for (int i = 0 ; i < 5 ; i++){
            Demo002.Task task = new Demo002.Task("task-"+i);
            executorService.scheduleAtFixedRate(task,0,5,TimeUnit.SECONDS);

        }
        Thread.sleep(100000);

        System.out.println("Shutting down executor...");
        // 关闭线程池
        executorService.shutdown();
        boolean isDone;
        // 等待线程池终止
        do {
            isDone = executorService.awaitTermination(1, TimeUnit.DAYS);
            System.out.println("awaitTermination...");
        } while(!isDone);
        System.out.println("Finished all threads");

        /*timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时器执行！！！");
            }
        },1000);*/
    }
    static class Task implements Runnable{
        private String s;
        public Task(String s){
            this.s = s;
        }
        @Override
        public void run() {
            System.out.println(this.s  + "被执行");
        }
    }
}
