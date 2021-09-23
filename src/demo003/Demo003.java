package demo003;

import demo003.thread.PrintWordJobC;
import demo003.thread.PrintWordJobR;
import demo003.thread.PrintWordJobT;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zhangyuhang
 * @Classname Demo003
 * @Description TODO
 * @Date 2021/8/1 21:42
 * @Created by zhangyuhang
 */
public class Demo003 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new PrintWordJobT("线程A").start();
        new PrintWordJobT("线程B").start();
        new PrintWordJobT("线程C").start();

        new Thread(new PrintWordJobR("线程1")).start();
        new Thread(new PrintWordJobR("线程2")).start();
        new Thread(new PrintWordJobR("线程3")).start();

        FutureTask<String> task = new FutureTask<>(new PrintWordJobC());
        new Thread(task).start();
        System.out.println("线程返回结果-----------:" + task.get());
    }

}
