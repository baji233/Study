package com.jiuyun.web;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author cj
 * @create 2022年10月14日 20:31:00
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化过滤器！");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("this is MyFilter.doFilter() method!");
        //让请求通过当前过滤器，执行下一个过滤器，如果没有，则访问请求的资源
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("释放资源！");
    }
}
