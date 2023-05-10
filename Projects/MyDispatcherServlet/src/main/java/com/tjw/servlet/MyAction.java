package com.tjw.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求接口，该项目的*.tjw的请求都进入这里，每一个请求都必须实现该接口
 */
public interface MyAction {

    //转发
    public static final String RETURN_TYPE_FORWARD = "forward";
    //重定向
    public static final String RETURN_TYPE_REDIRECT = "redirect";

    /**
     * 执行方法，当请求进入Servlet时默认执行此方法
     * @param req
     * @param resp
     * @return
     * @throws ServletException
     * @throws IOException
     */
    String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    /**
     * 实现这个接口的类需要使用的方法：将网页跳转类型+":"+页面拼接在一起
     * @param type
     * @param url
     * @return
     */
    default String getReturnURL(String type,String url){
        return type + ":" + url;
    }
}
