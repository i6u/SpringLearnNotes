import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zyr.learn.dao.IGroupDao;
import zyr.learn.dao.IUserDao;
import zyr.learn.model.Group;
import zyr.learn.model.User;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * Created by zhouweitao on 2016/11/6.
 */


@RunWith(SpringJUnit4ClassRunner.class) //让junit运行在spring4的运行环境中
@ContextConfiguration("/beans.xml")    //加载spring配置文件
public class JDBCIntegration {
    @Resource
    private IUserDao userDao;

    @Resource
    private IGroupDao groupDao;
    @Test
    public void testAdd(){
        User user = new User("寡姐","black");
        userDao.add(user);
    }

    @Test
    public void testUpdate(){
        User user = new User(2,"索尔","sur");
        userDao.update(user);
    }

    @Test
    public void testDelete() {
        userDao.delete(2);
    }

    @Test
    public void testGroupAdd(){
        Group group = new Group("super man");
        groupDao.add(group);

        System.out.println(group);
        User user = new User("best green man","big");
        user.setGroup(group);
        //userDao.add(user);
        //groupDao.executeSql("delete from t_group order by id desc limit 4");
    }

    @Test
    public void testQuery(){
        //System.out.println(userDao.load(1));

        List<User> users = userDao.list("select * from t_user u join t_group g on u.gid = g.id");
        for (User user : users) {
            System.out.println(user);
        }
    }
}
