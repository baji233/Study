package com.tjw.action;

import com.tjw.servlet.MyAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAction implements MyAction {

    private static final Logger log = LoggerFactory.getLogger(UserAction.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("execute");
        return getReturnURL(MyAction.RETURN_TYPE_REDIRECT,"login.jsp");
    }

    public String login(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        log.debug("login");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        //TODO:可使用后端框架进行查询判断
        if("daidai".equals(name) && "123".equals(password)){
            return getReturnURL(MyAction.RETURN_TYPE_FORWARD,"success.html");
        }else{
            return getReturnURL(MyAction.RETURN_TYPE_REDIRECT,"fail.html");
        }
    }
}
