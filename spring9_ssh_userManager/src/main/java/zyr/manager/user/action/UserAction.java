package zyr.manager.user.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import zyr.manager.user.model.User;
import zyr.manager.user.service.IGroupService;
import zyr.manager.user.service.IUserService;
import zyr.manager.user.util.Pager;
import zyr.manager.user.util.SystemContext;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import java.util.List;

/**
 * Created by zhouweitao on 2016/11/14.
 */

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user;
    private IUserService userService;
    private String path;
    private IGroupService groupService;

    private Pager<User> offset;

    public Pager<User> getOffset() {
        return offset;
    }

    public void setOffset(Pager<User> offset) {
        this.offset = offset;
    }

    public IGroupService getGroupService() {
        return groupService;
    }

    @Resource(name = "groupService")
    public void setGroupService(IGroupService groupService) {
        this.groupService = groupService;
    }

    private int uid;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public IUserService getUserService() {
        return userService;
    }

    @Resource(name = "userService")
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getModel() {
        return user == null ? new User() : user;
    }

    public String list() {

        Pager<User> users = userService.queryUser();
        ActionContext.getContext().put("users", users);
        return SUCCESS;
    }

    public String del() {
        userService.delete(user.getUid());
        path = "/user_list.do?pager.offset="+ ServletActionContext.getRequest().getParameter("nowPage");
        return "redirect";
    }

    public String show() {
        System.out.println("show log......");
        user = userService.queryById(this.user.getUid());
        ActionContext.getContext().put("user", user);
        return SUCCESS;
    }

    public String addInput() {
        ActionContext.getContext().put("groups", groupService.list());
        if (user != null && user.getUid() != null) {
            ActionContext.getContext().put("old", userService.queryById(user.getUid()));
            user.setUid(null);
        }
        return SUCCESS;
    }

    public String add() {
        user.setGroup(groupService.findOne(user.getGroup().getGid()));
        userService.create(user);
        path = "user_list.do";
        return "redirect";
    }

    public String update() {
        userService.update(user);
        path = "user_list.do";
        return "redirect";
    }

    public void validateAdd() {
        if (user.getUsername() == null || "".equals(user.getUsername().trim())) {
            this.addFieldError("username", "username not is null");
        }
        /** 如果有错误得重写吧select中的groups获取，不然会报groups找不到的异常*/
        if (this.hasFieldErrors()) {
            addInput();
        }
    }


}
