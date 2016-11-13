package zyr.learn.spring.dao;

import org.springframework.stereotype.Repository;
import zyr.learn.spring.model.User;

import java.util.List;

/**
 * Created by zhouweitao on 2016/11/13.
 *
 */

@Repository("hibernateUserDao")
public class HibernateUserDao extends BaseDao implements IUserDao {
    @Override
    public void add(User user) {
        getSession().save(user);
    }

    @Override
    public void delete(User user) {
        getSession().delete(user);
    }

    @Override
    public void update(User user) {
        getSession().merge(user);
    }

    @Override
    public User load(int id) {
        return (User) getSession().get(User.class,id);
    }

    @Override
    public List<User> findAll() {
        return getSession().createQuery("from User").list();
    }
}
