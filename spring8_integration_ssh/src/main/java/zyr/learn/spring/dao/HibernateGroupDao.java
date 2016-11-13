package zyr.learn.spring.dao;

import org.springframework.stereotype.Repository;
import zyr.learn.spring.model.Group;

/**
 * Created by zhouweitao on 2016/11/13.
 */

@Repository("hibernateGroupDao")
public class HibernateGroupDao extends BaseDao implements IGroupDao {
    @Override
    public void add(Group group) {
        getSession().save(group);
    }

    @Override
    public Group load(int gid) {
        return (Group) getSession().get(Group.class,gid);
    }
}
