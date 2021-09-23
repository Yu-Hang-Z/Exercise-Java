package demo004.reflection;

import java.lang.reflect.Field;

/**
 * @author by zhangyuhang
 * @Classname exercise
 * @Description TODO
 * @Date 2021/8/5 10:11
 */
public class Exercise {

}
class Main {
    public static void main(String[] args) throws Exception {
        //Class stdClass = Student.class;
        Object student = new Student("zhang",90,90);
        Class cls = student.getClass();
        Field field = cls.getDeclaredField("name");
        field.setAccessible(true);
        Object value = field.get(student);
        if(!"ZhangYuHang".equals(value)){
            field.set(student,"ZhangYuHang");
        }
        System.out.println(student.toString());
        /*// 获取public字段"score":
        System.out.println(stdClass.getField("score"));
        // 获取继承的public字段"name":
        System.out.println(stdClass.getField("name"));
        // 获取private字段"grade":
        System.out.println(stdClass.getDeclaredField("grade"));*/
    }
}

class Student extends Person {
    public int score;
    private int grade;
    private String name;
    public Student(){}
    public Student(String name,int score,int grade){
        this.name = name;
        this.grade = grade;
        this.score = score;
    }
    public String getName() {
        return this.name;
    }
    @Override
    public String toString(){
        return this.name + this.score + this.grade;
    }
}

class Person {
    public String name;
}

