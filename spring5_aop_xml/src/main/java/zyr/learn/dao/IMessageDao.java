package zyr.learn.dao;

import zyr.learn.model.LogInfo;

/**
 * Created by zhouweitao on 2016/11/4.
 */
public interface IMessageDao {
    @LogInfo("add message info...")
    void addMsg(Object obj);

    void delMsg(int id);

    Object loadMsg(int id);
}
