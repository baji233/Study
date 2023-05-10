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
 * @create 2022年10月27日 19:33:32
 */
public class StudentAction implements Action {
    private static final Logger log = LoggerFactory.getLogger(StudentAction.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("in StudentAction.execute method!");
        req.getRequestDispatcher("").forward(req, resp);
        resp.sendRedirect("");
        return "";
    }

    public String save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("in StudentAction.save method!");
//        return "forward:success.jsp";
        return getReturnUrl(Action.RETURN_TYPE_FORWARD,"success.jsp");
    }

}
