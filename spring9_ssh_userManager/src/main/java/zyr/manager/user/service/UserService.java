package zyr.manager.user.service;

import org.springframework.stereotype.Service;
import zyr.manager.user.dao.IUserDao;
import zyr.manager.user.model.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhouweitao on 2016/11/14.
 */
@Service("userService")
public class UserService implements IUserService {
    private IUserDao userDao;

    public IUserDao getUserDao() {
        return userDao;
    }

    @Resource(name = "userDao")
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void create(User user) {
        userDao.add(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(int id) {
        userDao.del(id);
    }

    @Override
    public User queryById(int id) {
        return userDao.findOne(id);
    }

    @Override
    public List<User> queryAll() {
        return userDao.findAll();
    }
}
