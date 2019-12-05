	//底部轮播图
	//设置信号量
	var n = 0;
	//圆点跟随
	$('.number span').each(function(i){
		if($('.goods-tuijian').is(':animated')){
			return;
		}
		//批量绑定事件
		$(this).click(function(){
			//联动
			n = i;
			$('.goods-tuijian').animate({left : -i * 1000},600);
			$('.number span').eq(n).css('background','black')
		.siblings('span').css('background','#666');
		})
	});
	
	
	clickAll();
	  //轮播图
	  function lunboList(page, callback){
	    var page = page ? page : 1;
	    //页面打开就可以看到商品
	    $.get('http://www.wjian.top/shop/api_goods.php',{
	      'pagesize':12,
	      'page':19,
	    }, function(result){
	      var result = JSON.parse(result);
	      //验证
	      if(result.code != 0){
	        console.log('数据请求失败');
	        return;
	      };
	      //调用
	      callback(result);
	    }); 
	  };
	  
	  lunboList(1, function(result){
	    var lunboList = result.data;
		for(var i = 0; i < lunboList.length; i++){
	      var str2 = `
	      	<div class="tuijian-item">
				<img src="${lunboList[i].goods_thumb}" />
				<div class="goods-name text-left ">
					<a href="javascript:;">${lunboList[i].goods_desc}</a>
					<input class="btn btn-info" value="查看详情" />
				</div>
			</div>
	      `;
	      $('.goods-tuijian').append(str2);
	    };
	    lunbobox();
	  });
	function clickAll(){
	  //点击加减数量变   小计变  总价变
	  //点击全选        总价变
	  //点击单选        总价变
	  //点击删除        当前元素tr删除
	  
	  //点击整个表格
	  $('.main-left').click(function(event){
	    //console.log(event);//打印点击的元素
	    //验证，判断点击的是哪一个元素
	    //点击全选
	    if(event.target.className == 'cartcheckbox'){
	    	console.log("点击了全选");
	      //要做商品减的业务
	      if(event.target.checked == true){
	        //选中所有的
	        $('.checkbox').each(function(){
	           $(this).prop('checked', true);
	          //给当前元素加个标识(自定义的属性)
	          $(this).attr('data-price', 'active');        
	        });
	      }else{
	        //选中所有的
	        $('.checkbox').each(function(){
	          $(this).prop('checked', false);
	          //拿掉标识(自定义的属性)
	          $(this).attr('data-price', '');
	        });
	      };
	      //求总价
	      sumAll();
	    };
	    
	    //点击单选
	    if(event.target.className == 'checkbox'){
	    	console.log("点击了单选");
	      //要做商品减的业务
	      //console.log('点击了单选');
	      if(event.target.checked == true){
	        //给当前元素加个标识(自定义的属性)
	        event.target.setAttribute('data-price', 'active');
	      }else{
	        //拿掉标识(自定义的属性)
	        event.target.setAttribute('data-price', '');       
	          $(this).children().children().children('.goods-list-js').removeClass('active');
	      }
	      //求总价
	      sumAll();
	    };
	     


	    //点击继续购物跳转到首页
	    if(event.target.className == 'card-bottom-bottom'){
	    	window.location.href="/xinxiuli/index.jsp";
	    };
	  });
	};  
	
	//求小计
	function subtotal(that, count){
	  //拿到单价
	  var price = parseInt(that.parentNode.nextElementSibling.innerHTML);
	  //拿到小计元素
	  var subtotalDom = that.parentNode.nextElementSibling.nextElementSibling;
	  //设置
	  subtotalDom.innerHTML = price * count + '.00';
	};
	
	//求总价方法
	function sumAll(){
	  var sum = 0;
	  //拿到所的   active
	  $('[data-price="active"]').each(function(){
	    sum += parseInt($(this).parent().siblings('.sell-srice').html());
	  });
//	  console.log(sum);
	  //设置总价
	  $('.message-list-total p').html('¥' + sum + '.00');
	  $('.message-list-subtotal p').html('¥' + sum + '.00');
	}
	
	//求轮播图容器宽度
	function lunbobox(){
		var liL = $('.goods-tuijian .tuijian-item').length;
		//设置,获取li的长度
		$('.goods-tuijian').css({width : liL * 250,});
	}
	
