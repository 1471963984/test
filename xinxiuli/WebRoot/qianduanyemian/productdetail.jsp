<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>productdel</title>
		<meta name="viewport" content="width=device-width initial-scale=1" />
		<link rel="stylesheet" type="text/css" href="/xinxiuli/css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="/xinxiuli/css/animate.css"/>
		<link rel="stylesheet" type="text/css" href="/xinxiuli/css/dcf-shopdetail.css"/>
		<link rel="stylesheet" href="/xinxiuli/css/xxk-login.css"/>
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
									<a target="_self" href="#" class="middle-logo">
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
									<div class="top-list text-center">
										<a href="#" data-toggle="modal" data-target="#login">登录</a>|
										<a href="/xinxiuli/qianduanyemian/register.jsp" target="_blank">注册</a>
									</div>
									<div class="top-list">
										<a href="#">
											<img src="/xinxiuli/img/tools/icon-header-collection.png" />
										</a>
									</div>
									<div class="top-list top-right">
										<a href="/xinxiuli/qianduanyemian/mycart.jsp" target="_blank"><img src="/xinxiuli/img/tools/package.png"/></a>
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
									<a href="#">
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
										<div class="right-list text-center">
											<a href="#" data-toggle="modal" data-target="#login">登录</a>
											<span>|</span>
											<a href="/xinxiuli/qianduanyemian/register.jsp" target="_blank">注册</a>
										</div>
										<div class="right-list">
											<a href="#">
												<img src="/xinxiuli/img/tools/icon-header-collection.png" />
											</a>
										</div>
										<div class="right-list">
											<a href="/xinxiuli/qianduanyemian/mycart.jsp" target="_blank"><img src="/xinxiuli/img/tools/icon-white-shop-cart.png"/></a>
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
		<div class="container" id="info">
		</div>
		
		<!--中间部分-->
		<div id="model">
			<img src="/xinxiuli/img/productdel/model.jpg"/>	
		</div>
		<div class="container" id="produ">
			<div class="produ-l">
				<img src="/xinxiuli/img/productdel/5.jpg"/>
			</div>
			<div class="produ-r">
				<h6>时尚潮人之选</h6>
				<h3>优雅而独特的回形纹路，简约时尚现代，箱体采用镁铝合金材质，结实坚韧质感十足，轻量化设计</h3>
				<hr />
				<p>产品信息</p>
				<div class="produ-list">
					<ul>
						<li>便捷式地址牌</li>
						<li>TSA固定密码锁</li>
						<li>顺滑滚轮网状隔层</li>
						<li>蝶形打包带</li>
						<li>拆卸打包隔板</li>
					</ul>
					<ul>
						<li>精选铝镁合金材质</li>
						<li>赠送搭配箱套</li>
						<li>轻量化设计</li>
						<li>结实坚韧耐压</li>
						<li>加固铆钉，耐磨侧珠</li>
						<li>轻质牢固拉杆</li>
					</ul>
					<ul>
						<li>精致品牌LOGO</li>
						<li>425*630*270（MM）</li>
						<li>全球联保：10年质保</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="container" id="size">
			<img src="/xinxiuli/img/productdel/6.jpg"/>
			<button class="btn  btn-lg two">23英寸</button>
			<button class="btn btn-info btn-lg one">20英寸</button>	
		</div>
		<div class="size-bot">
			<span><img src="/xinxiuli/img/productdel/13.jpg"/>
			     <div class="subsize-bot">
			     	 <span><img src="/xinxiuli/img/productdel/icon-03.png"/>
			     	       <p>顺滑滚轮</p>
			     	       <h6>360°静音滑轮，轻推省力探索更多</h6>
			     	       <h6><a href="">探索更多</a></h6>
			     	 </span>
			     </div>
			</span>
			<span><img src="/xinxiuli/img/productdel/13.jpg"/>
			     <div class="subsize-bot">
			     	  <span><img src="/xinxiuli/img/productdel/icon-03.png"/>
			     	       <p>顺滑滚轮</p>
			     	       <h6>360°静音滑轮，轻推省力探索更多</h6>
			     	       <h6><a href="">探索更多</a></h6>
			     	 </span>
			     </div>
			</span>
			<span><img src="/xinxiuli/img/productdel/13.jpg"/>
			     <div class="subsize-bot">
			     	  <span><img src="/xinxiuli/img/productdel/icon-03.png"/>
			     	       <p>顺滑滚轮</p>
			     	       <h6>360°静音滑轮，轻推省力探索更多</h6>
			     	       <h6><a href="">探索更多</a></h6>
			     	 </span>
			     </div>
			</span>
			<span><img src="/xinxiuli/img/productdel/13.jpg"/>
			     <div class="subsize-bot">
			     	  <span><img src="/xinxiuli/img/productdel/icon-03.png"/>
			     	       <p>顺滑滚轮</p>
			     	       <h6>360°静音滑轮，轻推省力探索更多</h6>
			     	       <h6><a href="">探索更多</a></h6>
			     	 </span>
			     </div>
			</span>
		</div>
		<div id="remcommend">
			<h2>我们为您推荐  
			    <div class="subremo">
			    	<h4>为您推荐</h4>
			    </div>
			</h2>
			<hr />
			<ul>
				<a href="#"><li><img src="/xinxiuli/img/productdel/9.jpg"/>
				   <div class="subremcom-list animated fadeIn">
				   	 <p>新秀丽明星同款拉杆箱 专柜经典贝壳箱坚韧轻盈登机箱万向轮行李箱包25英寸 V22</p>
				   	 <button class="btn btn-info btn-sm">查看详情</button>
				   </div>
				</li></a>
				<a href="#"><li><img src="/xinxiuli/img/productdel/10.jpg"/>
					<div class="subremcom-list animated fadeIn">
				   	 <p>新秀丽明星同款拉杆箱 专柜经典贝壳箱坚韧轻盈登机箱万向轮行李箱包25英寸 V22</p>
				   	 <button class="btn btn-info btn-sm">查看详情</button>
				   </div>
				</li></a>
				<a href="#"><li><img src="/xinxiuli/img/productdel/11.jpg"/>
					<div class="subremcom-list animated fadeIn">
				   	 <p>新秀丽明星同款拉杆箱 专柜经典贝壳箱坚韧轻盈登机箱万向轮行李箱包25英寸 V22</p>
				   	 <button class="btn btn-info btn-sm">查看详情</button>
				   </div>
				</li></a>
				<a href="#"><li><img src="/xinxiuli/img/productdel/12.jpg" />
					<div class="subremcom-list animated fadeIn">
				   	 <p>新秀丽明星同款拉杆箱 专柜经典贝壳箱坚韧轻盈登机箱万向轮行李箱包25英寸 V22</p>
				   	 <button class="btn btn-info btn-sm">查看详情</button>
				   </div>
				</li></a>
			</ul>
		</div>
		<div id="like">
			<div class="like-bg">
			<h2>您可能喜欢  
			    <div class="sublike">
			    	<h4>猜您喜欢</h4>
			    </div>
			</h2>
			<hr />
			<ul>
				<li class="currnt">
					<a href="#"><img src="/xinxiuli/img/productdel/13.jpg"/>
				   	   <div class="sublike-list animated fadeIn">
				   	 	<p>新秀丽明星同款拉杆箱 专柜经典贝壳箱坚韧轻盈登机箱万向轮行李箱包25英寸 V22</p>
				   	 	<button class="btn btn-info btn-sm">查看详情</button>
				   	   </div>
					</a>
					<a href="#"><img src="/xinxiuli/img/productdel/14.jpg"/>
				   	   <div class="sublike-list animated fadeIn">
				   	 	<p>新秀丽明星同款拉杆箱 专柜经典贝壳箱坚韧轻盈登机箱万向轮行李箱包25英寸 V22</p>
				   	 	<button class="btn btn-info btn-sm">查看详情</button>
				   	   </div>
					</a>
					<a href="#"><img src="/xinxiuli/img/productdel/15.jpg"/>
				   	   <div class="sublike-list animated fadeIn">
				   	 	<p>新秀丽明星同款拉杆箱 专柜经典贝壳箱坚韧轻盈登机箱万向轮行李箱包25英寸 V22</p>
				   	 	<button class="btn btn-info btn-sm">查看详情</button>
				   	   </div>
					</a>
					<a href="#"><img src="/xinxiuli/img/productdel/16.jpg"/>
				   	   <div class="sublike-list animated fadeIn">
				   	 	<p>新秀丽明星同款拉杆箱 专柜经典贝壳箱坚韧轻盈登机箱万向轮行李箱包25英寸 V22</p>
				   	 	<button class="btn btn-info btn-sm">查看详情</button>
				   	   </div>
					</a>
				</li>
				<li>
					<a href="#"><img src="/xinxiuli/img/productdel/17.jpg"/>
				   	   <div class="sublike-list animated fadeIn">
				   	 	<p>新秀丽新品拉杆箱 时尚外观铝质双拉杆旅行箱飞机轮登机箱20英寸可扩展大容量行李箱 GE6</p>
				   	 	<button class="btn btn-info btn-sm">查看详情</button>
				   	   </div>
					</a>
					<a href="#"><img src="/xinxiuli/img/productdel/16.jpg"/>
				   	   <div class="sublike-list animated fadeIn">
				   	 	<p>新秀丽新品拉杆箱 时尚外观铝质双拉杆旅行箱飞机轮登机箱20英寸可扩展大容量行李箱 GE6</p>
				   	 	<button class="btn btn-info btn-sm">查看详情</button>
				   	   </div>
					</a>
					<a href="#"><img src="/xinxiuli/img/productdel/15.jpg"/>
				   	   <div class="sublike-list animated fadeIn">
				   	 	<p>新秀丽新品拉杆箱 时尚外观铝质双拉杆旅行箱飞机轮登机箱20英寸可扩展大容量行李箱 GE6</p>
				   	 	<button class="btn btn-info btn-sm">查看详情</button>
				   	   </div>
					</a>
					<a href="#"><img src="/xinxiuli/img/productdel/14.jpg"/>
				   	   <div class="sublike-list animated fadeIn">
				   	 	<p>新秀丽新品拉杆箱 时尚外观铝质双拉杆旅行箱飞机轮登机箱20英寸可扩展大容量行李箱 GE6</p>
				   	 	<button class="btn btn-info btn-sm">查看详情</button>
				   	   </div>
					</a>
				</li>
			  </ul>
			  
			  <span class="active"></span> <span></span>
			</div>
		</div>
		
		<!--尾部样式-->
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
 		
	    <!--跳转顶部-->
	    <div class="box">TOP</div>
	    
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
		           	 <div  id="security-code"  style="display: block;">
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
			         <div id="password-code" style="display: none;" >
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
<script src="/xinxiuli/js/dcf-shop-detail.js" type="text/javascript" charset="utf-8"></script>
<script src="/xinxiuli/js/ljy-index.js"></script>
<script src="/xinxiuli/js/xxk-login.js"></script>

