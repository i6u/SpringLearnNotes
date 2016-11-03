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
    public void Test1(){
        UserAction ua = factory.getBean("userAction", UserAction.class);
        User user = new User(1, "jock", new Date());
        ua.setUser(user);
        ua.add();

        UserAction ua1 = factory.getBean("userAction", UserAction.class);
        User user1 = new User(2,"mask",new Date());
        ua.setUser(user1);
        ua1.add();

        System.out.println(user==user1);

    }

    @Test
    public void Test2(){

    }
}
