package demo008;

/**
 * @author by zhangyuhang
 * @Classname Demo008
 * @Description 单词数目统计
 * @Date 2021/9/2 15:25
 */
public class Demo008 {
    public static void main(String[] args) {

    }
    public int countWordsIteratively(String s){
        int count = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()){
            if (Character.isWhitespace(c)){
                lastSpace = true;
            }
            else {
                if (lastSpace) {
                    count++;
                }
                lastSpace = false;
            }
        }
        return count;
    }
}
