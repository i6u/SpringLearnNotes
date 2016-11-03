package zyr.learn.dao;

import zyr.learn.model.User;

/**
 * Created by zhouweitao on 2016/11/3.
 */
public class UserDao implements IUserDao {
    public void addUser(User user) {
        System.out.println("add:"+user);
    }

    public void delUser(Integer id) {
        System.out.println("delete:"+id);
    }

    public User loadUser(Integer id) {
        System.out.println("load:"+id);
        return null;
    }
}
