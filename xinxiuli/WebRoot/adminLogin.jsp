<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>登录</title>
    <link rel="stylesheet" href="/xinxiuli/houtaiyemian/css/pintuer.css">
    <link rel="stylesheet" href="/xinxiuli/houtaiyemian/css/admin.css">
</head>
<body>
<div class="bg">
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">
            </div>
            <form action="/xinxiuli/Admloginservlet" method="post">
                <div class="panel loginbox">
                    <div class="text-center margin-big padding-big-top"><h1>后台管理中心</h1></div>
                        <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                            <div class="form-group">
                                <div class="field field-icon-right">
                                    <input  type="text" class="input input-big" id="username" name="username" placeholder="登录账号" data-validate="required:请填写账号" />
                                    <span class="icon icon-user-md margin-small"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="field field-icon-right">
                                    <input  type="password" class="input input-big" id="userpwd"  name="userpwd" placeholder="登录密码" data-validate="required:请填写密码" />
                                    <span class="icon icon-keyboard-o margin-small"></span>
                                </div>
                            </div>
                            
                          <!--  ${param.msg } = requset.getParameter("msg") -->
                            <!-- 当test里面的表达式成立，那么里面的内容显示，如果不成立，则不显示 -->
                            
                          <c:if test="${parammy eq 1}">
                           	<div class="form-group">
                                <div class="field field-icon-right">
                                            对不起用户名或者密码错误!
                                </div>
                             </div>
                          </c:if>
                        </div>
                    <div style="padding:30px;"><input type="submit" class="button button-block bg-main text-big input-big" value="登录"></div>
                </div>
            </form>
        </div>
    </div>
</div>
</div>
</body>
</html>
<script  src="/xinxiuli/houtaiyemian/js/jquery.js" ></script>
<script src="/xinxiuli/houtaiyemian/js/jquery-1.11.0.js"></script>
<script src="/xinxiuli/houtaiyemian/js/pintuer.js"></script>
<!--<script  src="/xinxiuli/houtaiyemian/js/xxk-adminLogin.js"></script>-->


