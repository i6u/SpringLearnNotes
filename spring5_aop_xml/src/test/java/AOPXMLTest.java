import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zyr.learn.action.UserAction;

/**
 * Created by zhouweitao on 2016/11/4.
 */
public class AOPXMLTest {
    private BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
    @Test
    public void test01(){
        UserAction ua = factory.getBean(UserAction.class);
        ua.add();
        ua.setId(1);
        ua.delte();
    }
}
