package demo006;

/**
 * @author by zhangyuhang
 * @Classname Demo006
 * @Description TODO
 * @Date 2021/8/27 17:21
 */
public class Demo006 {
    volatile int a = 1;
    volatile int b = 1;

    public void add() {
        System.out.println("add start");
        for (int i = 0; i < 100000; i++) {
            a++;
            b++;
            System.out.println("add done");
        }
    }
    public void compare(){
        System.out.println("compare start");
        for (int i = 0; i < 10000;i++) {
            //a始终等于b吗？
            if (a < b){
                System.out.println("a: "+ a + ", b: " + b + ", c: " + (a > b) );
            //最后的a>b应该始终是false吗？
            }
            else if (a > b){
                System.out.println("a: "+ a + ", b: " + b + ", c: " + (a < b) );
            }
            else{
                System.out.println("a: "+ a + ", b: " + b + ", c: " + (a != b) );
            }
        }
        System.out.println("compare done");
    }

    public static void main(String[] args) {
        Demo006 demo006 = new Demo006();
        new Thread(() -> demo006.compare()).start();
        new Thread(() -> demo006.add()).start();
    }

}
