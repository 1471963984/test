<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>
    <link rel="stylesheet" href="/xinxiuli/houtaiyemian/css/pintuer.css">
    <link rel="stylesheet" href="/xinxiuli/houtaiyemian/css/admin.css">
    <script src="/xinxiuli/houtaiyemian/js/jquery-1.11.0.js"></script>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
        <h1><img src="/xinxiuli/houtaiyemian/images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />新秀丽后台管理中心</h1>
    </div>
    <div class="head-l"><a class="button button-little bg-green" href="/xinxiuli/qianduanyemian/index.jsp" target="_blank">
    <span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;<a class="button button-little bg-red" onclick="unLogin()"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
    <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
    <h2><span class="icon-user-md"></span>后台管理</h2>
    <ul style="display:block">
        <li><a href="/xinxiuli/houtaiyemian/usersList.jsp" target="right"><span class="icon-caret-right"></span>用户管理</a></li>
        <li><a href="/xinxiuli/houtaiyemian/orderList.jsp" target="right"><span class="icon-caret-right"></span>订单管理</a></li>
        <li><a href="/xinxiuli/houtaiyemian/adminAdvert.jsp" target="right"><span class="icon-caret-right"></span>广告管理</a></li>
        <li><a href="/xinxiuli/houtaiyemian/myproductList.jsp" target="right"><span class="icon-caret-right"></span>产品管理</a></li>		
    </ul>
</div>
<script type="text/javascript">
    $(function(){
        $(".leftnav h2").click(function(){
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function(){
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });

    function unLogin() {
       location.href="/xinxiuli/adminOut"
    }
</script>
<ul class="bread">

</ul>
<div class="admin">
    <iframe scrolling="auto" rameborder="0" src="" name="right" width="100%" height="100%"></iframe>
</div>
</body>
</html>
