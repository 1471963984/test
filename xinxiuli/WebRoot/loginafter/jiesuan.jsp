<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <meta charset="utf-8" />
		<title>结算</title>
		<meta name="viewport" content="width=device-width initial-scale=1" />
		<link rel="stylesheet" type="text/css" href="/xinxiuli/css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="/xinxiuli/css/animate.css"/>
		<link rel="stylesheet" type="text/css" href="/xinxiuli/css/dcf-shopdetail.css"/>
		<link rel="stylesheet" type="text/css" href="/xinxiuli/css/PersonAllPageHeader.css"/>
		<link rel="stylesheet" type="text/css" href="/xinxiuli/css/PersonAllPageFooter.css"/>
		<link rel="stylesheet" href="/xinxiuli/css/xxk-login.css"/>
		<link rel="stylesheet" href="/xinxiuli/css/xxk-registr.css"/>
		<link rel="stylesheet" href="/xinxiuli/css/jiesuan.css" />
	</head>

<body>
	<!--导航-->
		<nav>
         <div class="index-header">
					<div class="container">
						<div class="scrolled-warp">
							<div class="scrolled-logo">
								<a href="/xinxiuli/qianduanyemian/index.jsp">
									<img src="/xinxiuli/img/logo/logo-white.png" />
								</a>
							</div>
							<div class="scrolled-right">
								<div class="right-warp">
									<div class="right-list">
										<a>在线客服</a>
										<span>|</span>
										<a>客服热线：400-000-000</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
		</nav>	
		
	<!-- 结算页面中间部分 -->
	<div class="main-container">
		<div class="steper-title">核对并填写订单</div>
		<div class="balance-lable">配送方式</div>
		<div class="method-delivery">
			<img src="/xinxiuli/shop-imgs/distribution.png" />
			<div class="method-name">普通快递</div>
		</div>
		<div class="info_r">
				<ul>
					<li>
						<div class="title-about balance-lable">配送地址</div>
						<button class="btn btn-block btn-default" onclick="window.location.href='/xinxiuli/loginafter/addmyaddrs.jsp'">
							<span class="btn-add">+</span>
							&nbsp;&nbsp;新增地址
						</button>
					</li>
				</ul>
				<c:forEach  items="${myinfo.addrs}" var="u" varStatus="i" >
				<div class="addrs-list">
					<input type="radio" name="addrs" data-choose="" class="choose-addrs" style="width: 20px;
							height: 20px;
							margin: 10px 0px 0px;
							position: absolute;
							left: 10px;" />
					<div class="index" style="display:none">${i.index }</div>
			    	<div class="name ch-left">${u.name }</div>
			    	<div class="phone mbtel">${u.tel }</div>
			    	<div class="addrs-message">${u.dizhi }</div>
			    	<input type="text" class="addrs-default" value="默认地址"/>
			    	<div class="caozuo">
			    		<img class="addrs-edit" src="/xinxiuli/shop-imgs/address-edit.png"/>
			    		<img class="goods-delete" title="删除商品" src="/xinxiuli/shop-imgs/delete.png"></img>
			    	</div>
		   		</div>
		   	</c:forEach>
		</div>
		<div class="balance-lable">商品运送清单</div>
		<ul class="dingdan-shops">
			<c:forEach  items="${myinfo.goods}" var="u" >
			<li class="dingdan-goods">
				<div class="goods_num" style="display:none" >${u.goods_num }</div>
				<img class="goods-img" style="background-image: url(${u.goods_img });"/>
				<div class="goods-about">
       				<a href="javascript:;">${u.goods_desc }</a>
       				<div class="goods-brand">${u.goods_name }</div>
       				<div class="goods-spec">
           				<label>颜色：</label>
           				<p>${u.goods_color }</p>
           				<label>尺寸：</label>
           				<p>${u.goods_size }</p>
           			</div>
       			</div>
       			<div ></div>
       			<div class="sell-srice">￥${u.goods_price }0</div>
			</li>
			</c:forEach>
		</ul>
		<div class="balance-lable">支付方式</div>
		<div class="payment" data-dianji="active">
			<img class="zhifufanghsi" src="/xinxiuli/shop-imgs/payment-alipay.png"/>
			<img class="gougou" src="/xinxiuli/shop-imgs/checked.png" />
		</div>
		
		<div class="payment" data-dianji="">
			<img class="zhifufanghsi" src="/xinxiuli/shop-imgs/payment-wechatpay.png"/>
			<img class="gougou" src="/xinxiuli/shop-imgs/checked.png" />
		</div>
		<div class="payment" data-dianji="">
			<img class="zhifufanghsi" src="/xinxiuli/shop-imgs/payment-unionpay.png"/>
			<img class="gougou" src="/xinxiuli/shop-imgs/checked.png" />
		</div>
		<div class="payment" data-dianji="">
			<img class="zhifufanghsi" src="/xinxiuli/shop-imgs/payment-creditpay.png"/>
			<img class="gougou" src="/xinxiuli/shop-imgs/checked.png" />
		</div>
		<div class="order-submit">
			<!--复制来的-->
				<div class="goods-card">
                		<div class="card-left">
                			<div class="card-left-top-title">温馨提示</div>
                			<div class="tip-desc">
                				订单提交之后30分钟未付款，订单将被系统自动取消，请您尽快完成支付
