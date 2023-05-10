package com.jiuyun.action;

import com.jiuyun.servlet.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

public class CatAction implements Action {
    private static final Logger log = LoggerFactory.getLogger(CatAction.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("execute");
        return null;
    }

    public String delete(HttpServletRequest request, HttpServletResponse response){
        log.debug("delete");
        Random random = new Random();
        int a = random.nextInt(5);
        if(a == 3 || a ==1) {
            return getReturnUrl(Action.RETURN_TYPE_FORWARD, "success.jsp");
        }else{
            return getReturnUrl(Action.RETURN_TYPE_REDIRECT,"fail.jsp");
        }
    }
}
