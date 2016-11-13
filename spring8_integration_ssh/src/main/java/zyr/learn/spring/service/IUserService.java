package zyr.learn.spring.service;

import zyr.learn.spring.model.User;

import java.util.List;

/**
 * Created by zhouweitao on 2016/11/13.
 */

public interface IUserService {
    boolean add(User user);
    boolean update(User user);

    boolean delete(User user);

    User load(int id);

    List<User> findAll();
}
