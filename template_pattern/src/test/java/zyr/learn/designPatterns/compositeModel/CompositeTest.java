package zyr.learn.designPatterns.compositeModel;

import org.junit.Test;

/**
 * Created by zhouweitao on 2016/11/10.
 */
public class CompositeTest {

    @Test
    public void test01(){
        IRole role = new Role();
        role.add("abc");
        System.out.println();
        role.del("zxc");
    }
}
