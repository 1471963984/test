<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>添加商品</title>
    <link rel="stylesheet" href="/xinxiuli/houtaiyemian/css/pintuer.css">
    <link rel="stylesheet" href="/xinxiuli/houtaiyemian/css/admin.css">
</head>
<style>
    #table{
        border-collapse: collapse;
        table-layout:fixed
    }
    #table td {
        text-overflow:ellipsis;
        overflow:hidden;
        white-space: nowrap;
    }
    .pageStyle{
        display: inline-block;
        position: relative;
        margin-left:10px;
        padding: 5px;
        background-color:#fff;
        border-radius: 3px;
        border: 1px solid #d2d1d0;
        color: #000;
        float: left;
    }

    .pageStyle:hover{
        color: #fff;
        background-color: rgb(0, 170, 238);
    }
</style>
<body >
<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 商品列表</strong></div>
    <div class="padding border-bottom" id="addproduct">
      <button type="button" class="button border-yellow"><span class="icon-plus-square-o"></span> 添加商品</button>
       <a class="button bg-green" href="/xinxiuli/Admproductlistservlet?pageno=1&pagesize=${pagesize}">首页</a>
       <a class="button bg-green" href="/xinxiuli/Admproductlistservlet?pageno=${pageno-1}&pagesize=${pagesize}">上一页</a>
       <a class="button bg-green" href="/xinxiuli/Admproductlistservlet?pageno=${pageno+1}&pagesize=${pagesize}">下一夜</a> 
       <a class="button bg-green" href="/xinxiuli/Admproductlistservlet?pageno=${maxpageno}&pagesize=${pagesize}">尾页</a> 
       <span class="button" style="border: none;background-color: white;">当前页 ${pageno} </span> <span class="button" style="border: none;background-color: white;">最大页 ${maxpageno}</span>
    </div>
    <table class="table table-hover text-center" id="table">
        <thead>
        <tr>
            <th width="10%">商品序号</th>
            <th width="20%">商品缩略图</th>
            <th width="15%">商品名称</th>
            <th width="10%">单价</th>
            <th width="10%">库存</th>
            <th width="10%">颜色</th>
            <th width="10%">尺寸</th>
            <th width="25%">操作</th>
        </tr>
       </thead>
        <tbody id="content">
         <c:forEach items="${list}" var="adm" varStatus="i">
           <trs  tyle="align-content: center;">
            <td> ${i.count}</td>
            <td><img alt="" src="${adm.goods_picture}" style="height: 38px"></td>
            <td> ${adm.goods_name}</td>
            <td> ${adm.goods_price}</td>
            <td> ${adm.goods_remain}</td> 
            <td> ${adm.color_name}</td>
            <td> ${adm.size_name}</td>
            <td><a class="button bg-green" href="#">上架</a><a class="button bg-green" href="#">下架</a><a class="button bg-yellow" href="#">删除</a>
            <button class="button bg-green" onclick="">修改</button></td>   
           </tr>  
         </c:forEach>
        
        </tbody>
     </table>
      
       
</body>
</html>
<script type="text/javascript" src="/xinxiuli/houtaiyemian/js/jquery.js"></script>
<script type="text/javascript" src="/xinxiuli/houtaiyemian/js/jquery-1.11.0.js"></script>
<script src="/xinxiuli/houtaiyemian/js/pintuer.js"></script>

