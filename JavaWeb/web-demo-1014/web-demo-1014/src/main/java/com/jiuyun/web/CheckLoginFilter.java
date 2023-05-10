package com.jiuyun.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author cj
 * @create 2022年10月14日 20:39:13
 */
public class CheckLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = ((HttpServletRequest)servletRequest);
        HttpSession session = request.getSession();
         if(session.getAttribute("user") == null) {
             String contextPath =  request.getContextPath();
             System.out.println("ContextPath:" + contextPath);
             ((HttpServletResponse)servletResponse).sendRedirect(contextPath + "/login.jsp");
         } else {
            filterChain.doFilter(servletRequest, servletResponse);
         }
    }

    @Override
    public void destroy() {

    }
}
