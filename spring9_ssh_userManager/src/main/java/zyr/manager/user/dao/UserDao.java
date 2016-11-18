package zyr.manager.user.dao;

import org.springframework.stereotype.Repository;
import zyr.manager.user.model.User;
/**
 * Created by zhouweitao on 2016/11/14.
 *
 */

@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao {

    @Override
    public void deleteByGroup(int gid) {
        int gid1 = this.getSession().createQuery("delete from User u where u.group.gid =:gid").setParameter("gid", gid).executeUpdate();
    }

    @Override
    public int findUserByGroup(int gid) {
        return (int) this.getSession().createQuery("select conut(*) from User u where u.gid=:gid").setParameter("gid",gid).uniqueResult();
    }
}
