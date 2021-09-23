package demo001;

/**
 * @author zhangyuhang
 */
public class Demo001 {
    public static void main( String [] args ){
        System.out.println(count(1000000000L));

    }

    public static long count(long n){
        if (n == 1) {
            return 1;
        }
        return n * count(n - 1);
    }
}
