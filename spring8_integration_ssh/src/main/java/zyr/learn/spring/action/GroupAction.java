package zyr.learn.spring.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import zyr.learn.spring.model.Group;
import zyr.learn.spring.service.IGroupService;

/**
 * Created by zhouweitao on 2016/11/13.
 */

@Controller("groupAction")
@Scope("prototype")
public class GroupAction extends ActionSupport implements ModelDriven<Group> {
    private Group group;
    private IGroupService groupService;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public IGroupService getGroupService() {
        return groupService;
    }

    public void setGroupService(IGroupService groupService) {
        this.groupService = groupService;
    }

    @Override
    public Group getModel() {
        return group == null ? new Group() : group;
    }

    public String list() {
        return SUCCESS;
    }
}
