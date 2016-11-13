package zyr.learn.spring.service;

import org.springframework.stereotype.Service;
import zyr.learn.spring.dao.IUserDao;
import zyr.learn.spring.model.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhouweitao on 2016/11/13.
 */
@Service("userService")
public class UserService implements IUserService {

    private IUserDao userDao;

    public IUserDao getUserDao() {
        return userDao;
    }

    @Resource(name = "hibernateUserDao")
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean add(User user) {
        try {
            userDao.add(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(User user) {
        try {
            userDao.update(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(User user) {
        try {
            userDao.delete(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public User load(int id) {
        return userDao.load(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
