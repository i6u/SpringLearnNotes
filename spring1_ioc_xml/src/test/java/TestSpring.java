import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import zyr.learn.action.UserAction;
import zyr.learn.model.User;
import java.util.Date;

/**
 * Created by zhouweitao on 2016/11/3.
 *
 */
public class TestSpring {
    private BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");

    @Test
    public void Test1(){
        //UserAction ua = (UserAction) factory.getBean("userAction");
        UserAction ua = factory.getBean("userAction", UserAction.class);
        User user = new User(1, "jock", new Date());
        ua.setUser(user);
        ua.add();
        UserAction ua1 = factory.getBean("userAction", UserAction.class);
        ua1.add();

    }

    @Test
    public void Test2(){
        UserAction ua1 = factory.getBean("userAction", UserAction.class);
        System.out.println(ua1.getLists());

        BeanFactory factory2 = new FileSystemXmlApplicationContext("fileSystemConfig.xml");
    }
}
