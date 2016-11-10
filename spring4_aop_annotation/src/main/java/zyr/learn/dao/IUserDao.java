package zyr.learn.dao;

import zyr.learn.model.LogInfo;
import zyr.learn.model.User;

/**
 * Created by zhouweitao on 2016/11/3.
 */
public interface IUserDao {

    @LogInfo("add user info...")
    void addUser(User user);

    @LogInfo("delete user info...")
    void delUser(Integer id);

    User loadUser(Integer id);
}
