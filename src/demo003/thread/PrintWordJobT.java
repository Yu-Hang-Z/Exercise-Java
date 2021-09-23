package demo003.thread;

/**
 * @Classname PrintWordJob
 * @Description TODO
 * @Date 2021/8/1 21:39
 * @Created by zhangyuhang
 */

public class PrintWordJobT extends Thread{
    private String title;
    public PrintWordJobT(){}
    public PrintWordJobT(String title){
        this.title = title;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++ ){
            System.out.println(this.title + "---------------->" + i);
        }
    }
}
