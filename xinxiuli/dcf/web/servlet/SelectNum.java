package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DcfGoodsDao;
import pojo.Account;
import service.DcfService;
import service.Impl.DcfServiceImpl;

public class SelectNum extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String gid=request.getParameter("gid");
    	int goodsid=subNumber(gid);
    	String cid=request.getParameter("cid");
    	int colorid=subNumber(cid);
    	String sid=request.getParameter("sid");
    	int sizeid=subNumber(sid);
    	Account acc=(Account)request.getSession().getAttribute("account");
    	
    	 DcfService ds=new DcfServiceImpl();
    	 int goodsnum=ds.selectNumber(goodsid, colorid, sizeid,acc.getAccount_num());
    	 PrintWriter out=response.getWriter();
    	 out.print(goodsnum);
    	
    }
    public int subNumber(String s) {
    	int a=Integer.parseInt(s.substring(1,s.length()-1));
    	return a;
    }
}
