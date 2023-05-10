package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entity.User;

public class LoginServlet extends HttpServlet{
UserDao ud=new UserDao();
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String username=arg0.getParameter("username");//接受页面上的用户名和密码
		String password=arg0.getParameter("password");
		User user=ud.login(username, password);
		//登录成功去index，失败回到login
		if(user==null) {
			//
			arg0.setAttribute("msg","用户名或密码错误");//向请求对象里存入了一个叫msg的值
			//重定向
			//arg1.sendRedirect("login.jsp");
			//转发
			arg0.getRequestDispatcher("/login.jsp").forward(arg0, arg1);
		}else {
			//登录成功后把用户信息存入session
			HttpSession session=arg0.getSession();//获取sesisono
			session.setAttribute("user",user);
			arg1.sendRedirect("index.jsp");
		}
	}

}
