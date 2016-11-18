package zyr.manager.user.dao;

import org.springframework.stereotype.Repository;
import zyr.manager.user.model.Group;

/**
 * Created by zhouweitao on 2016/11/15.
 */
@Repository("groupDao")
public class GroupDao extends BaseDao<Group> implements IGroupDao  {
}
