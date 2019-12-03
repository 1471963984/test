package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
		String goods_desc = request.getParameter("goods_desc");
		String pop = request.getParameter("pop");
		String price = request.getParameter("price");
		if(goods_desc!=null&&!"undefined".equals(goods_desc)) {
			map.put("goods_desc", goods_desc);
		}
		if(pop!=null&&!"undefined".equals(pop)) {
			String[] str = pop.split(",");
			if("0".equals(str[0])&&!"0".equals(str[1])) {
				map.put("smax", str[1]);
			}else if("0".equals(str[1])&&!"0".equals(str[0])) {
				map.put("smin", str[0]);
			}else if(!"0".equals(str[0])&&!"0".equals(str[1])) {
				map.put("smin", str[0]);
				map.put("smax", str[1]);
			}
		}
		if(price!=null&&!"undefined".equals(price)) {
			String[] str = price.split(",");
			if("0".equals(str[0])&&!"0".equals(str[1])) {
				map.put("max", str[1]);
			}else if("0".equals(str[1])&&!"0".equals(str[0])) {
				map.put("min", str[0]);
			}else if(!"0".equals(str[0])&&!"0".equals(str[1])) {
				map.put("min", str[0]);
				map.put("max", str[1]);
			}
		}
		
		FindGoodsCondition service = new service.Impl.FindGoodsCondition();
		List<Goods> list = service.findGoodsCondition(map);
		JSONArray ja = JSONArray.fromObject(list);
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-type", "application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(URLDecoder.decode(ja.toString()));
		out.flush();
		out.close();
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
