package zyr.manager.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by zhouweitao on 2016/11/14.
 *
 */
@Entity
@Table(name="tab_user")
public class User implements Serializable{
    private Integer uid;
    private String username;


    public User() {
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
