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
    <link rel="stylesheet" href="css/bootstrap.css" />
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
 
</head>
<style>
    #table{
        table-layout:fixed;
        font-size: 12px;
        width: 100%;
    }
   #table .describe{
       font-weight:700;
   }
    #table td{
    	line-height:60px;	
        text-overflow:ellipsis;
        overflow:hidden;
    }
     #table .home{
     	line-height:25px;	
     	height: 50px;
     }
      #table .namess{
     	line-height:30px;	
     }
      #table .images>img{
      	height:60px;
      	width: 100%;
      }
    #content{
    	text-align: center;
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
    <div class="padding border-bottom">
        <input type="text" id="byName" name="byName" class="input w50" style="width:200px" />&ensp;&ensp;&ensp;
        <button type="button" class="button border-yellow" onclick="queryUsers()"><span></span>查找用户</button>
        <button type="button" class="button border-yellow" onclick="queryAll()" style="float: right"><span></span>查看全部订单</button>
        <button type="button" class="button border-yellow" onclick="loadUnSendOrder()" style="float: right"><span></span>查看未发货订单</button>
    </div>
    <table class="table table-hover text-center" id="table">
        <thead>
        <tr>
            <th width="4%">订单id</th>
            <th width="10%">用户名</th>
            <th width="8%">下单时间</th>
            <th width="6%">总价</th>
            <th width="17%">收货地址</th>
            <th width="7%">收货人</th>
            <th width="8%">手机号码</th>
            <th width="6%">订单状态</th>
            <th width="9%">商品名称</th>
            <th width="5%">颜色</th>
            <th width="5%">尺寸</th>
            <th width="13%">操作</th>
        </tr>

        </thead>
        <tbody id="content">
        	<tr>
        		<td>we313a123</td>
        		<td class="names">张三今天天气很嗯嗯</td>
        		<td class="home">2019年11月25日19:40:33</td>
        		<td>599945.15</td>
        		<td class="home">湖南省新疆为五千自制群长沙市岳麓农三区延栋四单元四</td>
        		<td class="namess">欧阳纯京买买提啊撒打算</td>
        		<td>18074798619</td>
        		<td>申请退款</td>
        		<td>这是一个行李箱</td>
        		<td>黑色</td>
        		<td>23英寸</td>     		
        		<td>
        			<button class="btn btn-success btn-sm">发货了吗</button>
        			<button class="btn btn-success btn-sm">查看详情</button>
        		</td>
        	</tr>
        </tbody>
    </table>
</div>
<!--<div class="panel admin-panel margin-top" id="add">
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 修改内容</strong></div>-->
    <div class="body-content">
        <!--<form method="post" class="form-x">
            <input type="hidden" name="productId" id="productId"/>
            <input type="hidden" name="productImg" id="productImg"/>
            <div class="form-group">
                <div class="label">
                    <label>收货地址：</label>
                </div>
                <div class="field">
                    <input id="orderId" type="hidden"/>
                    <input id="address" type="text" class="input w50" value="" name="address" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                    <div class="label">
                        <label>收货人：</label>
                    </div>
                <div class="field">
                    <input id="received" type="text" class="input w50" name="received" value=""  />
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>手机号码：</label>
                </div>
                <div class="field">
                    <input id="phoneNumber" type="text" class="input w50" name="phoneNumber" value=""  />
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="button" onclick="updataOrder()"> 确认修改</button>
                </div>
            </div>
        </form>-->
    </div>
