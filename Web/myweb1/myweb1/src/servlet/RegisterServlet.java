package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;

public class RegisterServlet extends HttpServlet{
UserDao ud=new UserDao();
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		//接受页面的参数
		String username=arg0.getParameter("newUsername");
		String password=arg0.getParameter("newPassword");
		User u=new User();//把参数封装到一个user对象里
		u.setUsername(username);
		u.setPassword(password);
		int i=ud.register(u);//调用dao层的注册方法
		if(i>0) {
			arg1.sendRedirect("login.html");
		}else {
			arg1.sendRedirect("register.html");
		}
	}
	
}