(function(){
	var account_num = $(".mycart-sercher").attr("cart-number");
	$.ajax({
		
		type:"POST",
		url:"/xinxiuli/mycart",
		data:"account_num="+account_num,
		success:function(result){
			
			console.log(result);
			var str = ``;
			for(var i=0;i<result.length;i++){
				str+=`
					<div class="goods-list-js">
					<div class="list-box">
					<div class="goods-message">
					<input type="checkbox" class="checkbox" />
					<span class="lazyload"><img src="${result[i].goods_img}"/></span>
					<div class="goods-about">
					<a href="/xinxiuli/Show?gid=${result[i].goods_num}" >${result[i].goods_desc}</a>
					<div class="goods_num" style="display:none" >${result[i].goods_num}</div>
					<div class="goods-brand">${result[i].goods_name}</div>
					<div class="goods-spec">
					<label>颜色：</label>
					<p>${result[i].goods_color}</p>
					<label>尺寸：</label>
					<p>${result[i].goods_size}</p>
					</div>
					<div class="goods-operation">
					<span class="collGoods glyphicon glyphicon-heart-empty"  goodsid="${result[i].goods_id}">加入收藏</span>
					<div class="goods-middle">|</div>
					<a href="/xinxiuli/Show?gid=${result[i].goods_num}"><img src="/xinxiuli/shop-imgs/edit.png" alt="编辑商品"/></a>
					</div>
					</div>
					</div>
					<div class="sell-srice">${result[i].goods_price}.00</div>
					<div class="goods-delete" title="删除商品" onclick="deleteGoods(this)" goodsid="${result[i].goods_num}"></div>
					</div>
					</div>
				`;
			}
			$(".goods-list-box").append(str);
			collGoods();
		},
	});
	
})();
					
function deleteGoods(obj){
	$('#myModal').modal('show');
	var goods_id = obj.getAttribute("goodsid");
	var account_num = $(".mycart-sercher").attr("cart-number");
	var s = "{'goods_id':"+goods_id+",'account_num':"+account_num+"}";
	$('.btn-ss').click(function(){
		$.ajax({
			type:"POST",
			url:"/xinxiuli/deleteGoods",
			data:"s="+s,
			success:function(result){
				$(".goods-list-box").empty();
				var str = ``;
				for(var i=0;i<result.length;i++){
					str+=`
						<div class="goods-list-js">
						<div class="list-box">
						<div class="goods-message">
						<input type="checkbox" class="checkbox" />
						<span class="lazyload"><img src="${result[i].goods_img}"/></span>
						<div class="goods-about">
					<a href="/xinxiuli/Show?gid=${result[i].goods_num}" >${result[i].goods_desc}</a>
					<div id="goods_num" style="display:none">${result[i].goods_num}</div>
					<div class="goods-brand">${result[i].goods_name}</div>
					<div class="goods-spec">
					<label>颜色：</label>
					<p>${result[i].goods_color}</p>
					<label>尺寸：</label>
					<p>${result[i].goods_size}</p>
					</div>
					<div class="goods-operation">
					<span class="collGoods glyphicon glyphicon-heart-empty"  goodsid="${result[i].goods_id}"></span>
					<div class="goods-middle">|</div>
					<img src="/xinxiuli/shop-imgs/edit.png" alt="编辑商品" data-toggle="modal" data-target="#myModal" />
						</div>
					</div>
					</div>
					<div class="sell-srice">¥　${result[i].goods_price}.00</div>
					<div class="goods-delete" title="删除商品" onclick="deleteGoods(this)" goodsid="${result[i].goods_num}"></div>
					</div>
					</div>
					`;
				}
				$(".goods-list-box").append(str);
				collGoods();
				location.href="/xinxiuli/qianduanyemian/mycart.jsp";
			},
			
		});
		$('.btn-dr').click(function(){
			$('#myModal').modal('hide');
		});
	});
};
//商品结算
//商品结算
function jiesuan(){
	var str = "";
	$('[data-price=active]').each(function(){
		//console.log(this);
		var goods_num = $(this).siblings(".goods-about").children('.goods_num').html()+",";
		str=str+goods_num;
//		alert(goods_num);
	})
	if(str!=""){
		location.href="/xinxiuli/jiesuan?goods_num="+str;
	}
};


function collGoods(){
	$(".collGoods").click(function(){
		var obj=$(this);
		var goods_id = $(this).attr("goodsid");
		
		if(obj.html()=="加入收藏"){
			$.ajax({
				type:"POST",
				url:"/xinxiuli/MyCollection",
				data:"gid="+goods_id,
				success:function(result){
					if(result=="true"){
						obj.removeClass("glyphicon-heart-empty").addClass("glyphicon-heart");
						obj.html("取消收藏");
					};
				},
			});
		}
		if(obj.html()=="取消收藏"){
			$.ajax({
				type:"POST",
				url:"/xinxiuli/MyCollection",
				data:"gid="+goods_id+"&&remove=remove",
				success:function(result){
					
				obj.removeClass("glyphicon-heart").addClass("glyphicon-heart-empty");
				obj.html("加入收藏");
					
				},
			});
		}
		});
	
}


