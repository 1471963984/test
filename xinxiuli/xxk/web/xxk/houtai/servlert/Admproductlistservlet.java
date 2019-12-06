package web.xxk.houtai.servlert;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Admproductlist;
import serviceimp.Admproductlistimpsevicedao;

public class Admproductlistservlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	   this.doPost(req, resp);
    }
    
    @Override  
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	Admproductlistimpsevicedao dao=new Admproductlistimpsevicedao();
    	int pagesize=10;
	
    	int maxpageno=dao.selectMaxPageNo(pagesize);
        int pageno=1;
        String no=req.getParameter("pageno");
        if(no==null||"0".equals(no)){
           no="1";        	
        }
        pageno=Integer.parseInt(no);
        if(pageno>maxpageno){
          pageno=maxpageno;     	
        }
        
        
    	req.setAttribute("pagesize", pagesize);
    	req.setAttribute("maxpageno",maxpageno);
    	req.setAttribute("pageno",pageno);
    	List<Admproductlist> list=dao.selectadmlist(pageno, pagesize);              
    	req.setAttribute("list",list);
    	req.getRequestDispatcher("/houtaiyemian/productList.jsp").forward(req, resp);
    }
}
