
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

//商品一级菜单渲染
(function(){
  //发起请求
	 $.ajax({
         type: "POST",                            //传数据的方式
         url: "/xinxiuli/first",                             //servlet地址
         success: function(result){               //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
             var str = '';
             for(var i = 0;i<result.length;i++){
            	 str+=`
            		 <div class="tab-name" id="${result[i].first_num}">
            		 	<a>${result[i].first_name}</a>
            		 	<div class="second-tab">
	    					<div class="tab-first">
	    						<div class="title">类目</div>
	    						<div class="column first-column"></div>
	    				    </div>
	    				    <div class="tab-last">
	    					    <div class="last-img">
	    					      <img src="/xinxiuli/img/lasttab/-.jpg" />
	    						</div>
    					    </div>
	    				</div>
            		 </div>
            	 `;
             }
             $('.middle-bottom').append(str);
             enterFirst();
         }
     });
})();

//二级菜单渲染
function enterFirst(){
$('.tab-name').mouseenter(function(){
	 var firstnum = $(this).prop("id");
	 $.ajax({
         type: "POST",                            //传数据的方式
         url: "/xinxiuli/second",                             //servlet地址
         data:"firstnum="+firstnum,
         success: function(result){               //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
        	 result=JSON.parse(result);
        	 var str = '';
        	 $('.first-column>div').remove();
             for(var i = 0;i<result.length;i++){
            	 str+=`
					<div><a target="_self" href="/xinxiuli/qianduanyemian/showpro.jsp?divied_id=${result[i].divied_num}">${result[i].second_name}</a></div>					
            	 `;
            	
             }
             $('.first-column').append(str);
         }
     });
});
};

(function(){
	var account_num = $(".mycart-sercher").attr("cart-number");
	$.ajax({
		 type: "POST",                            //传数据的方式
         url: "/xinxiuli/cartnum",                //servlet地址
         data: "account_num="+account_num,
         success: function(result){               //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
        	 $(".cart-number").html(result.length);
         }
	});

})();


