package zyr.manager.user.filter;

import zyr.manager.user.util.SystemContext;

import javax.servlet.*;
import java.io.IOException;
/**
 * Created by zhouweitao on 2016/11/16.
 *
 */
public class PagingFilter implements Filter {
    private int pagerSizer;

    @Override
    public void init(FilterConfig cfg) throws ServletException {
        try {
            pagerSizer = Integer.parseInt(cfg.getInitParameter("pagerSize"));
        } catch (NumberFormatException e) {
            pagerSizer = 5;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            int pagerOffset = 0;
            if(request.getParameter("pager.offset")!=null) pagerOffset = Integer.parseInt(request.getParameter("pager.offset"));
            if(request.getParameter("pagerSize")!=null) pagerSizer = Integer.parseInt(request.getParameter("pagerSize"));
            SystemContext.setPageOffset(pagerOffset);
            SystemContext.setPageSize(pagerSizer);
            chain.doFilter(request, response);
        } finally {
            SystemContext.removePageOffset();
            SystemContext.removePageSize();
        }
    }

    @Override
    public void destroy() {

    }
}
