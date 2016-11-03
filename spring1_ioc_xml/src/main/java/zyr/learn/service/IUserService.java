package zyr.learn.service;

import zyr.learn.model.User;

/**
 * Created by zhouweitao on 2016/11/3.
 */
public interface IUserService {
    void addUser(User user);

    void delUser(Integer id);

    User loadUser(Integer id);
}
