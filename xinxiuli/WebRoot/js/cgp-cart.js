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
	})
	
	  //请求用户的购物车数据
	  function goodsList(page, callback){
	    var page = page ? page : 1;
	    //页面打开就可以看到商品
	    $.get('http://www.wjian.top/shop/api_goods.php',{
	      'pagesize':4,
	      'page':6,
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
	  goodsList(3, function(result){
	    var goodsList = result.data;
//	    console.log(goodsList)
	    //得到数据了之后，在这里操作数据
	    //组装DOM结构
	    for(var i = 0; i < goodsList.length; i++){
	      //拿到每一项  goodsList[i].goodsName
	      var str = `
	        <div class="goods-list-js">
            	<div class="list-box">
            		<div class="goods-message">
            			<input type="checkbox" class="checkbox" />
            			<span class="lazyload"><img data-toggle="modal" data-target="#myModal"src="${goodsList[i].goods_thumb}"/></span>
            			<div class="goods-about">
            				<a href="javascript:;" data-toggle="modal" data-target="#myModal">${goodsList[i].goods_desc}</a>
            				<div class="goods-brand">ACTAEON</div>
            				<div class="goods-spec">
                				<label>颜色：</label>
                				<p>月光白</p>
                				<label>尺寸：</label>
                				<p>均码</p>
                			</div>
                			<div class="goods-operation">
                				<img src="/xinxiuli/shop-imgs/collection-no.png" alt="移入收藏夹" />
                				<div class="goods-middle">|</div>
                				<img src="/xinxiuli/shop-imgs/edit.png" alt="编辑商品" data-toggle="modal" data-target="#myModal" />
                			</div>
            			</div>
            		</div>
            		<div class="sell-srice">${goodsList[i].price}</div>
            		<div class="goods-delete" title="删除商品"></div>
        		</div>
        	</div>
	      `;
	      //把每次组装好的添加进table
	      $('.goods-list-box').append(str);
	    };
	    //所有的业务逻辑都在这之后
	    clickAll();
	  });
	  
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
//	    console.log(lunboList);
		for(var i = 0; i < lunboList.length; i++){
	      var str2 = `
	      	<div class="tuijian-item">
				<img src="${lunboList[i].goods_thumb}" data-toggle="modal" data-target="#myModal" />
				<div class="goods-name text-left ">
					<a href="javascript:;" data-toggle="modal" data-target="#myModal">${lunboList[i].goods_desc}</a>
					<input class="btn btn-info" value="查看详情" data-toggle="modal" data-target="#myModal" />
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
	      //要做商品减的业务
	      //console.log(event.target.checked)
	      if(event.target.checked == true){
	        //选中所有的
	        $('.checkbox').each(function(){
	           $(this).attr('checked', true);
	          //给当前元素加个标识(自定义的属性)
	          $(this).attr('data-price', 'active');        
	        });
	      }else{
	        //选中所有的
	        $('.checkbox').each(function(){
	          $(this).attr('checked', false);
	          //拿掉标识(自定义的属性)
	          $(this).attr('data-price', '');
	        });
	      };
	      //求总价
	      sumAll();
	    };
	    
	    //点击单选
	    if(event.target.className == 'checkbox'){
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
//	    console.log(event.target);
	    //点击删除
	    if(event.target.className == 'goods-delete'){
	      //要做商品减的业务
	      console.log('点击了删除');
	      //找到tr删除自己
	      var tab = event.target.parentNode.parentNode.parentNode;
	      var tr = event.target.parentNode.parentNode;
	        tab.removeChild(tr);
	      //$(event.target).html('哈另一个')
	      //调用总价
	      sumAll();
	    };
	    var allinput = $('.goods-list-js');
	    //删除选中
	    if(event.target.className == 'card-left-top-title'){
	       for(var i=0;i<allinput.length;i++){	
	       if($('.goods-message').children('input').getAttribute("data-price")=='active'){
	       		console.log('a');
	       }
	      }
	      //调用总价
	      sumAll();
	    };


	    //点击继续购物跳转到首页
	    if(event.target.className == 'card-bottom-bottom'){
	    	window.location.href="index.html";
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
	
	//轮播图详情淡入淡出
	//默认全部隐藏
//	$('.tuijian-item').children('.goods-name').hide();
//	$('.tuijian-item').each(function(){
//		$(this).mouseenter(function(){
//			console.log(this);
//			$(this).children('.goods-name').show();
//		})
//	})