package zyr.learn.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zyr.learn.spring.dao.IGroupDao;
import zyr.learn.spring.dao.IUserDao;
import zyr.learn.spring.model.Group;
import zyr.learn.spring.model.User;

import javax.annotation.Resource;

/**
 * Created by zhouweitao on 2016/11/10.
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class HTest {
    @Resource(name = "hibernateUserDao")
    private IUserDao userDao;

    @Resource(name = "hibernateGroupDao")
    private IGroupDao groupDao;
    @Test
    public void testUserDao() {
        //Group group = new Group("研发部");
        //groupDao.add(group);
        //User user = new User("wukong","123456","空");
        //user.setGroup(group);
        //userDao.add(user);
        User user = userDao.load(1);
        user.setNickname("悟空");
        userDao.update(user);
        System.out.println(user);
    }
}
