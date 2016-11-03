package zyr.learn.model;

import java.util.Date;

/**
 * Created by zhouweitao on 2016/11/3.
 */
public class User {
    private Integer id;
    private String name;
    private Date birthday;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(Integer id, String name, Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public User() {
    }

    public void setBirthday(Date birthday) {

        this.birthday = birthday;
    }
}
