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
import net.sf.json.JSONObject;
import pojo.Goods;
import service.UpdateCollsId;

public class UpdateCartGoods extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public UpdateCartGoods() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = request.getParameter("s");
		JSONObject jo = JSONObject.fromObject(s);
		String goods_id = jo.getString("goods_id");
		String account_num = jo.getString("account_num");
		List<Goods> list = new ArrayList<Goods>();
		if(goods_id!=null&&account_num!=null) {
			service.UpdateCartGoods service = new service.Impl.UpdateCartGoods();
			list = service.updateCartGoods(account_num,Integer.parseInt(goods_id));
			PrintWriter out = response.getWriter();
			response.setCharacterEncoding("utf-8");
			response.setHeader("Content-Type", "application/json;charset=utf-8");
			JSONArray ja = JSONArray.fromObject(list);
			out.print(URLDecoder.decode(ja.toString()));
			out.flush();
			out.close();
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
