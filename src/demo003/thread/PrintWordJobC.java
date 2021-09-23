package demo003.thread;

import java.util.concurrent.Callable;

/**
 * @Classname PrintThreadC
 * @Description TODO
 * @Date 2021/8/1 22:16
 * @Created by zhangyuhang
 */
public class PrintWordJobC implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++){
            System.out.println("线程执行------------>" + i);
        }
        return "线程执行完毕";
    }
}
