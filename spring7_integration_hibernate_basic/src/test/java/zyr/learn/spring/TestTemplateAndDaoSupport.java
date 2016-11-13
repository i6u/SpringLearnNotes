package zyr.learn.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zyr.learn.spring.TemplateAndDaoSupport.BaseDaoHibernateDao;
import zyr.learn.spring.TemplateAndDaoSupport.BaseDaoTemplate;
import zyr.learn.spring.model.User;

import javax.annotation.Resource;

/**
 * Created by zhouweitao on 2016/11/13.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestTemplateAndDaoSupport {
    @Resource(name = "baseDaoTemplate")
    private BaseDaoTemplate template;
    @Resource(name = "baseDaoHibernateDao")
    private BaseDaoHibernateDao hibernateDao;

    @Test
    public void templateTest(){
        template.testTemplate(new User("jeff","admin","jeff"));
    }

    @Test
    public void daoTest(){
        hibernateDao.testHibernateDao(new User("jeff2","admin","jeff2"));
    }
}
