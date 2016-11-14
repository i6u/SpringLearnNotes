package zyr.manager.user.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;

/**
 * Created by zhouweitao on 2016/11/14.
 *
 */
public class BaseDao<T> implements IBaseDao<T> {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private Class<T> getClazz() {
        return (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void add(T t) {
        this.getSession().save(t);
    }

    @Override
    public void del(int id) {
        this.getSession().delete(this.findOne(id));
    }

    @Override
    public void update(T t) {
        this.getSession().merge(t);
    }

    @Override
    public T findOne(int id) {
        return (T) this.getSession().load(this.getClazz(),id);
    }

    @Override
    public List<T> findAll() {
        return getSession().createQuery("from "+getClazz().getSimpleName()).list();
    }

    @Override
    public List<T> list(String hql, Objects... obj) {
        Query query = this.getSession().createQuery(hql);
        for (int i = 0; i < obj.length; i++) {
            query.setParameter(i, obj[i]);
        }
        return query.list();
    }
}
