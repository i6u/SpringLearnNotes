package zyr.learn.dao;

import zyr.learn.model.Group;

/**
 * Created by zhouweitao on 2016/11/9.
 */
public interface IGroupDao {
    void add(Group group);

    void executeSql(String sql);
}
