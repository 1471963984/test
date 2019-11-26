
//鼠标滚动切换导航栏
$(window).scroll(function(){
		var scrollTop = $(window).scrollTop();
		if(scrollTop > 130){
			$('.scrolled-index-header').css('display','block');
			$('.normal-index-header').css('display','none');
		}else{
			$('.scrolled-index-header').css('display','none');
			$('.normal-index-header').css('display','block');
		};
		if(scrollTop > 250){
			$('.box').fadeIn();
		}else{
			$('.box').fadeOut();
		}
	});
	
    //返回顶部
	$('.box').click(function(){
		$('html').animate({'scrollTop':0},500);
	});
	
	//普通导航栏搜索切换
	$('.input-right').click(function(){
		$('.bottom-box').fadeOut();
		$('.active-input').fadeIn();
		$('.rm-show').fadeIn();
	});
	$('.close-icon').click(function(){
		$('.bottom-box').fadeIn();
		$('.active-input').fadeOut();
		$('.rm-show').fadeOut();
	});
	
	//滚轮导航栏热门展示
	$('.search-input').focus(function(){
		$('.warp-rm-show').fadeIn();
	});
	$('.search-input').blur(function(){
		$('.warp-rm-show').fadeOut();
	});
	
//	轮播
	var liL = $('.banner-play>ul>li').length;
	$('.banner-play>ul').css('width',liL * parseInt($('.banner-play>ul>li:first').css('width')));
	var n = 0;
	var x = 0;
	var timer = null;
	$('.next').click(function(){
		if($('.banner-play ul').is(':animated')){return};
		n++;
		if(n > liL -1){
			n = 0;
			$('.banner-play ul').css('left',0);
		}
		$('.banner-play ul').animate({'left':-n * 1140},500,function(){
			if(n >= liL-1){
			    $('.banner-play ul').css('left',0);
				n = 0;
			};
		});
		x++;
		if(x > liL - 2){x = 0};
		$('.number span').eq(x).css('background','deeppink').siblings('span').css('background','#666');
		
	});
	
	timer = setInterval(function(){
		if($('.banner-play ul').is(':animated')){return};
		n++;
		if(n > liL -1){
			n = 0;
			$('.banner-play ul').css('left',0);
		}
		$('.banner-play ul').animate({'left':-n * 1140},500,function(){
			if(n >= liL-1){
			    $('.banner-play ul').css('left',0);
				n = 0;
			};
		});
	},3000);

	$('.prev').click(function(){
		if($('.banner-play ul').is(':animated')){return};
		if(n <= 0){
			n = liL - 1;
			$('.banner-play ul').css('left',-n *1140); 
		};
		n--;
		$('.banner-play ul').animate({'left': -n * 1140},500);
		x--;
		if(x < 0){
			x = liL - 2;
		}
		$('.banner-play span').eq(x).css('background','deeppink').siblings('span').css('background','#666');
	});

//商品分类
(function(){
  //发起请求
  $.get('http://www.wjian.top/shop/api_cat.php',{}, function(result){
    var obj = JSON.parse(result);
    console.log(obj);
    //验证
    if(obj.code != 0){
      console.log(obj.message);
      return;
    };
    //遍历数据
    var str = '';
    for(var i = 0; i < obj.data.length; i++){
      str += `
		<div class="tab-name">
			<a>${obj.data[i].cat_name}</a>
			<!--二级菜单-->
			<div class="second-tab">
				<div class="tab-first">
					<div class="title">类目</div>
					<div class="column">
						<div><a target="_self" href="/xinxiuli/qianduanyemian/showpro.jsp?cat_id=${obj.data[i].cat_id}">登机箱（18英寸-22英寸）</a></div>
						<div><a target="_self" href="/xinxiuli/qianduanyemian/showpro.jsp?cat_id=${obj.data[i].cat_id}">中号箱（23英寸-26英寸）</a></div>
						<div><a target="_self" href="/xinxiuli/qianduanyemian/showpro.jsp?cat_id=${obj.data[i].cat_id}">大号箱（27英寸-31英寸）</a></div>
						<div><a target="_self" href="/xinxiuli/qianduanyemian/showpro.jsp?cat_id=${obj.data[i].cat_id}">机长箱</a></div>
						<div><a target="_self" href="/xinxiuli/qianduanyemian/showpro.jsp?cat_id=${obj.data[i].cat_id}">儿童箱</a></div>
						<div><a target="_self" href="/xinxiuli/qianduanyemian/showpro.jsp?cat_id=${obj.data[i].cat_id}">硬箱</a></div>
						<div><a target="_self" href="/xinxiuli/qianduanyemian/showpro.jsp?cat_id=${obj.data[i].cat_id}">软箱</a></div>
						<div><a target="_self" href="/xinxiuli/qianduanyemian/showpro.jsp?cat_id=${obj.data[i].cat_id}">所有拉杆箱</a></div>
					</div>
				</div>
				<div class="tab-second">
					<div class="title">特别推荐</div>
					<div class="column">
						<div><a target="_self" href="/xinxiuli/qianduanyemian/showpro.jsp?cat_id=${obj.data[i].cat_id}">新品上市</a></div>
						<div><a target="_self" href="/xinxiuli/qianduanyemian/showpro.jsp?cat_id=${obj.data[i].cat_id}">畅销系列</a></div>
						<div><a target="_self" href="/xinxiuli/qianduanyemian/showpro.jsp?cat_id=${obj.data[i].cat_id}">CURV材质</a></div>
						<div><a target="_self" href="/xinxiuli/qianduanyemian/showpro.jsp?cat_id=${obj.data[i].cat_id}">缓震科技</a></div>
					</div>
				</div>
				<div class="tab-last">
					<div class="last-img">
						<img src="/xinxiuli/img/lasttab/-.jpg" />
					</div>
				</div>
			</div>
		</div>
     `;
    };
    $('.middle-bottom').append(str);
  });
})();
