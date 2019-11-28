<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>我的购物车</title>
		<meta name="viewport" content="width=device-width,initial-scale=1" />
		<link rel="stylesheet" href="/xinxiuli/css/cgp-mycart.css" type="text/css"/>
		<link rel="stylesheet" href="/xinxiuli/css/bootstrap.css" />
		<link rel="stylesheet" href="/xinxiuli/css/cgp-header-footer-base.css" />
		<link rel="stylesheet" href="/xinxiuli/css/xxk-login.css" />
		
			<style>
				#myModal{
					width: 1200px;height: 686px;
					margin: 0 auto;
					color: #222;
				}
				.modal-dialog{
					width: 1200px;height: 686px;
				}
				.modal-content{
					width: 1200px;height: 686px;
				}
				.modal-header{
					width: 1200px;height: 34px;
				}
				.modal-body{
					width: 1200px;height: 686px;
				}
				.modal-title{
					color: black;
				}
				.close{
					width: 20px;
					height: 20px;
				}
		</style>
	</head>
	<body data-spy="scroll">
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
								<c:if test="${account ne null}">
									<div class="top-list text-center loginafter">
										<a href="/xinxiuli/qianduanyemian/personzl.jsp"><img alt="" src="/xinxiuli/img/tools/people.png"><span>　欢迎，</span>${account.account_num}</a><span class="out">　 退出</span>
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
									<a href="#">
										<img src="/xinxiuli/img/tools/icon-header-collection.png" />
									</a>
								</div>
								<div class="top-list top-right mycart">
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
											<a href="/xinxiuli/qianduanyemian/personzl.jsp"><img alt="" src="/xinxiuli/img/tools/people.png"><span>　欢迎，</span>${account.account_num}</a><span class="out">　 退出</span>
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
										<a href="#">
											<img src="/xinxiuli/img/tools/icon-header-collection.png" />
										</a>
									</div>
									<div class="right-list cart">
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
	
		<!--购物车-->
		<div class="main-container">
			<div class="main-left">
				<div class="cart-name">
                    <div class="title">我的购物车</div>
                	<div class="desc">
                    	    全场满500包邮
                    </div>
                </div>
                <div class="cart-goods">
	                <div class="goods-title">
	                	商品信息
	                </div>
	                <div class="goods-list-box">
            	<c:forEach items="${goodslist }" var="goodsList" varStatus="i" >
	                	<div class="goods-list-js">
            		<div class="list-box">
	            		<div class="goods-message">
	            			<input type="checkbox" class="checkbox" />
	            			<span class="lazyload"><img src="${goodsList.goods_img}"/></span>
	            			<div class="goods-about">
	            				<a href="javascript:;" >${goodsList.goods_desc}</a>
	            				<div class="goods-brand">${goodsList.goods_name}</div>
	            				<div class="goods-spec">
	                				<label>颜色：</label>
	                				<p>${goodsList.goods_color}</p>
	                				<label>尺寸：</label>
	                				<p>${goodsList.goods_size}</p>
	                			</div>
	                			<div class="goods-operation">
	                				<img src="/xinxiuli/shop-imgs/collection-no.png" alt="移入收藏夹" />
	                				<div class="goods-middle">|</div>
	                				<img src="/xinxiuli/shop-imgs/edit.png" alt="编辑商品" data-toggle="modal" data-target="#myModal" />
	                			</div>
	            			</div>
	            		</div>
	            		<div class="sell-srice">${goodsList.goods_price}0</div>
	            		<div class="goods-delete" title="删除商品"></div>
        			</div>
        	</div>
            	</c:forEach>
	                </div>
                	<div class="goods-card">
                		<div class="card-left">
                			<input type="checkbox" class="cartcheckbox" />
                			<div class="card-left-top-title">移除选中商品</div>
                			<div class="card-bottom-bottom">继续购物</div>
                		</div>
                		<div class="card-right">
                			<div class="message-list-subtotal">
                				<label>小计</label>
                				<p>¥ 0.00</p>
                			</div>
                			<div class="message-list-discount">
                				<label>优惠</label>
                				<p>-¥ 0.00</p>
                			</div>
                			<div class="message-list-total">
                				<label>总计</label>
                				<p>¥ 0.00</p>
                			</div>
                			<button class="btn btn-block btn-primary" onclick="window.location.href = '/xinxiuli/qianduanyemian/Jiesuan.jsp'">立即结算</button>
                		</div>
                	</div>
                </div>
			</div>
			<div class="main-right">
				<div class="right-list">
					<div class="list-title">
						<img src="/xinxiuli/shop-imgs/service.png" alt="客服" />
						<div class="title-about">需要帮助</div>
						<div class="list-content">
							<div class="content-phone">4008-870-566</div>
							<div class="list-time">周一至周日：8：00—21：00</div>
							<div class="content-link-title">联系在线客服</div>
							<div class="content-link"><a href="#">立即联系</a></div>
						</div>
					</div>
					<!--return policy-->
	                <div class="right-list-top">
	                    <div class="list-title">
	                        <img src="/xinxiuli/shop-imgs/exchange.png"alt="退换货">
	                        <div class="title-about">退换货政策</div>
	                    </div>
	                    <div class="list-content">
	                        <div class="content-desc" id="exchange">
                        	敬请查阅我们的<span>
		                        		<a target="_blank"href='/s/faq-return-goods'>退换货政策</a>
		                        	</span>
                        	以获取更多详情。
	                        </div>
	                    </div>
	                </div>
	                
	                <!--======-->
	                <div class="right-list-middle">
	                    <div class="list-title">
	                        <img src="/xinxiuli/shop-imgs/distribution.png"alt="配送货">
	                        <div class="title-about">配送政策</div>
	                    </div>
	                    <div class="list-content">
	                        <div class="content-desc" id="exchange">
	                        	我们默认发送顺丰快递。敬请查阅我们的
                        	<span>
                        		<a target="_blank"href='/s/faq-return-goods'>配送</a>
                        	</span>
                        	以获取更多信息。
	                        </div>
	                    </div>
	                </div>
	                
	                <!---->
	                 <div class="right-list-bottom">
	                    <div class="list-title">
	                        <img src="/xinxiuli/shop-imgs/payment.png"alt="支付方式">
	                        <div class="title-about">支付方式</div>
	                    </div>
	                    <div class="list-content" id="zhifu">
	                        <img src="/xinxiuli/shop-imgs/zhifubao.png" />
	                        <img src="/xinxiuli/shop-imgs/weChat1.png" />
	                        <img src="/xinxiuli/shop-imgs/bank.png" />
	                    </div>
	                </div>
				</div>
			</div>
		</div>
		
		
		<!--购物车底部商品推荐-->
		<div class="main-bottom">
			<div class="bottom-title">
				<div class="title">您可能喜欢</div>
				<div class="title-about">
					<div class="about-line1"></div>
					<div class="about-middle">猜您喜欢</div>
					<div class="about-line2"></div>
				</div>
				<div class="cgp-container">
					<div class="item-active">
						<!--第一块轮播图-->
						<div class="container">
							<div class="goods-tuijian">
							</div>
						</div>
					</div>
					<!--轮播按钮-->
					<div class="number">
						<span class="current">1</span>
						<span>2</span>
						<span>3</span>
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
	    						<input type="text" placeholder="输入您的邮箱获取最新优惠" class="middle-input" id="sss"/>
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

	    <!--跳转至首页-->
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
  		<!--购物车详情模态块-->
  		 <!--模态框结构-->
	  <div class="modal fade" id="myModal" data-backdrop="static">
	    <!--窗口层   大中小  默认为中-->
	    <div class="modal-dialog modal-md">
	      <!--内容层-->
	      <div class="modal-content">
	        <!--头部，身体，底部-->
	        <div class="modal-header">
	          <h3 class="modal-title"><span class="close" data-dismiss="modal">&times;</span></h3>
	        </div>
	        <div class="modal-body">
	        	<div class="container" id="info">
					<div class="info-l">
						<img src="/xinxiuli/shop-imgs/motaibox/2.jpg"/>
						<ul>
							<span class="glyphicon glyphicon-chevron-left"></span>
							<li><img src="/xinxiuli/shop-imgs/motaibox/3.jpg"/></li>
							<li><img src="/xinxiuli/shop-imgs/motaibox/1.jpg"/></li>
							<li><img src="/xinxiuli/shop-imgs/motaibox/4.jpg"/></li>
							<li><img src="/xinxiuli/shop-imgs/motaibox/2.jpg"/></li>
							<span class="glyphicon glyphicon-chevron-right"></span>
						</ul>
					</div>
					<div class="info-r">
						<h2>Samsonite/新秀丽明星同款 经典铝镁合金登机行李箱20英寸万向轮拉杆箱男女 DB3</h2>
						<p>RAYDIEN <span class="glyphicon glyphicon-star-empty"></span>
							 <span class="glyphicon glyphicon-star-empty"></span> 
							 <span class="glyphicon glyphicon-star-empty"></span>
							 <span class="glyphicon glyphicon-star-empty"></span>
						</p>
						<h5>明星同款 镁铝合金 赠送搭配箱套</h5>
						<p>￥4980.00 <span>手机购买</span><span class="glyphicon glyphicon-th-large"></span></p>
						<hr/>
						<p>颜色</p>
						<ul>
							<a href="#"><li></li></a>
							<a href="#" ><li></li></a>
							<a href="#" class="active"><li></li></a>
						</ul>
						<p>尺寸 <button class="btn btn-group-sm btn-primary">20英寸</button><button class="btn btn-group-sm">23英寸</button></p>
						<h6>数量<span class="reduce">-</span><span class="count">1</span><span class="add">+</span></h6>
						<hr />
						<a href="javascript:"><button class="btn btn-default">加入购物车</button></a>
						<a href="javascript:"><button class="btn btn-default">立即选购</button></a>
						<h4>需要帮助？您可以 <a href="javascript:">联系在线客服</a> 或 致电：4008-870-566</h4>
						<hr />
						<h3><span class="glyphicon glyphicon-heart"></span>添加至收藏
						    <p>分享：
						    	<a href="javascript:"><img src="/xinxiuli/shop-imgs/wechat.png"/></a>
						    	<a href="javascript:"><img src="/xinxiuli/shop-imgs/weibo.png"/></a>
						    </p>
						</h3>
					</div>
				</div>
			</div>
	</body>
</html>
<script type="text/javascript" src="/xinxiuli/js/jquery.min.js" ></script>
<script type="text/javascript" src="/xinxiuli/js/bootstrap.js" ></script>
<script type="text/javascript" src="/xinxiuli/js/xxk-login.js" ></script>
<script type="text/javascript" src="/xinxiuli/js/ljy-index.js" ></script>
<script src="/xinxiuli/js/cgp-cart.js"></script>
<script>
	$('.info-l>ul>li').mouseenter(function(){
	var url=$(this).children('img').attr("src");
	$(this).parent().siblings('img').attr("src",url);
	});
	$('.info-r>ul a').click(function(){
		$(this).addClass('active').siblings().removeClass();
	});
	$('.info-r>p button').click(function(){
		$(this).addClass('btn-primary').siblings().removeClass('btn-primary');
	});
	//数量加减模块
	var n=1;
	$('.info-r>h6>.reduce').click(function(){
		n--;
		if(n<1){
			n=1;
		  return;
		};
		$(this).siblings('.count').html(n);
	})
	$('.info-r>h6>.add').click(function(){
		n++;
		$(this).siblings('.count').html(n);
	})
</script>