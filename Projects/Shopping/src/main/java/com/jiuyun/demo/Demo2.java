package com.jiuyun.demo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 */
public class Demo2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化登录过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("经过了登录过滤器链");

        HttpSession session = ((HttpServletRequest)servletRequest).getSession();
        if(session.getAttribute("user") == null){
            //如果session为空，就重定向登录页面
            System.out.println("未登录");
            ((HttpServletResponse)servletResponse).sendRedirect( ((HttpServletRequest)servletRequest).getContextPath() + "/demo/demo3.jsp");
        }else{
            System.out.println("通过");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("销毁登录过滤器");
    }
}
