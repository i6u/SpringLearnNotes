package zyr.manager.user.dao;

import zyr.manager.user.model.User;

/**
 * Created by zhouweitao on 2016/11/14.
 *
 */
public interface IUserDao extends IBaseDao<User> {
    void deleteByGroup(int gid);

    int findUserByGroup(int gid);
}
