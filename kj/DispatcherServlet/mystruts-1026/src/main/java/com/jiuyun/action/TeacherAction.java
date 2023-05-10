package com.jiuyun.action;

import com.jiuyun.servlet.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cj
 * @create 2022年10月27日 20:50:14
 */
public class TeacherAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println();
        return null;
    }
}
