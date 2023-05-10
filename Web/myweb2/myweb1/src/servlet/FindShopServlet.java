package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShopDao;

/**
 * Servlet implementation class FindShopServlet
 */
@WebServlet("/FindShopServlet")
public class FindShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ShopDao sd=new ShopDao();
    public FindShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List list=sd.findAll();
		req.setAttribute("shopList",list);//存入请求对象
		
		//shop_list.jsp
		req.getRequestDispatcher("shop_list.jsp").forward(req,resp);
	}

    
    
	

}
