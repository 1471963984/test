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
	<link rel="stylesheet" href="/xinxiuli/css/bootstrap.css" />
	
	<link rel="stylesheet" href="/xinxiuli/css/ljy-index-showpro.css" />
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
						<li class="active"><a href="/xinxiuli/qianduanyemian/personzl.jsp">个人资料</a></li>
						<li><a href="/xinxiuli/qianduanyemian/myaddrs.jsp">地址簿</a></li>
						<li><a href="/xinxiuli/qianduanyemian/myorders.jsp">我的订单</a></li>
						<li><a href="/xinxiuli/qianduanyemian/mycolls.jsp">我的收藏</a></li>
						<li>客户服务</li>
					</ul>
				</div>
				<div class="info_r">
				<form action="">
					<ul>
						<li>
							<div class="title-about">个人资料</div>
						</li>
						<li>
							<label class="list-lable">姓名*</label>
							<input type="text" placeholder="17769336339" />
						</li>
						<li>
							<label class="list-lable">称谓*</label>
                            <div class="dropdown">
					            <!--按钮-->
					            <input type="text" class="sex chengwei" data-toggle="dropdown" placeholder="选择称谓" >
					            </input>
					            <!--项-->
					            <ul class="dropdown-menu">
					            	<li>先生</li>
                                	<li>女士</li>
					            </ul>
					        </div>
                            <!--<span class="help-block"></span>-->
						</li>
						<li>
							<label class="list-lable">生日*</label>
							<input type="text" placeholder="17769336339" />
						</li>
						<li>
							<label class="list-lable">手机号*</label>
							<input  type="text" placeholder="17769336339" />
						</li>
						<li>
							<label class="list-lable">电子邮箱*</label>
							<input  type="text" placeholder="17769336339" />
						</li>
						<li>
							<label class="list-lable">常住地址</label>
							<input  type="text" placeholder="17769336339" />
						</li>
						<li>
							<label class="list-lable">学历</label>
							<input  type="text" placeholder="17769336339" />
						</li>
						<li>
							<label class="list-lable">职业</label>
							<input  type="text" placeholder="17769336339" />
						</li>
						<li>
							<label class="list-lable">薪酬</label>
							<input  type="text" placeholder="17769336339" />
						</li>
						<li>
							<label class="list-lable">兴趣爱好</label>
							<input  type="text" placeholder="17769336339" />
						</li>
						<button class="" type="button">保存修改</button>
					</ul>
				</form>
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
		//先生女士选择框
	$('.dropdown-menu li').click(function(){
			var a = $(this).html();
			$('.chengwei').val($(this).html());
	})
</script>
