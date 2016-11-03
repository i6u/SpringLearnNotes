package zyr.learn.service;

import zyr.learn.dao.IUserDao;
import zyr.learn.model.User;

/**
 * Created by zhouweitao on 2016/11/3.
 */
public class UserService implements IUserService {
    private IUserDao userDao;

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void delUser(Integer id) {
        userDao.delUser(id);
    }

    public User loadUser(Integer id) {
        return userDao.loadUser(id);
    }
}
