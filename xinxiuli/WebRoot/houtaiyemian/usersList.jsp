<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
</head>
<style>
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
  #content>tr>td{
  	line-height: 30px;
  }
 #content>tr>.addres{
 	line-height:15px;
 }
 
 .uninfo .modal-body>.uhead{
    font-size:50px;
    font-weight: 600;
 }
 
 .uinfo .modal-body>ul{
    width:100%;
    height:50px;
 }                   
 .uinfo .modal-body>ul>li{
      margin-right:20px;
      float:left;
      width:140px;
      text-align:center;
  }
   .uinfo .modal-body>ul>.uindex{
        width:80px;
   }
  .uinfo .modal-body>ul>.uname{
       width:80px;
  }
  .uinfo .modal-body>ul>.unik{
       width:30px;
  }
  .uinfo .modal-body>ul>.uaddr{
       width:250px;
  }
 
</style>
<body >

<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 商品列表</strong></div>
    <table class="table table-hover text-center">
        <thead>
        <tr>
            <th width="4%">ID</th>
            <th width="10%">账号</th>
            <th width="10%">姓名</th>
            <th width="5%">性别</th>
            <th width="6%">昵称</th>
            <th width="4%">邮箱</th>
            <th width="4%">手机号码</th>
            <th width="15%">地址</th>
            <th width="18%">操作</th>
        </tr>
        </thead>
        <tbody id="content">
     
        </tbody>
    </table>
</div>

</body>
</html>

<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script src="js/pintuer.js"></script>
<script>
load();
  function load(){
	  $.ajax({
  		  type:"POST",
  		  url:"/xinxiuli/ShowAllUsers",
          success:function(result){
        	  var obj=JSON.parse(result);
        	  console.log(obj);
        	  console.log(obj[0].useraddr)
        	  for(var i=0;i<obj.length;i++){
        	$("#content").append("<tr><td>"+obj[i].usersid+"</td><td>"+obj[i].accountnum+"</td><td>"+obj[i].username[obj[i].index]+"</td><td>"+obj[i].usernick[obj[i].index]+"</td><td></td><td>"+obj[i].useremail[obj[i].index]+"</td><td>"+obj[i].userphone[obj[i].index]+"</td><td>"+obj[i].useraddr[obj[i].index]+"</td><td><button class='btn btn-primary btn-sm' data-toggle='modal' data-target='#myModal"+i+"'>查看详情</button> <button onclick='deleteUser("+obj[i].usersid+")' class='btn btn-danger btn-sm'>删除</button></td></tr>");
        	$("body").append("<div class='modal fade uinfo' id='myModal"+i+"' data-backdrop='static'><div class='modal-dialog modal-lg'><div class='modal-content'><div class='modal-header'><h3 class='modal-title'>用户所有地址信息：<span class='close' data-dismiss='modal'></span></h3></div><div class='modal-body'><ul class='uhead' style=' font-size:15px;font-weight: 600;'><li class='uindex'>编号</li><li class='uname'>用户名</li><li class='unik'>性别</li><li>Email</li><li>电话</li><li class='uaddr'>地址</li></ul></div></div</div></div>");
	        	for(var j=0;j<obj[i].useraddr.length;j++){
	        		if(j==obj[i].index){
	        			 $("#myModal"+i+" .modal-body").append("<ul><li class='uindex'>"+(j+1)+"(默认地址)</li><li class='uname'>"+obj[i].username[j]+"</li><li class='unik'>"+obj[i].usernick[j]+"</li><li>"+obj[i].useremail[j]+"</li><li>"+obj[i].userphone[j]+"</li><li class='uaddr'>"+obj[i].useraddr[j]+"</li></ul>");	
	        		}else{
	        			 $("#myModal"+i+" .modal-body").append("<ul><li class='uindex'>"+(j+1)+"</li><li class='uname'>"+obj[i].username[j]+"</li><li class='unik'>"+obj[i].usernick[j]+"</li><li>"+obj[i].useremail[j]+"</li><li>"+obj[i].userphone[j]+"</li><li class='uaddr'>"+obj[i].useraddr[j]+"</li></ul>");	        			
	        		}    	   
	        	}
        	  }
          }
	  });
  }

  function deleteUser(usersId) {
      if(confirm("您确定要删除该用户吗?")){
          $.post({
             url:"/xinxiuli/ShowAllUsers?uid="+usersId,
             success:function(data){
                  if(data == "true"){
               	    $("#content").remove();
                      load();
                  }else{
                      alert("删除失败！");
                  }
              }
          });
      }
  }
 </script>