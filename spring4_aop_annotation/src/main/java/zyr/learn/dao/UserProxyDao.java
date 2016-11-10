package zyr.learn.dao;

import org.springframework.stereotype.Component;
import zyr.learn.proxy.Logger;
import zyr.learn.model.User;

import javax.annotation.Resource;

/**
 * Created by zhouweitao on 2016/11/4.
 *
 */

@Component("userProxyDao")
public class UserProxyDao implements IUserDao {
    private IUserDao userDao;

    public IUserDao getUserDao() {
        return userDao;
    }

    @Resource
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        Logger.info(UserDao.class.getName()+":add");
        userDao.addUser(user);
    }

    public void delUser(Integer id) {
        Logger.info(UserDao.class.getName()+"del");
        userDao.delUser(id);
    }

    public User loadUser(Integer id) {
        Logger.info(UserDao.class.getName()+"add");
        userDao.loadUser(id);
        return null;
    }
}
