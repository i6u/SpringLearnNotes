package zyr.manager.user.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zhouweitao on 2016/11/14.
 */
@Entity
@Table(name = "tab_user")
public class User implements Serializable {

    /**
    *
     * uid` mediumint(8) NOT NULL DEFAULT '0',
     `username` varchar(255) DEFAULT NULL,
     `phone` varchar(100) DEFAULT NULL,
     `email` varchar(255) DEFAULT NULL,
     `city` varchar(255) DEFAULT NULL,
     *
    * */
    private Integer uid;
    private String username;
    private String phone;
    private String email;
    private String city;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private Group group;

    @ManyToOne
    @JoinColumn(name="gid")
    public Group getGroup() {
        return group;
    }


    public void setGroup(Group group) {
        this.group = group;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                '}';
    }

    public User(String username) {
        this.username = username;
    }

    @Id
    @GeneratedValue
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
