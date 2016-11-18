package zyr.manager.user.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import zyr.manager.user.model.Group;
import zyr.manager.user.service.IGroupService;

import javax.annotation.Resource;

/**
 * Created by zhouweitao on 2016/11/15.
 *
 */

@Controller("groupAction")
@Scope("prototype")
public class GroupAction extends ActionSupport implements ModelDriven<Group> {
    private Group group;
    private String path;

    private IGroupService groupService;

    public IGroupService getGroupService() {
        return groupService;
    }
    @Resource
    public void setGroupService(IGroupService groupService) {
        this.groupService = groupService;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public Group getModel() {
        return group !=null ? group : new Group();
    }


    public String list() {
        ActionContext.getContext().put("groups",groupService.querygroup());
        path = "/WEB-INF/jsp/group/list.jsp";
        return SUCCESS;
    }

    public String del() {
        try {
            groupService.delete(group.getGid());
            path = "/group_list.do";
        } catch (Exception e) {

        }
        return "redirect";
    }

    public String addInput() {
        path="/WEB-INF/jsp/group/addInput.jsp";
        return SUCCESS;
    }

    public String add() {
        System.out.println(group);
        groupService.add(group);
        path = "/group_list.do";
        return "redirect";
    }
}
