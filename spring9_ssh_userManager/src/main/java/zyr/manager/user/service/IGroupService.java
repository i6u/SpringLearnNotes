package zyr.manager.user.service;

import zyr.manager.user.model.Group;
import zyr.manager.user.util.Pager;

import java.util.List;

/**
 * Created by zhouweitao on 2016/11/15.
 *
 */
public interface IGroupService {
    void delete(int gid);

    void add(Group group);

    Group findOne(int id);

    List<Group> list();

    Pager<Group> querygroup();
}
