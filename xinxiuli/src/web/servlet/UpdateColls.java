package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import service.UpdateCollsId;

public class UpdateColls extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public UpdateColls() {
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
		//String s = request.getParameter("s");
		System.out.println("112233");
		//String goods_id = request.getParameter("goods_id");
		//String account_num = request.getParameter("account_num");
//		if(goods_id!=null) {
//			UpdateCollsId service = new service.Impl.UpdateCollsId();
//			boolean flag = service.updateCollsId(account_num,Integer.parseInt(goods_id));
//			PrintWriter out = response.getWriter();
//			response.setCharacterEncoding("utf-8");
//			response.setHeader("Content-Type", "application/json;charset=utf-8");
//			System.out.println(flag);
//			out.print(flag);
//			out.flush();
//			out.close();
//		}
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
