<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>500error</title>
		<link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
	</head>
	
	<style>
		body{
			background-image:url(/xinxiuli/img/500.jpg);
			background-size:100% 100%; 
			background-attachment: fixed;
		}
		button{
			width: 160px;
			position: absolute;
			left: 50%;
			margin-left: -80px;
			top:70%;
		}
	</style>
	<body>
		<button class="btn" onclick="huishouye()">返回首页<tton>
	</body>
<ml>
<script>
	function huishouye(){
		window.location.href="/xinxiuli/index.jsp";
	}
</script>