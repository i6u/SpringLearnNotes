package zyr.manager.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by zhouweitao on 2016/11/15.
 */

@Entity
@Table(name = "tab_group")
public class Group implements Serializable {
    private int gid;
    private String groupName;

    public Group() {
    }

    public Group(String groupName) {

        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "GroupAction{" +
                "gid=" + gid +
                ", groupName='" + groupName + '\'' +
                '}';
    }

    @Id
    @GeneratedValue
    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
