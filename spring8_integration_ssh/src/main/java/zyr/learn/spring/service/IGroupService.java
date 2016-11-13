package zyr.learn.spring.service;

import org.springframework.stereotype.Service;
import zyr.learn.spring.model.Group;

import java.util.List;

/**
 * Created by zhouweitao on 2016/11/13.
 */
@Service("iGroupService")
public interface IGroupService {
    boolean add(Group group);
    Group load(int gid);
}
