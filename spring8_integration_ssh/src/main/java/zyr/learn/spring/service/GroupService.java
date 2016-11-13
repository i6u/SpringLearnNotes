package zyr.learn.spring.service;

import org.springframework.stereotype.Service;
import zyr.learn.spring.dao.IGroupDao;
import zyr.learn.spring.model.Group;

import javax.annotation.Resource;

/**
 * Created by zhouweitao on 2016/11/13.
 */

@Service("groupService")
public class GroupService implements IGroupService {

    private IGroupDao groupDao;

    public IGroupDao getGroupDao() {
        return groupDao;
    }
    @Resource(name="hibernateGroupDao")
    public void setGroupDao(IGroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public boolean add(Group group) {
        try {
            groupDao.add(group);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Group load(int gid) {
        return groupDao.load(gid);
    }
}
