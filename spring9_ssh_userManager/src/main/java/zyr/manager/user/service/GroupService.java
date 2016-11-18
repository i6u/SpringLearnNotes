package zyr.manager.user.service;

import org.springframework.stereotype.Service;
import zyr.manager.user.dao.IGroupDao;
import zyr.manager.user.dao.IUserDao;
import zyr.manager.user.model.Group;
import zyr.manager.user.util.Pager;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhouweitao on 2016/11/15.
 *
 */
@Service("groupService")

public class GroupService implements IGroupService {
    @Resource(name = "groupDao")
    private IGroupDao groupDao;
    @Resource(name = "userDao")
    private IUserDao userDao;
    @Override
    public void delete(int gid) {
        //if (userDao.findUserByGroup(gid)>0) new Exception("组中存在用户不能删除");
        userDao.deleteByGroup(gid);
        groupDao.del(gid);
    }
    @Override
    public void add(Group group) {
        groupDao.add(group);
    }

    @Override
    public Group findOne(int id) {
        return groupDao.findOne(id);
    }

    @Override
    public List<Group> list() {
        return groupDao.list("from group");
    }

    @Override
    public Pager<Group> querygroup() {
        return groupDao.findAll("from Group");
    }

}
