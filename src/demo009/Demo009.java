package demo009;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by zhangyuhang
 * @Classname Demo009
 * @Description TODO
 * @Date 2021/9/16 13:57
 */
public class Demo009 {
    public static void main(String[] args) {
        for(int i = 0; i <= 100000;i++){
            for (int j = 0; j < 100000; j++ ){
                Map<Double, Integer> map = new HashMap<>();
                if (map.containsKey(Math.pow(i,2)+j)) {
                    map.put(Math.pow(i,2)+j,1);
                } else {
                    System.out.println("i:" + i + "j:"+j);
                    break;
                }
                System.out.println("j:" + j);
            }
            System.out.println("i:" + i);
        }
        System.out.println("运行结束");
    }
}
