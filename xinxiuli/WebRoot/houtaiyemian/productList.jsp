<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>添加商品</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
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
    </div>
    <table class="table table-hover text-center" id="table">
        <thead>
        <tr>
            <th width="10%">商品ID</th>
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
        
        </tbody>
    </table>
</div>
<!--<div class="panel admin-panel margin-top" id="add">
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 修改内容</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="updateProduct.do" enctype="multipart/form-data">
            <input type="hidden" name="productId" id="productId"/>
            <div class="form-group">
                <div class="label">
                    <label>图片</label>
                </div>
                <div class="field">
                    <input id="productImg" type="file" class="input w50" value="" name="file" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>产品名</label>
                </div>
                <div class="field">
                    <input id="productName" type="text" class="input w50" value="" name="productName" data-validate="required:请输入标题" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>单价</label>
                </div>
                <div class="field">
                    <input id="productPrice" type="text" class="input w50" name="productPrice" value=""  />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>描述：</label>
                </div>
                <div class="field">
                    <textarea id="productDescribe" type="text" class="input" name="productDescribe" style="height:120px;" value=""></textarea>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit" onclick="updateProduct()"> 确认修改</button>
                </div>
            </div>
        </form>
    </div>
</div>-->
</body>
</html>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
    <script src="js/pintuer.js"></script>
<script>
	//加载商品数据至下列输入框
	function loadRow(row){
	    $("#productId").val(row.cells[0].innerHTML);
		$("#productImg").val(row.cells[1].childNodes[2].value);
		$("#productName").val(row.cells[2].innerHTML);
		$("#productPrice").val(row.cells[3].innerHTML);
		$("#productDescribe").val(row.cells[4].innerHTML);    
	}	
	function deleteProduct(productId) {
	    if(confirm("您确定要删除吗?")){
	   location.href="deleteProduct.do?produtid="+productId;
	    }
	}
	
	function updateProduct() {
	    load(1);
	}
	$("#addproduct>button").click(function(){
		location.href="addProduct.jsp";
	})
	
    function del(id,mid){
        if(confirm("您确定要删除吗?")){

        }
    }
</script>