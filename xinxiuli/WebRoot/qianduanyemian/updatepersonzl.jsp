<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>个人资料</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="/xinxiuli/css/updatepersonzl.css" />
  </head>
  
  <body>
		<!--头部信息展示-->
		<div id="info">
				<!--中间部分-->
			<div class="info-bg">
				<div class="info-t">
					<ul>
						<li class="index">首页</li>
						<li class="icon">></li>
						<li>我的账户</li>
						<li class="icon">></li>
						<li class="active">个人资料</li>
				    </ul>
				</div>
				
				<div class="info-l">
					<ul>
						<li>账户首页</li>
						<li class="active">个人资料</li>
						<li>地址簿</li>
						<li >我的订单</li>
						<li>我的收藏</li>
						<li>客户服务</li>
					</ul>
				</div>
				<div class="info_r">
					<h3>修改密码</h3>
					<ul class="info_r-list">
						<li>
							<label class="list-lable" >旧密码</label>
							<input type="password" placeholder="输入旧密码" />
						</li>
						<li>
							<label class="list-lable">新密码</label>
							<input type="password" placeholder="请输入旧密码，至少6位" />
						</li>
						<li>
							<label class="list-lable">确认新密码</label>
							<input type="password" placeholder="请在次输入密码" />
						</li>
						<button class="">确定</button>
					</ul>
		            <!--在这里获取请求的数据-->
				</div>
			</div>
		</div>
	</body>
</html>
