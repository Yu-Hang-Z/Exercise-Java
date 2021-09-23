package demo010;

import static jdk.nashorn.internal.objects.NativeFunction.function;

/**
 * @author by zhangyuhang
 * @Classname Demo010
 * @Description TODO
 * @Date 2021/9/17 10:09
 */
public class Demo010 {
    public static void main(String[] args) {
        Integer a = new Integer(300);
        function(a);
        System.out.println(a);
    }

    public static void function(Integer a){
        int b = 5;
        a = b + a;
    }
}
