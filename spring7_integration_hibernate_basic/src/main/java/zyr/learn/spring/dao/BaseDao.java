package zyr.learn.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;

/**
 * Created by zhouweitao on 2016/11/13.
 */
public class BaseDao {
    private SessionFactory factory;

    public SessionFactory getFactory() {
        return factory;
    }

    @Resource(name = "sessionFactory")
    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    public Session getSession() {
        return this.getFactory().getCurrentSession();
    }
}
