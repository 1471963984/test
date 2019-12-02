<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
--%>
<!DOCTYPE html>
<html>
	<head>
	
	<!--<base href=""> -->
	
	<meta charset="utf-8" />
	<title>新秀丽-新用户注册</title>
	    <meta name="viewport" content="width=device-width,initial-scale=1"/>	
		<link rel="stylesheet" href="/xinxiuli/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/xinxiuli/css/xxk-registr.css" /> 
	</head>
	
	<body>
		<!--导航-->
		<nav>
         <div class="scrolled-index-header">
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
		
		<!--顶部留白-->
		<div class="back"></div>
		<!--返回首页-->
		<div class="container">
		 <div class="row">
		  <div class="col-md-12">
		  <a href="/xinxiuli/qianduanyemian/index.jsp" style="color: #080808;">返回首页></a>
		  </div>	
		 </div>  	
		</div>
		
		<div class="container">
		  <div class="row">
		   <div class="col-md-6 col-md-offset-3 text-center">
		       <h3>注册</h3>
		       	<!--<div style="padding-top: 7px;">
		        <img src="img/login-logo.png" /> 
		          </div>-->
		        <hr/>      
		   </div>	
		  </div>
		</div>
	
		<div class="container">
		  <div class="row">
		   <div class="col-md-6 col-md-offset-3 text-center">
		        <h4 style="text-align: left;"> 验证手机号</h4>
		        
		        <div class="pictruecheck" >
		        <input id="phone" type="text" class="form-control" placeholder="请输入手机号" />
		        <h6  style="text-align: left; color: #398439;">　</h6>
		        <span><img src="/xinxiuli/img/xxk/input-error.png" class="image-danger hidden"style=""/></span>
		        </div> 
		        
		      <!--验证码-->
		  <!--
		    <div class="input-group">
		     <input   type="text" class="form-control"/>
		      <span class="input-group-btn">
		      <button class="btn btn-default" style="background: #101010;color: white;border-left:#101010 ;">发送验证码</button>
		     </span>
		     </div>
		       -->
		   </div>	
		  </div>
		  
		 <!--密码验证-->
		 <div class="row" >
		  <div class="col-md-6 col-md-offset-3 ">
		  	 <h4>设置登录密码</h4>
		  	 
		  	 <div  class="pictruecheck">
		     <input id="pwd1"   type="password"  class="form-control"  placeholder="6~15字符，数字大小写字母"/>
		      <span><img src="/xinxiuli/img/xxk/input-error.png" class="image-danger hidden"/></span>   
		      <h6 style="text-align: left; color: #398439;">　</h6>
		     </div>
		     
		     <div class="pictruecheck">
		     <input id="pwd2"  type="password"  class="form-control"  placeholder="再次确认密码"/>
	         <span><img src="/xinxiuli/img/xxk/input-error.png" class="image-danger hidden"/></span>   
		     <h6 style="text-align: left; color: #398439;">　</h6>
		     </div>
		     
		     
		    <!-- 验证码 -->
		    <h4>填写验证码</h4>
		    <div class="input-group">
	           <input type="text" class="form-control"  id="checkcode"  placeholder="验证码不分大小写" />
	              <span class="input-group-btn" style="padding-left: 10px;">
	           <img src="imgCode"  alt="验证码" id="imgCode"   onclick="flushcode(this)" style="cursor: pointer;width: 142px;height: 34px;" />
	          </span>
	        </div>
		     
		   </div>	
		  </div>
		   <!--接收-->
		  <div  class="row" style="margin-top:10px;">
		      <div class="col-md-6 col-md-offset-3 " >
		        <div class="form-inline">
		   	    <input id="check" class="form-control"  type="checkbox" style="width: 20px;height: 20px;" />
		        <label  style="display:inline-block ;padding-top: 3px;">
		  	           接收新秀丽 <a href="javascript:;">使用条款</a>和<a href="javascript:;">隐私条款</a>
		        </label>
		         <h6 style="text-align: left; color: #398439;">请接受新秀丽隐私政策和销售条款</h6>   
		        </div>
		     
		     
		   </div>
		   <!--按钮-->
		   <div class="row">
		     <div  class="col-md-6 col-md-offset-3 bottom-input" >
		   	   <input id="submit" type="button"  class="form-control btn-submit" value="注册"/>        
		     </div>	
		    </div>	
		
		  
		  </div>   
		  
		<!--</form>-->
		  <!--尾部-->
		 </div> 
		
		<!--尾部-->
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
	</body>
</html>
<script src="/xinxiuli/js/jquery.min.js" ></script>
<script src="/xinxiuli/js/bootstrap.min.js" ></script>
<script src="/xinxiuli/js/xxk-register.js"></script>
