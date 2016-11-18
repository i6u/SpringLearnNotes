package zyr.manager.user.filter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by zhouweitao on 2016/11/15.
 *
 */
public class OpenSessionFilter implements Filter {
    /** */
    private static WebApplicationContext context;
    /** */
    private static SessionFactory factory;
    /** 使用ThreadLocal传递session*/
    private static ThreadLocal<Session> sessionHolder = new ThreadLocal<>();

    public static Session getSession() {
        return sessionHolder.get();
    }


    /** factory只创建一次*/
    @Override
    public void init(FilterConfig config) throws ServletException {
        /** 得到spring的beanFactory*/
        context = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        /** 获取sessionFactory*/
        factory = (SessionFactory) context.getBean("sessionFactory");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try {
            /** 打开session，注意使用的是openSession而不是spring事务关联的factory.getCurrentSession()*/
            sessionHolder.set(factory.openSession());
            chain.doFilter(request,response);
        }finally {
            /** 关闭session*/
            sessionHolder.remove();
        }


    }

    @Override
    public void destroy() {

    }
}
