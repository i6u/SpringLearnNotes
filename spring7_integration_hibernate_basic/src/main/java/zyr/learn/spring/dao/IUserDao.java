package zyr.learn.spring.dao;

import zyr.learn.spring.model.User;

import java.util.List;

/**
 * Created by zhouweitao on 2016/11/13.
 */
public interface IUserDao {
    void add(User user);

    void delete(User user);

    void update(User user);

    User load(int id);

    List findAll();

}