以确保商品能及时送达。
                			</div>
                			<div class="right-list-bottom">
			                    <div class="title-aboutzhifu">支付方式</div>
			                    <div class="list-content" id="zhifu">
			                        <img src="/xinxiuli/shop-imgs/zhifubao.png" />
			                        <img src="/xinxiuli/shop-imgs/weChat1.png" />
			                        <img src="/xinxiuli/shop-imgs/bank.png" />
			                    </div>
			                    <a class="back-to-cart" href="/xinxiuli/loginafter/mycart.jsp">返回购物车</a>
			                </div>
                		</div>
                		<div class="card-right">
                			<div class="message-list-subtotal">
                				<label>小计</label>
                				<p>￥${zongjia }0</p>
                			</div>
                			<div class="message-list-youhui">
                				<label>运费</label>
                				<p>免费</p>
                			</div>
                			<div class="message-list-discount">
                				<label>优惠</label>
                				<p>-¥ 0.00</p>
                			</div>
                			<div class="message-list-total">
                				<label>总计</label>
                				<p>￥${zongjia }0</p>
                			</div>
                			<button id="tijiao" class="btn btn-block btn-primary" >提交订单</button>
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
		<!-- 购物车模态框 -->
		<div class="modal fade" id="myModal" data-backdrop="static" >
			<div style="left: 50%;margin-left:-200px;top: 30%;width: 400px;height: 300px;background: white;position: absolute;">
				<div class="quedinggoumai"style="font-size:30px;color:black;position:absolute;width:240px;height:120px;top:60px;left:20%" >是否确认付款？</div>
				<button id="queding" class="btn" style="position:absolute;bottom:60px;left:20%;bacdground-color:#222222">确定</button>
				<button id="quxiao" class="btn " style="position:absolute;bottom:60px;right:20%" data-dismiss="modal">取消</button>
			</div>
		</div>
</body>
</html>
<script src="/xinxiuli/js/jquery-1.11.0.js" type="text/javascript" charset="utf-8"></script>
<script src="/xinxiuli/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<script src="/xinxiuli/js/xxk-login.js"></script>
<script>
	//选择支付方式
	$('.gougou').hide();
	$('.payment[data-dianji=active]').children('.gougou').show();
	$('.payment').click(function(){
//		console.log($(this))
		//点击给标记并去除其他标记
		$(this).attr('data-dianji','active').siblings('.payment').attr('data-dianji','');
		$(this).siblings('.payment').children('.gougou').hide();
		$(this).children('.gougou').show();
	})
	
	//默认地址
	$('.mbtel').each(function(i){
		//alert($(this));
		var tel = $(this).html();
		if(tel.slice(0,1)=="#"){
			$(this).html(tel.slice(2));
			$(this).siblings('.addrs-default').css({"background-color":"black","color":"white"});
			$(this).siblings('choose-addrs').prop('checked','true');
		}else{
			$(this).siblings('.addrs-default').prop('value','设为默认');
		}
	});
	
	var a = "a";
	$('.choose-addrs').click(function(){
		a = $(this).siblings('.index').html();
	})
	//提交订单
	$('#tijiao').click(function(){
		if(a!="a"){
			$('#myModal').modal('show');
		}else{
			alert('请选择或添加一个您的收获地址！');
		}
	})

	var t = 't';
	var f = 'f';
	//点击确认付款
	$('#queding').click(function(){
		gaikucun(t);
	});
	//点击取消，订单状态设为待付款
	$('#quxiao').click(function(){
		gaikucun(f);
	})
	//更新库存
	function gaikucun(judge){
		//拿下标
		var index = "";
		$('.choose-addrs').each(function(){
			if($(this).prop('checked')==true){
				index = $(this).siblings('.index').html();
			}
		})
		var str = "";
		$('.goods_num').each(function(){
			var goods_num = $(this).html()+",";
			str=str+goods_num;
		})
		if(str!=""&&index!=""){
			location.href="/xinxiuli/gaikucun?goods_num="+str+"&index="+index+"&judge="+judge;
		}
	}
</script>