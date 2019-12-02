package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import pojo.Goods;
import service.FindGoodsCondition;

public class FindGoodsCon extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public FindGoodsCon() {
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
		Map<String,String> map = new HashMap<String, String>();
//		String goods_desc = request.getParameter("goods_desc");
//		String smin = request.getParameter("smin");
//		String smax = request.getParameter("smax");
//		String max = request.getParameter("max");
//		String min = request.getParameter("min");
		String goods_desc = "男士";
		String smin = "10";
		String smax = "1000";
		String max = "4000";
		String min = "0";
		map.put("goods_desc", goods_desc);
		map.put("smin", smin);
		map.put("smax", smax);
		map.put("min", min);
		map.put("max", max);
		FindGoodsCondition service = new service.Impl.FindGoodsCondition();
		List<Goods> list = service.findGoodsCondition(map);
		JSONArray ja = JSONArray.fromObject(list);
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-type", "application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		System.out.println(ja.toString());
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
