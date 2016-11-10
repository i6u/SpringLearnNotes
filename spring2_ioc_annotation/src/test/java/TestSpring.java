import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zyr.learn.action.UserAction;
import zyr.learn.model.User;

import java.util.Date;

/**
 * Created by zhouweitao on 2016/11/3.
 */
public class TestSpring {
    private BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");

    @Test
    public void Test21(){
        //UserAction ua = (UserAction) factory.getBean("userAction");
        UserAction ua2 = factory.getBean("userAction", UserAction.class);
        User user = new User(12, "jock", new Date());
        ua2.setUser(user);
        ua2.add();

        UserAction ua3 = factory.getBean("userAction", UserAction.class);
        ua3.add();
    }

    @Test
    public void Test2(){
        UserAction ua1 = factory.getBean("userAction", UserAction.class);
        System.out.println(ua1.getLists());
    }
}
