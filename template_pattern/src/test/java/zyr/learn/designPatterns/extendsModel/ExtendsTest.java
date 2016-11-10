package zyr.learn.designPatterns.extendsModel;

import org.junit.Test;

/**
 * Created by zhouweitao on 2016/11/10.
 */


public class ExtendsTest {
    @Test
    public void test01() {
        /**
         * 3. 用模板的引用指向具体类的实例
         * */
        MyTemplate mt = new Role();
        mt.execute();
        MyTemplate mt1 = new Message();
        mt1.execute();
    }
}
