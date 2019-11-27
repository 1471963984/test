<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <meta charset="utf-8" />
		<title>结算</title>
		<meta name="viewport" content="width=device-width initial-scale=1" />
		<link rel="stylesheet" type="text/css" href="/xinxiuli/css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="/xinxiuli/css/animate.css"/>
		<link rel="stylesheet" type="text/css" href="/xinxiuli/css/dcf-shopdetail.css"/>
		<link rel="stylesheet" href="/xinxiuli/css/xxk-login.css"/>
		<link rel="stylesheet" href="/xinxiuli/css/jiesuan.css" />
	</head>

<body>
		<div class="main-container">
			<div class="steper-title">核对并填写订单</div>
			<div class="balance-lable">配送方式</div>
			<div class="method-delivery">
				<img src="/xinxiuli/shop-imgs/distribution.png" />
				<div class="method-name">普通快递</div>
			</div>
			<div class="info_r">
				<form action="" id="addmyaddrs">
					<ul>
						<li>
							<div class="title-about balance-lable">配送地址</div>
							<button class="btn btn-block btn-default" onclick="window.location.href='/xinxiuli/qianduanyemian/addmyaddrs.jsp'">
								<span class="btn-add">+</span>
								&nbsp;&nbsp;新增地址
							</button>
						</li>
					</ul>
					<div class="addrs-list">
						<input type="checkbox" id="choose-addrs" />
				    	<div class="name ch-left">陈广平</div>
				    	<div class="phone mbtel">17769336339</div>
				    	<div class="addrs-message">湖南省-长沙市-岳麓区&nbsp;&nbsp;延农六期三栋四单元</div>
				    	<input type="text" class="addrs-default" value="默认地址"/>
				    	<div class="caozuo">
				    		<img class="addrs-edit" src="/xinxiuli/img/address-edit.png"/>
				    		<img class="goods-delete" title="删除商品" src="/xinxiuli/shop-imgs/delete.png"></img>
				    	</div>
			   		</div>
				</form>
			</div>
			<div class="balance-lable">商品运送清单</div>
			<ul class="dingdan-shops">
				<li class="dingdan-goods">
					<img class="goods-img"/>
					<div class="goods-about">
        				<a href="javascript:;">Samsonite/新秀丽男手提包 简约立体轻奢多功能可容纳15.6英寸电脑公文包 AQ1</a>
        				<div class="goods-brand">ACTAEON</div>
        				<div class="goods-spec">
            				<label>颜色：</label>
            				<p>月光白</p>
            				<label>尺寸：</label>
            				<p>均码</p>
            			</div>
        			</div>
        			<div class="sell-srice">￥2180.00</div>
				</li>
			</ul>
			<div class="balance-lable">支付方式</div>
			<div class="payment" data-dianji="active">
				<img class="zhifufanghsi" src="/xinxiuli/shop-imgs/payment-alipay.png"/>
				<img class="gougou" src="/xinxiuli/img/checked.png" />
			</div>
			
			<div class="payment" data-dianji="">
				<img class="zhifufanghsi" src="/xinxiuli/shop-imgs/payment-wechatpay.png"/>
				<img class="gougou" src="/xinxiuli/img/checked.png" />
			</div>
			<div class="payment" data-dianji="">
				<img class="zhifufanghsi" src="/xinxiuli/shop-imgs/payment-unionpay.png"/>
				<img class="gougou" src="/xinxiuli/img/checked.png" />
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
			                    <a class="back-to-cart" href="mycart.html">返回购物车</a>
			                </div>
                		</div>
                		<div class="card-right">
                			<div class="message-list-subtotal">
                				<label>小计</label>
                				<p>¥ 0.00</p>
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
                				<p>¥ 0.00</p>
                			</div>
                			<button class="btn btn-block btn-primary">提交订单</button>
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
	//选择支付方式
	$('.gougou').hide();
	$('.payment').click(function(){
//		console.log($(this))
		//点击给标记并去除其他标记
		$(this).attr('data-dianji','active').siblings('.payment').attr('data-dianji','');
		$(this).siblings('.payment').children('.gougou').hide();
		$(this).children('.gougou').show();
	})
</script>