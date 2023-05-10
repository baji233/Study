package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Shop;
import service.ShopService;

/**
 * Servlet implementation class ShopServlet
 */
@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    ShopService ss=new ShopService();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接受页面传入的商品id，返回商品的详细信息
		String shopId=req.getParameter("shopId");
		Shop shop=ss.findShopById(Integer.parseInt(shopId));
		req.setAttribute("shop",shop);
		req.getRequestDispatcher("shop_de.jsp").forward(req, resp);
	}
    

}
