package my.test;

/**
 * @author zefan.xzf
 * @date 2022/5/17 16:41
 */
public class Sub10 {

    public static int sub10() {
        int count = 55;

        for(int i = 1; i <= 10; ++i) {
            count -= i;
        }

        return count;
    }
}
