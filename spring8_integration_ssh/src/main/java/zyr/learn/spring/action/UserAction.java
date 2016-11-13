package zyr.learn.spring.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import zyr.learn.spring.model.User;
import zyr.learn.spring.service.IUserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhouweitao on 2016/11/13.
 *
 */
@Controller("userAction")
@Scope("prototype")
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
        List<User> users = userService.findAll();
        ActionContext.getContext().put("users",users);

        for (User user1 : users) {
            System.out.println(user1);
        }
        path = "/WEB-INF/jsp/user/list.jsp";
        return SUCCESS;
    }

    public String index() {
        path = "index.jsp";
        return ERROR;
    }
}
