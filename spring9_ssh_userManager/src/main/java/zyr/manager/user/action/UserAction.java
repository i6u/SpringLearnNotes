package zyr.manager.user.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.stereotype.Controller;
import zyr.manager.user.model.User;
import zyr.manager.user.service.IUserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhouweitao on 2016/11/14.
 *
 */

@Controller("userAction")
public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user;
    private IUserService userService;
    private String path;

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
        List<User> users = userService.queryAll();
        ActionContext.getContext().put("users",users);
        path = "/WEB-INF/jsp/user/list.jsp";
        return SUCCESS;
    }

}
