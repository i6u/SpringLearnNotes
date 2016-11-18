package zyr.manager.user.service;


import zyr.manager.user.model.User;
import zyr.manager.user.util.Pager;

import java.util.List;

/**
 * Created by zhouweitao on 2016/11/14.
 *
 */
public interface IUserService {
    void create(User user);
    void update(User user);
    void delete(int id);
    User queryById(int id);
    Pager<User> queryUser();
}
