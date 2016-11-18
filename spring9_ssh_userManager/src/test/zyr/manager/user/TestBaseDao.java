package zyr.manager.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zyr.manager.user.dao.IGroupDao;
import zyr.manager.user.dao.IUserDao;
import zyr.manager.user.model.Group;
import zyr.manager.user.model.User;

import javax.annotation.Resource;

/**
 * Created by zhouweitao on 2016/11/14.
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestBaseDao {
    @Resource(name = "userDao")
    private IUserDao userDao;

    @Resource(name = "groupDao")
    private IGroupDao groupDao;

    @Test
    public void userDaoTest(){
        System.out.println("......");
        for (int i = 0; i < 50; i++) {
            StringBuffer sb = new StringBuffer();
            StringBuffer sb1 = new StringBuffer();
            for (int j= 5; j>0;j--) {
                int temp = new Double(Math.floor(Math.random() * 26)+97).intValue();
                int temp1 = new Double(Math.floor(Math.random() * 26)+65).intValue();
                if (sb.length()==3) {
                    sb.append(" ");
                    sb.replace(4,5,new Character(sb.charAt(0)).toString().toUpperCase());
                }
                sb.append((char) temp);
                sb1.append((char) temp1);
            }
            userDao.add(new User(sb.replace(0,1,new Character(sb.charAt(0)).toString().toUpperCase()).toString()));
            groupDao.add(new Group(sb1.toString()));
        }

    }


}
