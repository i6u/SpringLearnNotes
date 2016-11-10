package zyr.learn.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by zhouweitao on 2016/11/4.
 */
@Repository("messageDao")//name不加默认为messageDao
public class MessageDao implements IMessageDao {
    public void addMsg(Object obj) {
        System.out.println("...add message invoke...");
    }

    public void delMsg(int id) {
        System.out.println("...delete message invoke...");
    }

    public Object loadMsg(int id) {
        System.out.println("...load message invoke...");
        return null;
    }
}
