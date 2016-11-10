package zyr.learn.dao;

import zyr.learn.model.User;

import java.util.List;

/**
 * Created by zhouweitao on 2016/11/6.
 */
public interface IUserDao {
    void add(User user);
    void update(User user);
    void delete(int id);
    User load(int id);
    List<User> list(String sql);
}
