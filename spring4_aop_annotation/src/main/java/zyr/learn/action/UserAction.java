package zyr.learn.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import zyr.learn.model.User;
import zyr.learn.service.IUserService;
import zyr.learn.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhouweitao on 2016/11/3.
 */

@Controller("userAction")
@Scope("prototype")
public class UserAction {
    private User user;
    private IUserService userService;
    private Integer id;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IUserService getUserService() {
        return userService;
    }

    @Resource
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public void add() {
        userService.addUser(user);
    }

    public void delte() {
        userService.delUser(id);
    }

    public void load() {
        userService.loadUser(id);
    }
}
