package com.jiuyun.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求接口，每一系列请求都必须实现该接口
 * @author cj
 * @create 2022年10月27日 18:48:06
 */
public interface Action {
    public static final String RETURN_TYPE_FORWARD = "forward";
    public static final String RETURN_TYPE_REDIRECT = "redirect";
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    /**
     * 将类型和url用:拼接在一起
     * @param type 转发或重定向
     * @param url 需要跳转的页面
     * @return
     */
    default String getReturnUrl(String type, String url) {
        return type + ":" + url;
    }
}
