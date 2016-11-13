package zyr.learn.spring.dao;

import zyr.learn.spring.model.Group;

/**
 * Created by zhouweitao on 2016/11/13.
 */
public interface IGroupDao {
    void add(Group group);
    Group load(int gid);
}
