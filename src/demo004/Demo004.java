package demo004;

/**
 * @author by zhangyuhang
 * @Classname demo4
 * @Description TODO
 * @Date 2021/8/4 13:17
 * @Created by zhangyuhang
 */
public class Demo004 {

}
class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        printClassInfo("".getClass());
        printClassInfo(Runnable.class);
        printClassInfo(java.time.Month.class);
        printClassInfo(String[].class);
        printClassInfo(int.class);
        System.out.println("---------"+"".getClass().newInstance());
    }

    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }
}
