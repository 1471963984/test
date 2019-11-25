<%@page import="pojo.Goods_detail"%>
<%@page import="dao.impl.Goods_detailDaoImpl"%>
<%@page import="dao.Goods_detailDao"%>
<%@page import="pojo.Goods_color"%>
<%@page import="dao.impl.Goods_colorDaoImpl"%>
<%@page import="dao.Goods_colorDao"%>
<%@page import="pojo.Goods_size"%>
<%@page import="dao.impl.Goods_sizeDaoImpl"%>
<%@page import="dao.Goods_sizeDao"%>
<%@page import="pojo.Goods"%>
<%@page import="dao.impl.GoodsDaoImpl"%>
<%@page import="dao.GoodsDao"%>
<%@page import="util.GenericPrimaryKey"%>
<%@page import="pojo.Account"%>
<%@page import="dao.impl.AccountDaoImpl"%>
<%@page import="dao.AccountDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="db.DbHelp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	Connection conn = DbHelp.getConnection();
	
 %>
 <%=DbHelp.getConnection() %>
 <p>${flag}</p>
</body>
</html>