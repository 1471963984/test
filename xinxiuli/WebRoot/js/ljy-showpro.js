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
  var catId = getUrlVal('cat_id');
  $.get('http://www.wjian.top/shop/api_goods.php',{
    cat_id : catId,
    page : 1,
    pagesize : 8
  },function(result){
      var obj = JSON.parse(result);
      console.log(obj);
      //验证
      if(obj.code != 0){
        console.log(obj.message);
        var str1 = `
          <div class="col-md-12 blank content-center">
          	<h1>商家正在努力上架中……</h1>
          </div>
        `;
        $('#goodsList').append(str1); 
        return;
      };
      //渲染
      for(var i = 0; i < obj.data.length; i++){
        var str = `
        <div class="col-md-3 thumbnail-div">
          <div class="thumbnail">
            <a href="/xinxiuli/qianduanyemian/productdetail.jsp?goods_id=${obj.data[i].goods_id}" target="_blank"><img src="${obj.data[i].goods_thumb}"/></a>
            <caption>
              <p class="goods-name">${obj.data[i].goods_name}</p>
              <p class="goods-desc">${obj.data[i].goods_desc}</p>
              <p>${obj.data[i].price}</p>
              <p><span class="glyphicon  glyphicon-star"></span>${obj.data[i].star_number}</p>
              <button class="btn btn-info">加入购物车</button>
            </caption>
          </div>
        </div>
        `;
        //每遍历一次就要去添加一次
        $('#goodsList').append(str); 
      };
      
      
  });
  
})();








