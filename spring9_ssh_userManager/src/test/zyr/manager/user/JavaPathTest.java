package zyr.manager.user;

import org.junit.Test;

/**
 * Created by zhouweitao on 2016/11/17.
 *
 */
public class JavaPathTest {
    @Test
    public void path() {

        show(this.getClass().getResource("").getPath());
        show(this.getClass().getResource("/zyr").getPath());
        show(Thread.currentThread().getContextClassLoader().getResource("").getPath());
        show(this.getClass().getClassLoader().getResource("").getPath());
        show(ClassLoader.getSystemResource("").getPath());

    }

    public static void show(Object obj) {
        System.out.println(obj.toString());
    }
}
