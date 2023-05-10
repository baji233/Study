package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entity.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserDao ud=new UserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    //一个servlet要可以接受多个请求
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String me=req.getParameter("me");
		if("login".equals(me)) {
			login(req,resp);
		}else if("register".equals(me)){
			register(req,resp);
		}
	}
	
	
	protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//可以写和service里面一样的功能
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		User u=ud.login(username, password);
		if(u==null) {
			req.setAttribute("msg","用户名或密码错误");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}else {
			//登录成功，把用户信息存入session
			HttpSession session=req.getSession();
			session.setAttribute("user",u);
			resp.sendRedirect("IndexServlet");
		}
	}

	protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user=new User();
		user.setUsername(req.getParameter("username"));
		user.setPassword(req.getParameter("password"));
		user.setPhone(req.getParameter("phone"));
		if(ud.register(user)>0) {
			resp.sendRedirect("login.jsp?type=1");
		}else {
			
			//req.getRequestDispatcher("login.jsp?type=2").forward(req, resp);
			resp.sendRedirect("login.jsp?type=2&msg=2");
		}
	}


}
