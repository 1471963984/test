<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<link rel="stylesheet" href="/xinxiuli/css/PersonAllPageHeader.css"/>
	<link rel="stylesheet" href="/xinxiuli/css/PersonAllPageFooter.css"/>
	<link rel="stylesheet" href="/xinxiuli/css/myorders.css" />
  </head>
  
  <body data-spy="scroll">
		<!--首页头部-->
		<header class="mypage-header">
				<nav>
				<!--普通导航栏-->
				<div class="normal-index-header">
					<div class="container">
						<div class="content-left">
							<div class="icon-box js-header-location">
								<a href="#" class="content">
									<img src="/xinxiuli/img/tools/location.png" alt="附近门店"/> 附近门店
								</a>
							</div>
							<div class="icon-box js-header-customer" id="divde">|</div>
							<div class="icon-box js-header-customer">
								<a href="#" class="content">服务顾客</a>
							</div>
						</div>
						<div class="content-center">
							<div class="middle-top text-center">
								<a target="_self" href="/xinxiuli/index.jsp" class="middle-logo">
									<img src="/xinxiuli/img/logo/logo-black.png" />
								</a>
							</div>
							<div class="middle-bottom text-center">
						    </div>
							<form>
								<div class="active-input">
									<div class="input-group">
										<span class="icon text-center">
											<img src="/xinxiuli/img/tools/icon-header-search.png" />
										</span>
										<input type="text" placeholder="热门商品" class="rm-search-input"/>
										<span class="close-icon icon text-center">
											<img src="/xinxiuli/img/tools/close.png"/>
										</span>
									</div>
								</div>
							</form>
						    <div class="rm-show">
						    	<p>衣服</p>
						    	<p>帽子</p>
						    </div>
						</div>
						<div class="content-right">
							<div class="right-top">
								<input type="hidden" value="${accountmsg}" class="acceptmsg"></input>
								<c:if test="${account ne null}">
									<div class="top-list text-center loginafter">
										<a href="/xinxiuli/loginafter/personzl.jsp"><img alt="" src="/xinxiuli/img/tools/people.png"><span>　欢迎，</span>${account.account_num}</a><a href="/xinxiuli/tuichu">　 退出</a>
									</div>
								</c:if>
								<c:if test="${account eq null}">
									<div class="top-list text-center loginbefore">
										<a href="#" data-toggle="modal" data-target="#login">登录</a>|
										<a href="/xinxiuli/qianduanyemian/register.jsp" target="_blank">注册</a>
									</div>
								</c:if>
								<!-- 登录后样式 -->
								<div class="top-list">
									<a href="/xinxiuli/loginafter/mycolls.jsp">
										<img src="/xinxiuli/img/tools/icon-header-collection.png" />
									</a>
								</div>
								<div class="top-list top-right mycart mycart-sercher" cart-number="${account.account_num}">
									<a href="/xinxiuli/loginafter/mycart.jsp" target="_self"><img src="/xinxiuli/img/tools/package.png"/></a>
									<div class="cart-number">0</div>
								</div>
							</div>
							<div class="right-bottom">
								<div class="bottom-box">
									<div class="bottom-img">
										<img src="/xinxiuli/img/tools/icon-header-search.png" alt="搜索"/>
									</div>
									<div class="bottom-input">
										<input type="text" placeholder="热门搜索" class="input-right"/>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<!--滚动导航栏-->
				<div class="scrolled-index-header" data-spy="affix" data-offset-top="146">
					<div class="container">
						<div class="scrolled-warp">
							<div class="scrolled-logo">
								<a href="/xinxiuli/index.jsp">
									<img src="/xinxiuli/img/logo/logo-white.png" />
								</a>
							</div>
							<div class="warp-search">
								<div class="input-warp">
									<form style="height: 100%;">
										<input type="text" placeholder="热门搜索" class="search-input"/>
										<img src="/xinxiuli/img/tools/icon-header-search.png" class="input-logo"/>
									</form>
								</div>
							</div>
							<!--热门搜索展示面板-->
							<div class="warp-rm-show">
								<p>外套</p>
							</div>
							<div class="scrolled-right">
								<div class="right-warp">
									<c:if test="${account ne null}">
										<div class="right-list text-center loginafter">
											<a href="/xinxiuli/loginafter/personzl.jsp"><img alt="" src="/xinxiuli/img/tools/people.png"><span>　欢迎，</span>${account.account_num}</a><a href="/xinxiuli/tuichu">　 退出</a>
										</div>
									</c:if>
									<c:if test="${account eq null}">
										<div class="right-list text-center loginbefore">
											<a href="#" data-toggle="modal" data-target="#login">登录</a>
											<span>|</span>
											<a href="/xinxiuli/qianduanyemian/register.jsp" target="_blank">注册</a>
										</div>
									</c:if>
									<div class="right-list coll">
										<a href="/xinxiuli/loginafter/mycolls.jsp">
											<img src="/xinxiuli/img/tools/icon-header-collection.png" />
										</a>
									</div>
									<div class="right-list cart mycart-sercher" cart-number="${account.account_num}">
										<a href="/xinxiuli/loginafter/mycart.jsp" target="_self"><img src="/xinxiuli/img/tools/icon-white-shop-cart.png"/></a>
										<div class="cart-number">0</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</nav>
		
		</header>
	
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
						<li class="active">我的订单</li>
				    </ul>
				</div>
			</div>
			<div class="myoder-info-content">	
				<div class="info-l">
					<ul>
						<li><a href="/xinxiuli/loginafter/personzl.jsp">个人资料</a></li>
						<li><a href="/xinxiuli/loginafter/myaddrs.jsp">地址簿</a></li>
						<li class="active"><a href="/xinxiuli/loginafter/myorders.jsp">我的订单</a></li>
						<li><a href="/xinxiuli/loginafter/mycolls.jsp">我的收藏</a></li>
					</ul>
				</div>
				<div class="info_r">
					<h3>我的订单</h3>
					<ul class="info_r-list">
						<li class="active" data-status="0">全部<span>0</span></li>
						<li data-status="1">待付款</li>
						<li data-status="2">待发货</li>
						<li data-status="3">已发货</li>
						<li data-status="4">已取消</li>
						<li data-status="5">已退货</li>		
					</ul>
					<div class="info_r-head">
					<ul>
						<li>订单编号</li>
						<li>商品名称</li>
						<li>颜色</li>
						<li>尺寸</li>
						<li>数量</li>
						<li>快递方式</li>
						<li class='caozu'>操作</li>
					</ul>			
					</div>
		            <!--在这里获取请求的数据-->
				</div>
		  </div>
		  </div>
		<!-- 物流模态框 -->
		<div class='modal fade' id='myModal' data-backdrop='static' style="margin-top:200px;">
			<div class='modal-dialog'>
				<div class='modal-content'>
					<div class='modal-header'><h3 class='modal-title'>快递信息：<span class="close glyphicon glyphicon-remove" data-dismiss="modal"></span></h3></div>
					<div class='modal-body'><h2 style='margin-top:20px; text-align:center; margin-left:75px;'>正在等待快递揽件<span style="width:80px; display:inline-block; text-align:left; margin-left:5px;"><span></h2>
			</div>
		</div>
		</div>
		</div>
		
		<!-- 物流模态框 -->
		<div class='modal fade' id='warningIt' style="margin-top:200px;">
			<div class='modal-dialog'>
				<div class='modal-content'>
					<div class='modal-body'><h2 style='margin-top:20px; text-align:center; margin-left:75px;'>已提醒<span style="width:80px; display:inline-block; text-align:left; margin-left:5px;"><span></h2></div>
				</div>
			</div>
		</div>
		
		<!-- 物流模态框 -->
		<div class='modal fade' id='rebackIt' style="margin-top:200px;">
			<div class='modal-dialog'>
				<div class='modal-content'>
					<div class='modal-body'><h2 style='margin-top:20px; text-align:center; margin-left:75px;'>申请成功，正在等待商家处理<span style="width:80px; display:inline-block; text-align:left; margin-left:5px;"><span></h2></div>
				</div>
			</div>
		</div>

	    <!--首页尾部-->
	    <section>
    		<div class="footer">
    			<div class="container">
	    			<div class="footer-left">
	    				<div class="row">
	    					<div class="col-xs-3">
	    						<div class="title">客户服务</div>
			    				<a href="#" class="link">FAG</a>
			    				<a href="#" class="link">退货/换货</a>
			    				<a href="#" class="link">全球售后服务</a>
	    					</div>
	    					<div class="col-xs-3">
	    						<div class="title">关于新秀丽</div>
			    				<a href="#" class="link">品牌故事</a>
			    				<a href="#" class="link">媒体专区</a>
			    				<a href="#" class="link">联系我们</a>
	    					</div>
	    					<div class="col-xs-3">
	    						<div class="title">我的账户</div>
			    				<a href="#" class="link">账户首页</a>
			    				<a href="#" class="link">个人资料</a>
			    				<a href="#" class="link">我的订单</a>
	    					</div>
	    					<div class="col-xs-3">
	    						<div class="title">购物帮助</div>
			    				<a href="#" class="link">支付相关</a>
			    				<a href="#" class="link">配送</a>
			    				<a href="#" class="link">发票</a>
	    					</div>
	    				</div>
	    			</div>
	    			
	    			<div class="footer-right">
	    				<div class="right-top">
	    					<span>关注我们</span>
	    					<img src="/xinxiuli/img/tools/wechat.png" />
	    					<img src="/xinxiuli/img/tools/weibo.png" />
	    				</div>
	    				<div class="right-middle">
	    					<div class="middle-form">
	    						<img src="/xinxiuli/img/tools/email.png" />
	    						<input type="text" placeholder="输入您的邮箱获取最新优惠" class="middle-input"/>
	    						<button>订阅</button>
	    					</div>
	    				</div>
	    				<div class="right-bottom">
	    				  <div class="row">
	    				  	<div class="col-xs-6">
	    						<img src="/xinxiuli/img/tools/phone-icon.png"/>
	    						<div class="rb-div">
	    							<p class="title">4008-870-566</p>
	    							<p>周一至周日</p>
	    							<p>8：:00-12:00</p>
	    						</div>
	    					</div>
	    					<div class="col-xs-6">
	    						<img src="/xinxiuli/img/tools/message.png"/>
	    						<div class="rb-div">
	    							<p class="title">联系在线客服</p>
	    							<a>立刻联系></a>
	    						</div>	
	    					</div>
	    				  </div>
    					  <div class="row">
    						<div class="col-xs-6">
	    						<img src="/xinxiuli/img/tools/location.png"/>
	    						<div class="rb-div">
	    							<p class="title">查询精品门店</p>
	    							<a>立刻查询></a>
	    						</div>
	    					</div>
	    					<div class="col-xs-6">
	    						<img src="/xinxiuli/img/tools/phone-icon.png"/>
	    						<div class="rb-div">
	    							<p class="title">团购热线</p>
	    							<p>0574-866-966</p>
	    						</div>
	    					</div>
    					  </div>
	    				</div>
	    			</div>
    			</div>
    		</div>
	    </section>
                          
        <!--公司详情-->
 		<section>
 			<div class="footer-bottom">
 				<div class="container">
 					<div class="row">
 						<div class="left col-md-6">
 							<span>新秀丽（中国）有限公司</span>
 							<span>Copyright © 2019 Samsonite. All rights reserved</span>
 						</div>
 						<div class="right col-md-6">
 							<div class="info">
 								<a>使用条款</a>|
	 							<a>隐私条款</a>|
	 							<img src="/xinxiuli/img/tools/login.jpg" style="width: 18px;height: 18px;"/>电子营业执照
	 							<img src="/xinxiuli/img/tools/icon-ebs.png" style="width: 18px;height: 18px;"/>
	 							<a href="#">浙公网安备 33020602000173号 浙ICP备16038745号-2</a>
 							</div>
 							
 						</div>
 					</div>
 				</div>
 			</div>
 		</section>
	
	    <!--跳转至顶部-->
	    <section>
	    	<div class="box">TOP</div>
	    </section>
	    
	    <!--登录模态框-->
    	 	<div class="modal fade " id="login" data-backdrop="static" style="margin-top: 15px;">
		   <div class="modal-dialog  ">
		   	<div class="modal-content">
		   	   <div class="modal-header"> 
		   	   	 <p><span class="close" data-dismiss="modal">&times;</span></p>
		   	     <h3 class="text-center">登录新秀丽账号</h3>
		       </div>
		       
		       <div class="modal-body">
		       	 <div class="row" style="height: 320px;">
		           <div class="col-md-10 col-lg-offset-1 ">
		           
		            <!--验证码登录-->
		           	 <div  id="security-code"  style="display: none;">
		       	     <!--手机号-->
		       	     <div class="pictruecheck" >
			         <input id="phone1" type="text" autofocus="autofocus" class="form-control" placeholder="请输入手机号" />
			          <h6  style="text-align: left; color: #398439;">　</h6>
			         <span><img src="/xinxiuli/img/xxk/input-error.png" class="image-danger hidden"/></span>
			         </div>
			         <!--验证码-->
			         <div class="input-group">
			            <input   type="text" class="form-control"/>
			             <span class="input-group-btn">
			             <button class="btn btn-default"  style="color: #666;" >发送验证码</button>
			             </span>
			         </div>
			          <h6>　</h6>
			         </div>
			         
			        <!--账号密码登录-->
			         <div id="password-code" style="display: block;" >
			          <!--手机号-->
		       	     <div class="pictruecheck" >
			         <input id="phone2" type="text" autofocus="autofocus"  class="form-control" placeholder="请输入手机号" />
			         <h6  style="text-align: left; color: #398439;">　</h6>
			         <span><img src="/xinxiuli/img/xxk/input-error.png" class="image-danger hidden"/></span>
			         </div>
			         <!--密码-->
			           <div  class="pictruecheck">
			          <input id="pwd1"   type="password"  class="form-control"  placeholder="请输入密码"/>
			          <span><img src="/xinxiuli/img/xxk/input-error.png" class="image-danger hidden"/></span>   
			          <h6 style="text-align: left; color: #398439;">　</h6>
			          </div> 
			         </div>
			      
			         
			         <!-- --> 
			        <div class="form-group" style=" margin:15px 0px;">
			         <input id="checkboxid" type="checkbox" class="" style="width: 18px;height: 18px;">
			          <span style="line-height: 20px;color: #666;"  >记住密码</span>
			          <span  style="float: right;color: #666; cursor: pointer;" >找回密码</span>
			        </div>  
			        <!--登录按钮-->
			        <button  id="loginbtn"  class="form-control"   style="background: #080808; color: white; border: none;">登录账号</button>
		             <!---->
			         <div class="form-group tip" style="color: #666;">
			         <span>还不是会员？</span><a href="javascript:;">立刻加入我们</a>
			         <span id="loginselect" style="float: right; cursor: pointer;">账号密码登录</span>
			         </div>
			         <!--最后-->
			         <div class="last">
			           <span style="color: #666;">其他登录方式</span>	
			           <div class="pic-img">
			           <span style="cursor: pointer;"> <img src="/xinxiuli/img/xxk/wechat.png" /> </span>
			           <span style="cursor: pointer;"> <img src="/xinxiuli/img/xxk/qq.png" /> </span>
			           <span style="cursor: pointer;"> <img src="/xinxiuli/img/xxk/alipay.png" /> </span>
			           <span style="cursor: pointer;"> <img src="/xinxiuli/img/xxk/weibo.png" /> </span>
			           </div>
			         </div>
		       	  </div>
			     </div>
		       </div>
		   </div>		
		   </div> 
		</div>
  </body>
