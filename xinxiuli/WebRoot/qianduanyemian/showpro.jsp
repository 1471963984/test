<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>产品展示</title>
		<meta name="viewport" content="width=device-width,initial-scale=1" />
		<link rel="stylesheet" href="/xinxiuli/css/bootstrap.css" />
		<link rel="stylesheet" href="/xinxiuli/css/ljy-index-showpro.css" />
		<link rel="stylesheet" href="/xinxiuli/css/xxk-login.css" />
	</head>
	<body>
		<!--首页头部-->
		<header>
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
										<img src="/xinxiuli/img/tools/icon-header-collection.png" onclick="checklogin()" />
								</div>
								<div class="top-list top-right mycart mycart-sercher" cart-number="${account.account_num}">
									<img src="/xinxiuli/img/tools/package.png" onclick="checklogins()" />
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
											<img src="/xinxiuli/img/tools/icon-header-collection.png" onclick="checklogin()" />
									</div>
									<div class="right-list cart mycart-sercher" cart-number="${account.account_num}">
										<img src="/xinxiuli/img/tools/package.png" onclick="checklogins()" />
										<div class="cart-number">0</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</nav>
		</header>
	
	    <!-- 首页头部 -->
	          <section class="con-div">
         	<div class="container">
	         	<div class="row con-row">
	         		<div class="row-left col-md-9">
	         			<div class="divied-brandnav">
	         				<span><a href="/xinxiuli/index.jsp">首页</a></span>
	         				<span>|</span>　
	         				<span onclick="showAll()">新秀丽</span>
	         			</div>
	         		</div>
	         		<div class="row-right col-md-3">
	         			<div class="condition-btn">
	         				<span class="condition-text">筛　选</span>
	         			</div>
	         		</div>
	         	</div>
	         	<hr/>
	         	<div class="showCondition">
         			<div class="condition">
         				<span>价格</span>
         				<div class="condition-price">
         					<div class="unit">
         						<span>￥0-1500</span><input type="radio" name="price" value="0,1500" />
         					</div>
         					<div class="unit">
         						<span>￥1500-4000</span><input type="radio" name="price" value="1500,4000" />
         					</div>
         					<div class="unit">
         						<span>￥4000以上</span><input type="radio" name="price" value="4000,0" />
         					</div>
         				</div>
         			</div>
         			<div class="condition">
         				<span>角色</span>
         				<div class="condition-cols">
         					<div class="unit">
         						<span>儿　童</span><input type="radio" name="cols"  value="儿童" />
         					</div>
         					<div class="unit">
         						<span>男　士</span><input type="radio" name="cols" value="男士" />
         					</div>
         					<div class="unit">
         						<span>女　士</span><input type="radio" name="cols" value="女士" />
         					</div>
         				</div>
         			</div>
     				<div class="condition">
         				<span>热度</span>
         				<div class="condition-pop">
         					<div class="unit">
         						<span>0-199</span><input type="radio" name="color" value="0,199" />
         					</div>
         					<div class="unit">
         						<span>200-399</span><input type="radio" name="color" value="200,399" />
         					</div>
         					<div class="unit">
         						<span>400以上</span><input type="radio" name="color" value="400,0" />
         					</div>
         				</div>
         			</div>
         			<div class="condition">
         				<div class="caozuo">
         					<div class="cancle">取　消</div>
         					<div class="find">查　找</div>
         					<div class="reset">重　置</div>
         				</div>
         			</div>
	         	</div>
         	</div>
         </section>  
	
	    
	    <!--商品展示区-->
	    <section>
	    	<div class="container">
	    		<div class="row"  id="goodsList">
	    		<!-- 隐藏表单域决定是否展示商品 -->
	    		<input type="hidden" class="showMessage" value="${show}"></input>
	    		 <c:if test="${goodsList ne null}">
	    		 	<c:forEach items="${goodsList}" var="goods">
	    		 		 <div class="col-md-3 thumbnail-div">
							 <div class="thumbnail">
								 <a href="/xinxiuli/Show?gid=${goods.goods_num}" target="_self"><img src="${goods.goods_picture}"/></a>
								 <caption>
									 <p class="goods-name">${goods.goods_name}</p>
									 <p class="goods-desc">${goods.goods_desc}</p>
									 <p>¥　${goods.goods_price}.00</p>
									 <p><span class="glyphicon  glyphicon-star"></span>${goods.goods_star}</p>
								</caption>
							 </div>
						 </div>
	    		 	</c:forEach>
	    		 </c:if>
	    		</div>
	    	</div>
	    </section>
	    
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
<script src="/xinxiuli/js/xxk-login.js"></script>
<script type="text/javascript" src="/xinxiuli/js/ljy-showpro.js" ></script>
<script type="text/javascript" src="/xinxiuli/js/ljy-index.js" ></script>
<script>
	function checklogin(){
		var account_num = $(".mycart-sercher").attr("cart-number");
		if(account_num==""){
		$('#login').modal('show');
		}else if(account_num!=null&&account_num!="undefined"){
			location.href="/xinxiuli/loginafter/mycolls.jsp";
		}
	}
	function checklogins(){
		var account_num = $(".mycart-sercher").attr("cart-number");
		if(account_num==""){
		$('#login').modal('show');
		}else if(account_num!=null&&account_num!="undefined"){
			location.href="/xinxiuli/loginafter/mycart.jsp";
		}
	}
	$(".condition-text").click(function(){
		$(".showCondition").fadeIn();
	});
	$(".condition>.caozuo>.cancle").click(function(){
		$(".showCondition").fadeOut();
	});
	$(".condition>.caozuo>.find").click(function(){
		var pop;
		var price;
		var goods_desc;
		$(".condition-price input").each(function(i){
			if($(this).prop("checked")==true){
			price = $(this).val();			
			}
		});
		$(".condition-cols input").each(function(i){
			if($(this).prop("checked")==true){
			goods_desc = $(this).val();			
			}
		});
		$(".condition-pop input").each(function(i){
			if($(this).prop("checked")==true){
			pop = $(this).val();			
			}
		});
		$.ajax({
			type:"POST",
			url:"/xinxiuli/goodscon",
			data:"price="+price+"&pop="+pop+"&goods_desc="+goods_desc,
			success:function(result){
				$('#goodsList').empty();
				if(result.length==0){
					var str1 = `
						 <div class="col-md-12 blank content-center">
						 <h1>商家正在努力上架中……</h1>
						 </div>
						 `;
					 $('#goodsList').append(str1); 
				}else{
					for(var i = 0; i < result.length; i++){
						 var str = "<div class='col-md-3 thumbnail-div'><div class='thumbnail'><a href='/xinxiuli/Show?gid="+result[i].goods_num+"' target='_self'><img src='"+result[i].goods_picture+"'/></a><caption><p class='goods-name'>"+result[i].goods_name+"</p><p class='goods-desc'>"+result[i].goods_desc+"</p><p>¥　"+result[i].goods_price+".00</p><p><span class='glyphicon  glyphicon-star'></span>"+result[i].goods_star+"</p></caption></div></div>";
						 //每遍历一次就要去添加一次
						 $('#goodsList').append(str);
						 getFocus(); 
					}
				}
			},
		});
		
	});
	$(".reset").click(function(){
		$(".condition-price input").each(function(i){
			if($(this).prop("checked")==true){
				$(this).prop("checked",false);			
			}
		});
		$(".condition-cols input").each(function(i){
			if($(this).prop("checked")==true){
				$(this).prop("checked",false);			
			}
		});
		$(".condition-pop input").each(function(i){
			if($(this).prop("checked")==true){
				$(this).prop("checked",false);			
			}
		});
	});
</script>
