package demo003.thread;

/**
 * @Classname MyThread
 * @Description TODO
 * @Date 2021/8/1 21:58
 * @Created by zhangyuhang
 */
class TicketThread implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true){
            if (this.ticket > 0){
                System.out.println("卖票，ticket = " + this.ticket--);
            }
            else {
                break;
            }
        }

    }
}
public class MyThread{
    public static void main(String[] args) {
        TicketThread ticketThread = new TicketThread();
        new Thread(ticketThread).start();
        new Thread(ticketThread).start();
        new Thread(ticketThread).start();

    }

}
