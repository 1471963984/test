<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>我的地址簿</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="/xinxiuli/css/bootstrap.css" />
	<link rel="stylesheet" href="/xinxiuli/css/PersonAllPageHeader.css"/>
	<link rel="stylesheet" href="/xinxiuli/css/PersonAllPageFooter.css"/>
	<link rel="stylesheet" href="/xinxiuli/css/myaddrs.css" />
	
  </head>
  
	<body>
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
									<a href="/xinxiuli/qianduanyemian/mycart.jsp" target="_self"><img src="/xinxiuli/img/tools/package.png"/></a>
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
										<a href="/xinxiuli/qianduanyemian/mycart.jsp" target="_self"><img src="/xinxiuli/img/tools/icon-white-shop-cart.png"/></a>
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
						<li class="active">地址簿</li>
				    </ul>
				</div>
			</div>
			<div class="info-addr-content">
				<div class="info-l">
					<ul>
						<li>账户首页</li>
						<li><a href="/xinxiuli/loginafter/personzl.jsp">个人资料</a></li>
						<li class="active"><a href="/xinxiuli/loginafter/myaddrs.jsp">地址簿</a></li>
						<li><a href="/xinxiuli/loginafter/myorders.jsp">我的订单</a></li>
						<li><a href="/xinxiuli/loginafter/mycolls.jsp">我的收藏</a></li>
						<li>客户服务</li>
					</ul>
				</div>
				<div class="info_r">
					<div id="addmyaddrs">
						<ul>
							<li>
								<div class="title-about">地址簿</div>
								<button class="btn btn-block btn-default">
									<a href="/xinxiuli/loginafter/addmyaddrs.jsp" onclick="tianjiadizhi()" />
										<span class="btn-add">+</span>
										&nbsp;&nbsp;添加收货地址
									</a>
								</button>
							</li>
						</ul>
					</div>
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
			         <input type="checkbox" class="" style="width: 18px;height: 18px;">
			          <span style="line-height: 20px;color: #666;"  >记住用户名</span>
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
<script src="/xinxiuli/js/jquery-1.11.0.js" type="text/javascript" charset="utf-8"></script>
<script src="/xinxiuli/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<script src="/xinxiuli/js/ljy-index.js"></script>
<script src="/xinxiuli/js/xxk-login.js"></script>
<script>
//设置默认地址
function insetAdd(){
$(".addrs-setdefault").click(function(){
	$(this).removeClass("addrs-setdefault addrs-default").addClass("addrs-default").html("默认地址").parent().siblings(".addrs-list").children("button").removeClass("addrs-default addrs-setdefault").addClass("addrs-setdefault").html("设为默认");
	$.ajax({
		type:"POST",
		url:"/xinxiuli/updateMyAddres?index="+$(this).attr("data-index"),
		success:function(result){
		   location.reload();
		}
	});
});
};

	//称谓下拉菜单
	$('.dropdown-menu li').click(function(){
		var a = $(this).html();
		$('.chengwei').val($(this).html());
	});
	
(function(){
	$.ajax({
		type:"POST",
		url:"/xinxiuli/showmyaddrs",
		success:function(result){
			var pho=result[0];
			var names=result[1];
			var  nick=result[2];
			var addrs=result[3];
			var email=result[4];
			var index=result[5];
			for (var i =0; i<pho.length; i++) {
				if(i==index){
					if(i==0){
						$("#addmyaddrs").append("<div class='addrs-list'><div class='caozuo'><img class='addrs-edit' src='/xinxiuli/shop-imgs/address-edit.png'/><img class='goods-delete' title='删除地址' data-addrnum='"+i+"' src='/xinxiuli/shop-imgs/delete.png'></img></div><div class='name ch-left'><p>"+names[i]+"</p></div><div class='phone mbtel'>手机号："+pho[i]+"</div><div class='chengwei ch-left'>"+nick[i]+"</div><div class='addrs-message'>"+addrs[i]+"</div><button class='addrs-default' data-index='"+i+"'>默认地址</button></div></div>");
					}else{
						$("#addmyaddrs .addrs-list:first").before("<div class='addrs-list'><div class='caozuo'><img class='addrs-edit' src='/xinxiuli/shop-imgs/address-edit.png'/><img class='goods-delete' title='删除地址' data-addrnum='"+i+"' src='/xinxiuli/shop-imgs/delete.png'></img></div><div class='name ch-left'><p>"+names[i]+"</p></div><div class='phone mbtel'>手机号："+pho[i]+"</div><div class='chengwei ch-left'>"+nick[i]+"</div><div class='addrs-message'>"+addrs[i]+"</div><button class='addrs-default' data-index='"+i+"'>默认地址</button></div></div>");
					}		
				}else{
					$("#addmyaddrs").append("<div class='addrs-list'><div class='caozuo'><img class='addrs-edit' src='/xinxiuli/shop-imgs/address-edit.png'/><img class='goods-delete' title='删除地址' data-addrnum='"+i+"' src='/xinxiuli/shop-imgs/delete.png'></img></div><div class='name ch-left'><p>"+names[i]+"</p></div><div class='phone mbtel'>手机号："+pho[i]+"</div><div class='chengwei ch-left'>"+nick[i]+"</div><div class='addrs-message'>"+addrs[i]+"</div><button class='addrs-setdefault' data-index='"+i+"'>设为默认</button></div></div>");	
				}
			}
			insetAdd();
			deleaddr();
		}
	});
})();
  //点击删除按钮
  function deleaddr(){
	  $(".goods-delete").click(function(){
		  if(confirm("您确定要删除该收获地址吗?")){
			  var addrid=$(this).attr("data-addrnum");
			  var obj=$(this);
			  $.ajax({
				  url:"/xinxiuli/deleteAddres?addrindex="+addrid,
				  success:function(result){
					  if(result=="true"){
						  obj.parent().parent().remove(); 
					  }
				  }
			  });
		  }
	  });
  }
  

</script>
