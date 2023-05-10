package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDao;
import entity.Cart;
import entity.User;
import service.CartService;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CartDao cd=new CartDao();
    CartService cs=new CartService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//先判断是否登录
		HttpSession session=req.getSession();
		User user=(User)session.getAttribute("user");
		if(user==null) {
			resp.sendRedirect("login.jsp");
		}else {
			//如果已经登录了，再判断要调用哪个方法
			String me=req.getParameter("me");
			if("add".equals(me)) {
				add(req,resp);
			}else if("findAll".equals(me)) {
				findAll(req,resp);
			}
		}
	}

	
	protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		User user=(User)session.getAttribute("user");
		//购物车操作。。。。。
		String shopId=req.getParameter("shopId");
		
		Cart c=new Cart();
		c.setcShopId(Integer.parseInt(shopId));
		c.setcUserId(user.getUserid());
		c.setNumber(1);
		//加入购物车
		int i=cd.addCart(c);
		//都是继续查看商品
		resp.sendRedirect("CartServlet?me=findAll");
	
	}
    
	//查询当前登录用户的购物车信息
	protected void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		User user=(User)session.getAttribute("user");
		List list=cs.findByUserId(user.getUserid());
		req.setAttribute("carts",list);
		req.getRequestDispatcher("cart.jsp").forward(req, resp);
	}

}
