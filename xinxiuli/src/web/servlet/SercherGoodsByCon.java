package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import pojo.Goods;
import service.HotGoodsSercher;
import service.Impl.HotGoodsSercherImpl;

public class SercherGoodsByCon extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public SercherGoodsByCon() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String desc = request.getParameter("desc");
		desc = new String(desc.getBytes("ISO8859-1"),"UTF-8");
		PrintWriter out = response.getWriter();
		List<Goods> list = new ArrayList<Goods>();
		HotGoodsSercher service = new HotGoodsSercherImpl();
		if(desc!=null&&!"undefined".equals(desc)) {
			list = service.sercherGoods(desc);
			if(list.size()!=0) {
				request.setAttribute("show", "no");
				request.setAttribute("goodsList", list);
				request.getRequestDispatcher("/qianduanyemian/hotGoodsshow.jsp").forward(request, response);
			}else {
				request.setAttribute("show", "yes");
				request.getRequestDispatcher("/qianduanyemian/hotGoodsshow.jsp").forward(request, response);
			}
			
		}	
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
