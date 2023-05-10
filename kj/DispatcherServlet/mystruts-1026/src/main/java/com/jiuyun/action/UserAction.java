package com.jiuyun.action;

import com.jiuyun.servlet.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cj
 * @create 2022年10月27日 19:40:28
 */
public class UserAction implements Action {
    private static final Logger log = LoggerFactory.getLogger(UserAction.class);

    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("in UserAction.login method!");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if("admin".equals(userName) && "123".equals(password)) {
            return getReturnUrl(Action.RETURN_TYPE_FORWARD, "main.jsp");
        } else {
            return getReturnUrl(Action.RETURN_TYPE_REDIRECT, "login.jsp");
        }
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return null;
    }
}
