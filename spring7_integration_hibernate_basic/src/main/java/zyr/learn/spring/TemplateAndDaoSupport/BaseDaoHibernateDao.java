package zyr.learn.spring.TemplateAndDaoSupport;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhouweitao on 2016/11/13.
 */

@Repository("baseDaoHibernateDao")
public class BaseDaoHibernateDao extends HibernateDaoSupport {
    /**
     * 注入sessionFactory
     * */

    @Resource(name = "sessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void testHibernateDao(Object obj) {
        /**
         * 这里的getSession是父类提供的
         * */
        //getSession().save(obj);
        getHibernateTemplate().save(obj);
    }
}
