package web.xxk.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Imgservlet extends HttpServlet{
	
		// 图片的宽和高
		private static int WIDTH = 140;
		private static int HEIGHT = 30;

		private String[] str = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
				"X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
		
		private Random r = new Random();
       public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
             this.doPost(req,resp);
         }
      public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	      
    	        
    	       StringBuffer sb   = new StringBuffer();
    	       StringBuffer sbsb = new StringBuffer();
    	       //总共生产6位的随机验证码
    	       for(int i=0;i<6;i++){
    	       int index=r.nextInt(str.length);
    	       sb.append(str[index]);
    	       sbsb.append(str[index]+" ");
    	       }
    	      //验证码
    	       String content=sb.toString(); 
    	      //存到session
    	       req.getSession().setAttribute("authcode",content);
    	      //内存中一个缓存的图片对象
    	       BufferedImage bi=new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
    	      //获得图片的画笔
    	       Graphics g=bi.getGraphics();
    	     //上色
               g.setColor(Color.BLACK);
             //画外框
               g.drawRect(0, 0,WIDTH,HEIGHT);
               
             //填充背景 
               g.setColor(Color.white);
               g.fillRect(0, 0,WIDTH, HEIGHT);
            //写内容  
               g.setColor(Color.black);
               g.setFont(new Font("宋体", Font.BOLD, 20));
               g.drawString(sbsb.toString(),10, 20);
            //画300个干扰点
               for(int i=0;i<300;i++){
            	   int x=r.nextInt(WIDTH);
            	   int y=r.nextInt(HEIGHT);
            	   g.drawLine(x, y, x, y);
               }
             //画3条干扰线
               g.drawLine(10, 10, 130, 10);
             
       		   g.drawLine(10, 30, 130, 0);
       		//将内存中生产的图片写入输出流中  
       		  
       		 // resp.reset();
       		 ServletOutputStream   sos   =resp.getOutputStream(); 
       		    ImageIO.write(bi, "jpg", sos);
       		   
       		   sos.flush();
       		   sos.close();
       		       
       		 // out.clear();
       		 // out = pageContext.pushBody();
                   
      }
}
