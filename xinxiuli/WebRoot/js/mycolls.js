(function(){
	var account_num = $(".mycart-sercher").attr("cart-number");
	$.ajax({
		type: "POST",
		url:"/xinxiuli/collgoods",
		data:"account_num="+account_num,
		success:function(result){
			console.log(result);
			$(".info_r>ul").empty();
			var str=``;
			if(result.length!=0){
				for(var i = 0;i < result.length;i++){
					str+=`
						<div class="title-about">我的收藏</div>
						<li>
						<div class="mycolls">
						<a href="/xinxiuli/Show?gid=${result[i].goods_num}">
						<img src="${result[i].goods_picture}" /></a>
						<div class="goods-name">${result[i].goods_desc}</div>
						<div class="goods-desc">${result[i].goods_name}</div>
						<div class="goods-price">￥${result[i].goods_price}.00</div>
						<div class="goods-delete" title="删除商品" goodsid="${result[i].goods_id}" onclick="deleteColls(this)"></div>
						
						</div>
						</li>
					`;
				}
				$(".info_r>ul").append(str);
			}
			if(result.length==0) {
				str+=`
					<div class="title-about">我的收藏</div>
					<div class="collempty"><h2>亲，快去选一件宝贝收藏吧！</h2></div>
				`;
				$(".info_r>ul").append(str);
			}
		},
	});
})();
					
function deleteColls(obj){	
	$('#myModal').modal('show');
	var goods_id = obj.getAttribute("goodsid");
	var account_num = $(".mycart-sercher").attr("cart-number");
	var s = "{'goods_id':"+goods_id+",'account_num':"+account_num+"}";
	$('.btn-ss').click(function(){
		$.ajax({
			type:"POST",
			url:"/xinxiuli/updatecolls",
			data:"s="+s,
			success:function(result){
				$(".info_r>ul").empty();
				var str=``;
				if(result.length!=0){
					for(var i = 0;i < result.length;i++){
						str+=`
							<div class="title-about">我的收藏</div>
							<li>
							<div class="mycolls">
							<a href="/xinxiuli/Show?gid=${result[i].goods_num}">
							<img src="${result[i].goods_picture}" /></a>
							<div class="goods-name">${result[i].goods_desc}</div>
							<div class="goods-desc">${result[i].goods_name}</div>
							<div class="goods-price">￥${result[i].goods_price}.00</div>
							<div class="goods-delete" title="删除商品" goodsid="${result[i].goods_id}" onclick="deleteColls(this)"></div>
							
							</div>
							</li>
						`;
					}
					$(".info_r>ul").append(str);
				}
				if(result.length==0) {
					str+=`
						<div class="title-about">我的收藏</div>
						<div class="collempty"><h2>亲，快去选一件宝贝收藏吧！</h2></div>
					`;
					$(".info_r>ul").append(str);
				}
			},
		});
		$('#myModal').modal('hide');
	});
	$('.btn-dr').click(function(){
		$('#myModal').modal('hide');
	});
};