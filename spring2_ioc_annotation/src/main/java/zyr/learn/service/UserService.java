package zyr.learn.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import zyr.learn.dao.IUserDao;
import zyr.learn.model.User;

import javax.annotation.Resource;

/**
 * Created by zhouweitao on 2016/11/3.
 */

//@Component("userService")
@Service("userService")
public class UserService implements IUserService {
    private IUserDao userDao;

    public IUserDao getUserDao() {
        return userDao;
    }

    @Resource
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
