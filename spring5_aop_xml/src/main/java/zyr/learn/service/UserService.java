package zyr.learn.service;

import org.springframework.stereotype.Service;
import zyr.learn.dao.IMessageDao;
import zyr.learn.dao.IUserDao;
import zyr.learn.model.User;

import javax.annotation.Resource;

/**
 * Created by zhouweitao on 2016/11/3.
 */

@Service("userService")
public class UserService implements IUserService {
    private IUserDao userDao;
    private IMessageDao messageDao;

    public IMessageDao getMessageDao() {
        return messageDao;
    }

    @Resource(name = "messageDao")
    public void setMessageDao(IMessageDao messageDao) {
        this.messageDao = messageDao;
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    @Resource(name = "userDao")
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
