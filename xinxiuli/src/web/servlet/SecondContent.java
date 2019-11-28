package web.servlet;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import pojo.Second_content;
import service.FindSecondContent;

public class SecondContent extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public SecondContent() {
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

		String first = request.getParameter("firstnum");
		List<Second_content> list = null;
		PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(),"utf-8"),true);
		if(first!=null) {
			int firstnum = Integer.parseInt(first);
			FindSecondContent service = new service.Impl.FindSecondContent();
			list = service.findSecondContent(firstnum);
			//response.setCharacterEncoding("UTF-8");
			//response.setHeader("Content-Type", "application/json;charset=utf-8");
			JSONArray ja = JSONArray.fromObject(list);
			out.print(ja.toString());
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