</div>
</body>
</html>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<script src="js/pintuer.js"></script>
<script >
queryAll();
   function queryAll(){
	   $.ajax({
		  url:"/xinxiuli/showAllOrders",
		  success:function(result){
			  $("#content>tr").remove();
			  console.log(JSON.parse(result));
			  var obj=JSON.parse(result);
			  console.log(obj);
			  for(var i=0;i<obj.length;i++){                                        
				  switch (obj[i].order_status){
					case 2:
					$("#content").append("<tr><td>"+obj[i].order_num+"</td><td class='names'>"+obj[i].account_num+"</td><td class='home'>"+obj[i].order_time+"</td><td>"+obj[i].goods_price+"</td><td class='home'>"+obj[i].order_addrs+"</td><td class='namess'>"+obj[i].shouhuoren+"</td><td>"+obj[i].account_num+"</td><td class='describe'>待发货</td><td>"+obj[i].goods_name+"</td><td>"+obj[i].color_name+"</td><td>"+obj[i].size_name+"</td><td><button class='btn btn-success btn-md deliver' data-oldattr='2' data-newattr='3' data-accnum="+obj[i].account_num+">发货</button></td></tr>"); 
						break;
					case 3:
						$("#content").append("<tr><td>"+obj[i].order_num+"</td><td class='names'>"+obj[i].account_num+"</td><td class='home'>"+obj[i].order_time+"</td><td>"+obj[i].goods_price+"</td><td class='home'>"+obj[i].order_addrs+"</td><td class='namess'>"+obj[i].shouhuoren+"</td><td>"+obj[i].account_num+"</td><td class='describe'>已发货</td><td>"+obj[i].goods_name+"</td><td>"+obj[i].color_name+"</td><td>"+obj[i].size_name+"</td><td><button class='btn btn-primary btn-md logisi'>查看物流</button></td></tr>") 
						break;
					case 4:
						$("#content").append("<tr><td>"+obj[i].order_num+"</td><td class='names'>"+obj[i].account_num+"</td><td class='home'>"+obj[i].order_time+"</td><td>"+obj[i].goods_price+"</td><td class='home'>"+obj[i].order_addrs+"</td><td class='namess'>"+obj[i].shouhuoren+"</td><td>"+obj[i].account_num+"</td><td class='describe'>已取消</td><td>"+obj[i].goods_name+"</td><td>"+obj[i].color_name+"</td><td>"+obj[i].size_name+"</td><td><button class='btn btn-primary btn-sm knowmore'>查看详情</button> <button class='btn btn-danger btn-sm delte'>删除</button></td></tr>") 
						break;
					case 5:
						$("#content").append("<tr><td>"+obj[i].order_num+"</td><td class='names'>"+obj[i].account_num+"</td><td class='home'>"+obj[i].order_time+"</td><td>"+obj.goods_price+"</td><td class='home'>"+obj[i].order_addrs+"</td><td class='namess'>"+obj[i].shouhuoren+"</td><td>"+obj[i].account_num+"</td><td class='describe'>已退货</td><td>"+obj[i].goods_name+"</td><td>"+obj[i].color_name+"</td><td>"+obj[i].size_name+"</td><td><button class='btn btn-primary btn-sm'>查看详情</button> <button class='btn btn-danger btn-sm delte'>删除</button></td></tr>") 
						break;
					case 6:
						$("#content").append("<tr><td>"+obj[i].order_num+"</td><td class='names'>"+obj[i].account_num+"</td><td class='home'>"+obj[i].order_time+"</td><td>"+obj.goods_price+"</td><td class='home'>"+obj[i].order_addrs+"</td><td class='namess'>"+obj[i].shouhuoren+"</td><td>"+obj[i].account_num+"</td><td class='describe'>申请退货</td><td>"+obj[i].goods_name+"</td><td>"+obj[i].color_name+"</td><td>"+obj[i].size_name+"</td><td><button class='btn btn-success btn-sm agree'>同意</button> <button class='btn btn-danger btn-sm refuse'>拒绝</button> <button class='btn btn-primary btn-sm refuse'>查看</button></td></tr>") 
						break;
				}
			  }
			  caozuo();
		  }
	   });   
   };
   function caozuo(){
	   $("#content>tr button").click(function(){
		   var accnum=$(this).attr("data-accnum");
		   var oldattr=$(this).attr("data-oldattr");
		   var newattr=$(this).attr("data-newattr");
		   var obj=$(this).parent();	
		   switch (oldattr){
		   	case "2":
		   		$.ajax({
		   			url:"/xinxiuli/updataOrdersStatus?sta="+newattr+"&accnum="+accnum,
		   			success:function(result){
		   			 alert(result);	
		   			  obj.children().remove();
		   			 obj.append("<button class='btn btn-primary btn-md deliver' data-oldattr='3' data-newattr='4'>查看物流</button>").siblings(".describe").html("已发货");
		   			}
		   		});	
		       break;
			case 3:
				var obj=$(this).parent();
				   $(this).parent().children().remove();
				   obj.append("<button class='btn btn-primary btn-md deliver' data-oldattr='4' data-newattr='5'>查看详情</button>");
				   
		       break;
			case 4:
				var obj=$(this).parent();
				   $(this).parent().children().remove();
				   obj.append("<button class='btn btn-primary btn-md deliver' data-oldattr='3' data-newattr='4'>查看物流</button>").siblings(".describe").html("已发货");
		       break;
			case 5:
				var obj=$(this).parent();
				   $(this).parent().children().remove();
				   obj.append("<button class='btn btn-primary btn-md deliver' data-oldattr='3' data-newattr='4'>查看物流</button>").siblings(".describe").html("已发货"); 
		       break;
			case 6:
				var obj=$(this).parent();
				  
			   break;
		   }
	   });
   }
   
  function loadUnSendOrder(){
	  $.ajax({
		  url:"/xinxiuli/showAllOrders?sta=2",
		  success:function(result){
			  var obj=JSON.parse(result);
			  $("#content>tr").remove();
			  for(var i=0;i<obj.length;i++){
				  $("#content").append("<tr><td>"+obj[i].order_num+"</td><td class='names'>"+obj[i].account_num+"</td><td class='home'>"+obj[i].order_time+"</td><td>"+obj[i].goods_price+"</td><td class='home'>"+obj[i].order_addrs+"</td><td class='namess'>"+obj[i].shouhuoren+"</td><td>"+obj[i].account_num+"</td><td class='describe'>待发货</td><td>"+obj[i].goods_name+"</td><td>"+obj[i].color_name+"</td><td>"+obj[i].size_name+"</td><td><button class='btn btn-success btn-md deliver' data-oldattr='2' data-newattr='3' data-accnum="+obj[i].account_num+">发货</button></td></tr>");
			  }
			  caozuo();
		  }
  });
  }
  function queryUsers(){
	 var accnum=$("#byName").val();
	 if(!accnum=="")
	  $.ajax({
		  url:"/xinxiuli/AdminQueryOneUser?accnum="+accnum,
		  success:function(result){
			  var obj=JSON.parse(result);
			  $("#content>tr").remove();
			  for(var i=0;i<obj.length;i++){
				  switch (obj[i].order_status){
					case 2:
					$("#content").append("<tr><td>"+obj[i].order_num+"</td><td class='names'>"+obj[i].account_num+"</td><td class='home'>"+obj[i].order_time+"</td><td>"+obj[i].goods_price+"</td><td class='home'>"+obj[i].order_addrs+"</td><td class='namess'>"+obj[i].shouhuoren+"</td><td>"+obj[i].account_num+"</td><td class='describe'>待发货</td><td>"+obj[i].goods_name+"</td><td>"+obj[i].color_name+"</td><td>"+obj[i].size_name+"</td><td><button class='btn btn-success btn-md deliver' data-oldattr='2' data-newattr='3' data-accnum="+obj[i].account_num+">发货</button></td></tr>"); 
						break;
					case 3:
						$("#content").append("<tr><td>"+obj[i].order_num+"</td><td class='names'>"+obj[i].account_num+"</td><td class='home'>"+obj[i].order_time+"</td><td>"+obj[i].goods_price+"</td><td class='home'>"+obj[i].order_addrs+"</td><td class='namess'>"+obj[i].shouhuoren+"</td><td>"+obj[i].account_num+"</td><td class='describe'>已发货</td><td>"+obj[i].goods_name+"</td><td>"+obj[i].color_name+"</td><td>"+obj[i].size_name+"</td><td><button class='btn btn-primary btn-md logisi'>查看物流</button></td></tr>") 
						break;
					case 4:
						$("#content").append("<tr><td>"+obj[i].order_num+"</td><td class='names'>"+obj[i].account_num+"</td><td class='home'>"+obj[i].order_time+"</td><td>"+obj[i].goods_price+"</td><td class='home'>"+obj[i].order_addrs+"</td><td class='namess'>"+obj[i].shouhuoren+"</td><td>"+obj[i].account_num+"</td><td class='describe'>已取消</td><td>"+obj[i].goods_name+"</td><td>"+obj[i].color_name+"</td><td>"+obj[i].size_name+"</td><td><button class='btn btn-primary btn-sm knowmore'>查看详情</button> <button class='btn btn-danger btn-sm delte'>删除</button></td></tr>") 
						break;
					case 5:
						$("#content").append("<tr><td>"+obj[i].order_num+"</td><td class='names'>"+obj[i].account_num+"</td><td class='home'>"+obj[i].order_time+"</td><td>"+obj.goods_price+"</td><td class='home'>"+obj[i].order_addrs+"</td><td class='namess'>"+obj[i].shouhuoren+"</td><td>"+obj[i].account_num+"</td><td class='describe'>已退货</td><td>"+obj[i].goods_name+"</td><td>"+obj[i].color_name+"</td><td>"+obj[i].size_name+"</td><td><button class='btn btn-primary btn-sm'>查看详情</button> <button class='btn btn-danger btn-sm delte'>删除</button></td></tr>") 
						break;
					case 6:
						$("#content").append("<tr><td>"+obj[i].order_num+"</td><td class='names'>"+obj[i].account_num+"</td><td class='home'>"+obj[i].order_time+"</td><td>"+obj.goods_price+"</td><td class='home'>"+obj[i].order_addrs+"</td><td class='namess'>"+obj[i].shouhuoren+"</td><td>"+obj[i].account_num+"</td><td class='describe'>申请退货</td><td>"+obj[i].goods_name+"</td><td>"+obj[i].color_name+"</td><td>"+obj[i].size_name+"</td><td><button class='btn btn-success btn-sm agree'>同意</button> <button class='btn btn-danger btn-sm refuse'>拒绝</button> <button class='btn btn-primary btn-sm refuse'>查看</button></td></tr>") 
						break;
				  }
				  caozuo();
			  } 
		  }
      });
  }
  
</script>
  