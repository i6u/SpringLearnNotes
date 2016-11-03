package zyr.learn.action;

import zyr.learn.model.User;
import zyr.learn.service.IUserService;
import zyr.learn.service.UserService;

import java.util.List;

/**
 * Created by zhouweitao on 2016/11/3.
 */
public class UserAction {
    private User user;
    private IUserService userService;
    private Integer id;
    private List<String> lists;



    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public UserAction() {
    }

    public UserAction(UserService userService) {
        this.userService = userService;
    }


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

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public void add() {
        userService.addUser(user);
    }

    public void delte() {

    }

    public void load() {
        userService.loadUser(id);
    }
}
