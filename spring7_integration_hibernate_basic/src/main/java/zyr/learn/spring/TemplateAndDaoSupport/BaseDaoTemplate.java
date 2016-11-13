package zyr.learn.spring.TemplateAndDaoSupport;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhouweitao on 2016/11/13.
 */

@Repository("baseDaoTemplate")
public class BaseDaoTemplate {
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    /**
     *
     * 使用hibernateTemplate，需要对其注入sessionFactory
     *  <bean id="hibernateTemplate" class="org.springframework.orm.hibernate3.HibernateTemplate">
     *      <property name="sessionFactory" ref="sessionFactory"/>
     *  </bean>
     *
     *
     * */

    @Resource(name = "hibernateTemplate")
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void testTemplate(Object obj) {

        /**
         * hibernateTemplate同样提供了CRUD操作
         * */
        this.hibernateTemplate.save(obj);
        //this.hibernateTemplate.merge(obj);
        //this.hibernateTemplate.delete(obj);

        /**
         * hibernateTemplate得到session的方式
         * */
        //this.hibernateTemplate.getSessionFactory().getCurrentSession();
    }
}
