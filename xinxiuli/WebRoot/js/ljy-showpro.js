//获得地址栏参数值?  cat_id=55&name=xiaoming
function getUrlVal(property){
  //地址栏
  var urlStr = window.location.search.substring(1);
  var re = new RegExp('(^|&)'+ property +'=([^&]*)(&|$)');
  var result = urlStr.match(re);
  if(result == null){return null};
  return result[2];
};


//分类商品
(function(){
  //分类ID
  var divied_id = getUrlVal('divied_id');
  var showMessage = $(".showMessage").val();
  console.log(showMessage);
  $.ajax({
	  
	type:"POST",
	url:"/xinxiuli/diviedgoods",
	data:"divied_id="+divied_id,
	success:function(result){
		 if(result.length==0){
			 var str1 = `
				 <div class="col-md-12 blank content-center">
				 <h1>商家正在努力上架中……</h1>
				 </div>
				 `;
			 $('#goodsList').append(str1); 
		 }else{
			 for(var i = 0; i < result.length; i++){
				 var str = `
					 <div class="col-md-3 thumbnail-div">
						 <div class="thumbnail">
							 <a href="/xinxiuli/Show?gid=${result[i].goods_num}" target="_self"><img src="${result[i].goods_picture}"/></a>
							 <caption>
								 <p class="goods-name">${result[i].goods_name}</p>
								 <p class="goods-desc">${result[i].goods_desc}</p>
								 <p>¥　${result[i].goods_price}.00</p>
								 <p><span class="glyphicon  glyphicon-star"></span>${result[i].goods_star}</p>
							</caption>
						 </div>
					 </div>
				 `;
				 //每遍历一次就要去添加一次
				 $('#goodsList').append(str);
				 getFocus(); 
				 };
		 }
	        
	        
	        
	    
	},
  
  });
  
})();

function getFocus(){
	$(".thumbnail-div").each(function(){
		$(this).mouseenter(function(){
			$(this).css("box-shadow","0px 0px 15px 1.5px #95B8E7");
		});
		$(this).mouseleave(function(){
			$(this).css("box-shadow","none");
		});
	});

};
function showAll(){
	$('#goodsList').empty();
	$.ajax({
		type:"POST",
		url:"/xinxiuli/selectall",
		success:function(result){
			console.log(result);
			for(var i = 0; i < result.length; i++){
			var str = "<div class='col-md-3 thumbnail-div'><div class='thumbnail'><a href='/xinxiuli/Show?gid="+result[i].goods_num+"' target='_self'><img src='"+result[i].goods_picture+"'/></a><caption><p class='goods-name'>"+result[i].goods_name+"</p><p class='goods-desc'>"+result[i].goods_desc+"</p><p>¥　"+result[i].goods_price+".00</p><p><span class='glyphicon  glyphicon-star'></span>"+result[i].goods_star+"</p></caption></div></div>";
			 //每遍历一次就要去添加一次
			$('#goodsList').append(str);
			getFocus();
			}
		}
	});
	
}






