package zyr.manager.user.dao;

import org.springframework.stereotype.Repository;
import zyr.manager.user.model.User;
/**
 * Created by zhouweitao on 2016/11/14.
 *
 */

@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao {

}
