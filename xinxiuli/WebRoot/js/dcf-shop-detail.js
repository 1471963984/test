//获得地址栏参数值?  cat_id=55&name=xiaoming
function getUrlVal(property){
  //地址栏
  var urlStr = window.location.search.substring(1);
  var re = new RegExp('(^|&)'+ property +'=([^&]*)(&|$)');
  var result = urlStr.match(re);
  if(result == null){return null};
  return result[2];
};

////打开页面渲染数据
(function(){
  var goodsId = getUrlVal('goods_id');
  //发起请求
  $.get('http://www.wjian.top/shop/api_goods.php', {
    goods_id : goodsId,
  }, function(result){
    var obj = JSON.parse(result);
    var goods = obj.data[0];
    //每一个tr
		var str=`
		<div class="info-l">
	            <div class="big"><img src="${goods.goods_thumb}"/>
					<div class="subinfo">					
					</div>
					<div class="subinfo-show">
						
					</div>
				</div>		
				
				<ul>
					<span class="glyphicon glyphicon-chevron-left"></span>
					<li><img src="${goods.goods_thumb}"/></li>
					<li><img src="/xinxiuli/img/productdel/1.jpg"/></li>
					<li><img src="/xinxiuli/img/productdel/2.jpg"/></li>
					<li><img src="/xinxiuli/img/productdel/4.jpg"/></li>
					<span class="glyphicon glyphicon-chevron-right"></span>
				</ul>
			</div>
			<div class="info-r">
				<h2>${goods.goods_name}</h2>
				<p>RAYDIEN <span class="glyphicon glyphicon-star-empty"></span>
					 <span class="glyphicon glyphicon-star-empty"></span> 
					 <span class="glyphicon glyphicon-star-empty"></span>
					 <span class="glyphicon glyphicon-star-empty"></span>
				</p>
				<h5>${goods.goods_desc}</h5>
				<p>${goods.price}<span>手机购买</span><span class="glyphicon glyphicon-th-large"></span></p>
				<hr/>
				<p>颜色</p>
				<ul>
					<a href="#"><li></li></a>
					<a href="#" ><li></li></a>
					<a href="#" class="active"><li></li></a>
				</ul>
				<p>尺寸 <button class="btn btn-group-sm btn-primary">20英寸</button><button class="btn btn-group-sm">23英寸</button></p>
				<h6>数量<span class="reduce">-</span><span class="count">1</span><span class="add">+</span></h6>
				<hr />
				<a href="javascript:"><button class="btn btn-default">加入购物车</button></a>
				<a href="javascript:"><button class="btn btn-default">立即选购</button></a>
				<h4>需要帮助？您可以 <a href="javascript:">联系在线客服</a> 或 致电：4008-870-566</h4>
				<hr />
				<h3><span class="glyphicon glyphicon-heart"></span>添加至收藏
				    <p>分享：
				    	<a href="javascript:"><img src="/xinxiuli/img/productdel/icon-01.png"/></a>
				    	<a href="javascript:"><img src="/xinxiuli/img/productdel/icon-02.png"/></a>
				    </p>
				</h3>
			</div>
		       `;
    $('#info').html(str);
    $('.subinfo-show').css({
	    'background-image':'url('+goods.goods_thumb+')'
	});
	info();
  });
  
})();


//封装渲染块业务逻辑
function info(){
$('.info-r>ul a').click(function(){
	$(this).addClass('active').siblings().removeClass();
});
$('.info-r>p button').click(function(){
	$(this).addClass('btn-primary').siblings().removeClass('btn-primary');
});
//数量加减模块
var n=1;
$('.info-r>h6>.reduce').click(function(){
	n--;
	if(n<1){
		n=1;
	  return;
	};
	$(this).siblings('.count').html(n);
})
$('.info-r>h6>.add').click(function(){
	n++;
	$(this).siblings('.count').html(n);
})
//尺寸模块逻辑
$('#size>.one').click(function(){
   $(this).addClass('btn-info').siblings("img").attr("src",'/xinxiuli/img/productdel/6.jpg');
    $(this).siblings('.two').removeClass('btn-info');
});
$('#size>.two').click(function(){
   $(this).addClass('btn-info').siblings("img").attr("src",'/xinxiuli/img/productdel/7.jpg');
    $(this).siblings('.one').removeClass('btn-info');
});
//放大镜业务逻辑
(function(){
  //事件:鼠标移入到up再移动，再移出
  $('.big').mouseenter(function(event){
    //在移入里面移动,滑块跟随
    $('.big').mousemove(function(event){
      var x = event.clientX - $('.big').offset().left - $('.subinfo').outerWidth()/2;
      var y = event.clientY - $('.big').offset().top - $('.subinfo').outerHeight()/2 + $(document).scrollTop();
      
      //验证控制范围
      if(x <= 0){x = 0};
      if(y <= 0){y = 0};
      if(x >= $('.big').width() - $('.subinfo').outerWidth()){
        x = $('.big').width() - $('.subinfo').outerWidth();
      }
      if(y >= $('.big').height() - $('.subinfo').outerHeight()){
        y = $('.big').height() - $('.subinfo').outerHeight();
      }
      
      //设置滑块
      $('.subinfo').css({
        left : x,
        top : y,
      });
      //设置大图背景
      var bili = (600 - $('.subinfo-show').width()) / ($('.big').width() - $('.subinfo').outerWidth()); 
      var str = -x*bili + 'px ' + -y*bili + 'px';
      $('.subinfo-show').css('backgroundPosition', str)
    });
  });
	  $('.info-l ul li').each(function(){
	    $(this).mouseenter(function(){
	      //拿到当前移入的图片src
	      var imgSrc = $(this).children().attr('src');
	      //改结构图
	      $('.big img').attr('src', imgSrc);
	      $('.subinfo-show').css({
	        'background-image':'url('+ imgSrc +')'
	      });
	    });
	  });
  //鼠标移入移出
  $('.big').hover(function(){
    $('.subinfo, .subinfo-show').show();
  }, function(){
    $('.subinfo, .subinfo-show').hide();   
  });
})();

};

//页面数据业务逻辑

//滑轮模块
$('.subsize-bot>span').mouseenter(function(){
	$(this).children('h6').show().addClass('animated fadeInDown');
})
$('.subsize-bot>span').mouseleave(function(){
	$(this).children('h6').hide();
})
//轮播模块
$('.like-bg>span').click(function(){
	$('.like-bg .active').removeClass('active').siblings('span').addClass('active');	
	$(this).siblings('ul').children('.currnt').removeClass('currnt').siblings('li').addClass('currnt animated fadeIn');
});
var n=1;
setInterval(function(){
   $('.like-bg .active').removeClass('active').siblings('span').addClass('active'); 
   $('.like-bg>span').siblings('ul').children('.currnt').removeClass('currnt').siblings('li').addClass('currnt animated fadeIn');
},5000);
//跳转顶部样式
$(window).scroll(function(){
	var scrollTop = $(window).scrollTop();
	if(scrollTop >= 130){
		$('.scrolled-index-header').show();
		$('.normal-index-header').hide()
	}else{
		$('.scrolled-index-header').hide();
		$('.normal-index-header').show();
	};
	if(scrollTop > 250){
		$('.box').fadeIn();
	}else{
		$('.box').fadeOut();
	}
});

$('.box').click(function(){
	$('html').animate({'scrollTop':0},1000);
	
});