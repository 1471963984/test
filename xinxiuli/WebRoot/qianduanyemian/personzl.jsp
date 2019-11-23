<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>我的订单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width,initial-scale=1" />
	<link rel="stylesheet" href="/xinxiuli/css/bootstrap.css" />
	<link rel="stylesheet" href="/xinxiuli/css/ljy-index-showpro.css" />
	<link rel="stylesheet" href="/xinxiuli/css/personzl.css" />
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
						<li>我的订单</li>
						<li>我的收藏</li>
						<li>客户服务</li>
					</ul>
				</div>
				<div class="info_r">
					<ul>
						<li>
							<div class="title-about">个人资料</div>
							<div class="updatePass">修改密码</div>
						</li>
						<li>
							<label class="list-lable">姓名</label>
							<p class="list-about">17769336339</p>
						</li>
						<li>
							<label class="list-lable">称谓</label>
							<p class="list-about">17769336339</p>
						</li>
						<li>
							<label class="list-lable">生日</label>
							<p class="list-about">17769336339</p>
						</li>
						<li>
							<label class="list-lable">手机号</label>
							<p class="list-about">17769336339</p>
						</li>
						<li>
							<label class="list-lable">电子邮箱</label>
							<p class="list-about">17769336339</p>
						</li>
						<li>
							<label class="list-lable">常住地址</label>
							<p class="list-about">17769336339</p>
						</li>
						<li>
							<label class="list-lable">学历</label>
							<p class="list-about">17769336339</p>
						</li>
						<li>
							<label class="list-lable">职业</label>
							<p class="list-about">17769336339</p>
						</li>
						<li>
							<label class="list-lable">薪酬</label>
							<p class="list-about">17769336339</p>
						</li>
						<li>
							<label class="list-lable">兴趣爱好</label>
							<p class="list-about">17769336339</p>
						</li>
					<button class="">修改资料</button>
				</ul>
		            <!--在这里获取请求的数据-->
		  
				</div>
			</div>

		</div>
  </body>
</html>
<script type="text/javascript" src="/xinxiuli/js/jquery.min.js" ></script>
<script type="text/javascript" src="/xinxiuli/js/bootstrap.js" ></script>
<script>
	$('.info-l li').mouseenter(function(){
		$(this).addClass("active").siblings().removeClass("active");
	});
	$('.info_r ul li').mouseenter(function(){
		$(this).addClass("active").siblings().removeClass("active");
	});
</script>