</html>
<script type="text/javascript" src="/xinxiuli/js/jquery.min.js" ></script>
<script type="text/javascript" src="/xinxiuli/js/bootstrap.js" ></script>
<script type="text/javascript" src="/xinxiuli/js/ljy-index.js">
<!--

//-->
</script>
<script>
(function(){
	$.ajax({
		type:"POST",
		url:"/xinxiuli/MyOrder?status=0",
		success:function(result){
			var obj=JSON.parse(result);
			$(".info_r-list>.active>span").html("("+obj.length+")");
			$(".info_r-head>.myoder").remove();
			$(".info_r-head>h2").remove();
			if(obj.length!=0){
			 for(var i=0;i<obj.length;i++){
				  switch(obj[i].order_status){
				  case 1:
					  $(".info_r-head").append("<ul class='myoder'><li class='myoder-head'>"+(i+1)+"</li><li>"+obj[i].goods_name+"</li><li>"+obj[i].color_name+"</li><li>"+obj[i].size_name+"</li><li>1</li><li>普通快递</li><li class='caozu'><button class='btn btn-default btn-sm orderit' ordernum='"+obj[i].order_num+"' onclick='buyIt(this)'>立即付款</button></li></ul>");  	
					  break;
				  case 2:
					  $(".info_r-head").append("<ul class='myoder'><li class='myoder-head' ordernum='"+obj[i].order_num+"'>"+(i+1)+"</li><li>"+obj[i].goods_name+"</li><li>"+obj[i].color_name+"</li><li>"+obj[i].size_name+"</li><li>1</li><li>普通快递</li><li class='caozu'><button class='btn btn-default btn-sm' onclick='warningIt(this)'>提醒发货</button> <button class='btn btn-sm btn-default' onclick='rebackIt(this)'>申请退款</button></li></ul>");  
					  break;
				  case 3:
					  $(".info_r-head").append("<ul class='myoder'><li class='myoder-head' ordernum='"+obj[i].order_num+"'>"+(i+1)+"</li><li>"+obj[i].goods_name+"</li><li>"+obj[i].color_name+"</li><li>"+obj[i].size_name+"</li><li>1</li><li>普通快递</li><li class='caozu'><button class='btn btn-sm' style='color:white; background-color:#222;' onclick='looklogist()' data-toggle='modal' data-target='#myModal'>查看物流</button></ul>");  
					  break;
				  case 4:
					  $(".info_r-head").append("<ul class='myoder'><li class='myoder-head' ordernum='"+obj[i].order_num+"'>"+(i+1)+"</li><li>"+obj[i].goods_name+"</li><li>"+obj[i].color_name+"</li><li>"+obj[i].size_name+"</li><li>1</li><li>普通快递</li><li class='caozu'><button class='btn btn-primary btn-sm'>查看更多</button>");  
					  break;
				  case 5:
					  $(".info_r-head").append("<ul class='myoder'><li class='myoder-head' ordernum='"+obj[i].order_num+"'>"+(i+1)+"</li><li>"+obj[i].goods_name+"</li><li>"+obj[i].color_name+"</li><li>"+obj[i].size_name+"</li><li>1</li><li>普通快递</li><li class='caozu'><button class='btn btn-primary btn-sm' onclick='warningIt(this)'>提醒发货</button><button class='btn btn-danger btn-sm' onclick='rebackIt(this)'>申请退款</button></li></ul>");  
					  break;
			  }
		}
		}else{
			$(".info_r").append("<h2 style='text-align:center;'>亲，暂无该类型订单</h2>");
		 }
		}
	});
	})();
	$('.info_r>.info_r-list>li').click(function(){
		$(this).addClass("active").siblings().removeClass("active");
		var sta=$(this).attr("data-status");
		$.ajax({
			type:"POST",
			url:"/xinxiuli/MyOrder?status="+sta,
			success:function(result){
				//$(this).parent().siblings().remove();
				if(result!=null){
					var obj=JSON.parse(result);
					$(".info_r-head>.myoder").remove();
					$(".info_r>h2").remove();
				if(obj.length!=0){
				  for(var i=0;i<obj.length;i++){
					  var aa=obj[i].order_status;
					  switch(obj[i].order_status){
					  case 1:
						  $(".info_r-head").append("<ul class='myoder'><li class='myoder-head'>"+(i+1)+"</li><li>"+obj[i].goods_name+"</li><li>"+obj[i].color_name+"</li><li>"+obj[i].size_name+"</li><li>1</li><li>普通快递</li><li class='caozu'><button class='btn btn-default btn-sm orderit' ordernum='"+obj[i].order_num+"' onclick='buyIt(this)'>立即付款</button></li></ul>");  
					  	  break;
					  case 2:
						  $(".info_r-head").append("<ul class='myoder'><li class='myoder-head' ordernum='"+obj[i].order_num+"'>"+(i+1)+"</li><li>"+obj[i].goods_name+"</li><li>"+obj[i].color_name+"</li><li>"+obj[i].size_name+"</li><li>1</li><li>普通快递</li><li class='caozu'><button class='btn btn-default btn-sm' onclick='warningIt(this)'>提醒发货</button> <button class='btn btn-default btn-sm' onclick='rebackIt(this)'>申请退款</button></li></ul>");  
						  break;
					  case 3:
						  $(".info_r-head").append("<ul class='myoder'><li class='myoder-head' ordernum='"+obj[i].order_num+"'>"+(i+1)+"</li><li>"+obj[i].goods_name+"</li><li>"+obj[i].color_name+"</li><li>"+obj[i].size_name+"</li><li>1</li><li>普通快递</li><li class='caozu'><button class='btn btn-primary btn-sm' style='color:white; background-color:#222;' onclick='looklogist()' data-toggle='modal' data-target='#myModal'>查看物流</button></ul>");  
						  break;
					  case 4:
						  $(".info_r-head").append("<ul class='myoder'><li class='myoder-head' ordernum='"+obj[i].order_num+"'>"+(i+1)+"</li><li>"+obj[i].goods_name+"</li><li>"+obj[i].color_name+"</li><li>"+obj[i].size_name+"</li><li>1</li><li>普通快递</li><li class='caozu'><button class='btn btn-primary btn-sm'>查看更多</button>");  
						  break;
					  case 5:
						  $(".info_r-head").append("<ul class='myoder'><li class='myoder-head' ordernum='"+obj[i].order_num+"'>"+(i+1)+"</li><li>"+obj[i].goods_name+"</li><li>"+obj[i].color_name+"</li><li>"+obj[i].size_name+"</li><li>1</li><li>普通快递</li><li class='caozu'><button class='btn btn-primary btn-sm' onclick='warningIt(this)'>提醒发货</button><button class='btn btn-danger btn-sm' onclick='rebackIt(this)'>申请退款</button></li></ul>");  
						  break;
				  }
				  }
				  }else{
					  $(".info_r").append("<h2 style='text-align:center; margin:30px 0px 30px;'>亲，暂无该类型订单</h2>"); 
					  }			
				  }
			}
		});	
	});
	//查看物流
	var timer;
	function looklogist(){
		var n=0;
	  timer=setInterval(function(){	
    		n++;
    		switch (n){
    		   case 1:
  			     $("#myModal .modal-body span").html("。");
  				break;
    			case 2:
    			  $("#myModal .modal-body span").html("。。");
    				break;
    			case 3:
    			  $("#myModal .modal-body span").html("。。。");
    			  n=0;
    				break;
    		}	
    	},800);
	}
	$("#myModal .modal-header .close").click(function(){
		clearInterval(timer);
	});
	$('.box').click(function(){
		$('html').animate({'scrollTop':0},500);
	});
    function buyIt(obj){
    	var ordernum = obj.getAttribute("ordernum");
    	$.ajax({
    		type:"POST",
    		url:"/xinxiuli/buyGoods",
    		data:"ordernum="+ordernum,
    		success:function(result){
    			alert(result);
    			if("true"==(result)){
    				location.reload();
    			};
    		},
    	});
    }
    function warningIt(obj){
    	$("#warningIt").modal("show");
    }
    function rebackIt(obj){
    	$("#rebackIt").modal("show");
    }
    
</script>
