package com.jiuyun.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author cj
 * @create 2022年10月14日 20:54:33
 */
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("服务器启动了。。。");
        System.out.println("开始加载资源！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("服务器关闭了。。。");
        System.out.println("开始释放资源！");
    }
}
