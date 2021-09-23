package demo003.thread;

/**
 * @author by zhangyuhang
 * @Classname Main
 * @Description TODO
 * @Date 2021/8/2 15:13
 * @Created by zhangyuhang
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Thread add = new AddThread();
        Thread dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);
    }
}

class Counter {
    public static int count = 0;
    public static final Object lock = new Object();
}

class AddThread extends Thread {
    @Override
    public void run() {
        synchronized (Counter.lock){
            for (int i=0; i<10000; i++) { Counter.count += 1; }
        }
    }
}

class DecThread extends Thread {
    @Override
    public void run() {
        synchronized (Counter.lock){
            for (int i=0; i<10000; i++) { Counter.count -= 1; }
        }
    }
}
