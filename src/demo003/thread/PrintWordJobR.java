package demo003.thread;

/**
 * @Classname PrintWordJobR
 * @Description TODO
 * @Date 2021/8/1 21:45
 * @Created by zhangyuhang
 */
public class PrintWordJobR implements Runnable{
    private String title;
    public PrintWordJobR(){}
    public PrintWordJobR(String title){
        this.title = title;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++ ){
            System.out.println(this.title + "---------------->" + i);
        }
    }
}
