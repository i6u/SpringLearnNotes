import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zyr.learn.action.UserAction;
import zyr.learn.model.User;

import java.util.Date;

/**
 * Created by zhouweitao on 2016/11/4.
 */
public class AOPTest {
    private BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");

    @Test
    public void Test31(){
        UserAction ua = factory.getBean(UserAction.class);
        ua.setUser(new User(3,"吕布",new Date()));
        ua.add();
        ua.setId(3);
        ua.load();
        ua.delte();

    }
}
