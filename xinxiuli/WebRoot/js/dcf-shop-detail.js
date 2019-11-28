$('.info-r>ul a').click(function(){
	location.href="../Show?cid="+$(this).attr("data-id")+"&gid="+$("#info").attr("data-goodsnum");
});

$('.info-r>p button').click(function(){
	$(this).addClass('btn-primary').siblings().removeClass('btn-primary');
});
//加入购物车模块
$(".info-r .tellusers").click(function(){
	alert("您好，请先登录再加入购物车");
});
$(".info-r .addcart").click(function(){
	var gid=$(".info-l").attr("data-goodsid");
	var cid=$(".info-r>ul>a>li>.btn-success").parent().parent().attr("data-id");
	var sid=$(".info-r>p>.btn-primary").attr("data-sizeid");
	$.ajax({
		type:"POST",
		url:"../SelectNum",
		data:{"gid":JSON.stringify(gid),"cid":JSON.stringify(cid),"sid":JSON.stringify(sid)},
		success:function(result){
			if(result!=null){
				var a=$(".cart-number").html();
				a++;
				$(".cart-number").html(a);
			}
		}
	});	
});
//立即选购
$(".info-r .buygoods").click(function(){
	location.href="";
});

//数量加减模块
function addshop(){
var n=1;
$('.info-r>h6>.reduce').click(function(){
	n--;
	if(n<1){
		n=1;
	  return;
	};
	$(this).siblings('.count').html(n);
});
$('.info-r>h6>.add').click(function(){
	n++;
	$(this).siblings('.count').html(n);
});
}
addshop();
//尺寸模块逻辑
$('#size>.one').click(function(){
   $(this).addClass('btn-info').siblings("img").attr("src",'/xinxiuli/img/productdel/6.jpg');
    $(this).siblings().removeClass('btn-info');
});
$('#size>.two').click(function(){
   $(this).addClass('btn-info').siblings("img").attr("src",'/xinxiuli/img/productdel/8.jpg');
    $(this).siblings().removeClass('btn-info');
});
$('#size>.three').click(function(){
	   $(this).addClass('btn-info').siblings("img").attr("src",'/xinxiuli/img/productdel/7.jpg');
	    $(this).siblings().removeClass('btn-info');
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