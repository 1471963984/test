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
    <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
    <script src="js/pintuer.js"></script>
  
</head>
<style>
    #table{
        table-layout:fixed;
        font-size: 12px;
        width: 100%;
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
        <button type="button" class="button border-yellow" onclick="ByName()"><span></span>查找用户</button>
        <button type="button" class="button border-yellow" onclick="loadOrderList(1)" style="float: right"><span></span>查看全部订单</button>
        <button type="button" class="button border-yellow" onclick="loadUnSendOrder(1)" style="float: right"><span></span>查看未发货订单</button>
    </div>
    <table class="table table-hover text-center" id="table">
        <thead>
        <tr>
            <th width="7%">订单id</th>
            <th width="10%">用户名</th>
            <th width="8%">下单时间</th>
            <th width="6%">总价</th>
            <th width="14%">收货地址</th>
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
			<!--<c:forEach items="${data}" var="o">
				 <tr>
				 	<td class="name" >
						${o.orderid }
					</td>
					<td class="name" >
						${o.username }
					</td>
	                <td class="name">
						${o.downtime }
					</td>
	                <td class="model">
	                	${o.sumprice }
	                </td>
	                <td class="model">
	                	${o.orderAddress }
	                </td>
	                <td class="quantity">
						${o.orderUsers }
					</td>
	                <td class="price" >
	                	${o.orderpone }
	                </td>
	                <td class="total">
						<c:if test="${o.state == 1 }">
							待发货
						</c:if>
						
						<c:if test="${o.state == 2 }">
							待收货
						</c:if>
						
						<c:if test="${o.state == 3 }">
							已完结
						</c:if>
						<c:if test="${o.state == 4 }">
							申请退款
						</c:if>
					</td>
	                <td class="total" style="text-align: center">
	                	<c:if test="${o.state == 1 }">
							<a href="updateOrderState.do?orderid=${o.orderid }" class="botton blue">发货</a>
							<a href="orderDetails.jsp"  class="botton blue">详情</a>
						</c:if>				
						<c:if test="${o.state == 2 }">
							<a href="updateOrderState.do?orderid=${o.orderid }" class="botton blue">查看物流</a>
							<a href="orderDetails.jsp"  class="botton blue">详情</a>
						</c:if>
						<c:if test="${o.state == 3}">
							<a href="updateOrderState.do?orderid=${o.orderid }" class="botton blue">删除</a>
							<a href="orderDetails.jsp"  class="botton blue">详情</a>
						</c:if>
						<c:if test="${o.state == 2 }">
							<a href="updateOrderState.do?orderid=${o.orderid }" class="botton blue">同意</a>
							<a href="orderDetails.jsp"  class="botton blue">拒绝</a>
						</c:if>
					</td>
	           </tr>		
			</c:forEach>-->

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