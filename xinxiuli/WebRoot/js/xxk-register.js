//获得地址栏参数值?  cat_id=55&name=xiaoming
function getUrlVal(property){
  //地址栏
  var urlStr = window.location.search.substring(1);
  var re = new RegExp('(^|&)'+ property +'=([^&]*)(&|$)');
  var result = urlStr.match(re);
  if(result == null){return null};
  return result[2];
};

(function(){
//手机号
    var phonevalue='';
    var pwd2value='';
 $('#phone').blur(function(){
  	 var str = $(this).val();
  	 var sm =/^1[3456789][0-9]{9}/g;
  	  var strflag=false;
 
  	    strflag = str.length==11?true:false;
  	   console.log(strflag);
  	 if(sm.test(str)&&(strflag)){ 
  	   $(this).siblings('h6').html('　'); 
	   $(this).siblings('span').children('img').removeClass('show').addClass('hidden'); 
	   phonevalue=str;
  	 }else{
  	 $(this).siblings('h6').html('*请输入正确的手机号码');
  	 $(this).siblings('span').children('img').removeClass('hidden').addClass('show'); 
  	 }
  	 
 });
 
 // 密码
 $('#pwd1').blur(function(){
   var str=$(this).val(); 
   var sm=/[0-9]+/g;
   var st=/[a-zA-Z]+/g;
    
   if((st.test(str))&&(sm.test(str))&&(str.length>5&&str.length<9)){    
	  　 $(this).siblings('h6').html('　'); 
	  　 $(this).siblings('span').children('img').removeClass('show').addClass('hidden'); 
   }else{
    $(this).siblings('h6').html('*密码不符合条件');
  	$(this).siblings('span').children('img').removeClass('hidden').addClass('show'); 
 	
   }
 });
 　
 //确认密码
 $('#pwd2').blur(function(){
 	var str1 = $('#pwd1').val();
 	var str2 = $(this).val();
 	if(str1==str2){
      $(this).siblings('h6').html('　'); 
      $(this).siblings('span').children('img').removeClass('show').addClass('hidden'); 
      pwd2value=str2;
 	}else{
 	$(this).siblings('h6').html('*密码确认错误');
  	$(this).siblings('span').children('img').removeClass('hidden').addClass('show'); 	
 	 pwd2value='';
 	}
 
  });
  
  //接收
  $('#check').click(function(){
  	  var bool=$(this).prop('checked')==true?true:false;
     if(bool){
     $(this).siblings('h6').html('　'); 
  
     }else{
     $(this).siblings('h6').html('请接受新秀丽隐私政策和销售条款');
  	 $(this).siblings('span').children('img').removeClass('hidden').addClass('show'); 	
     }
  });
  
  //点击注册 
 $('#submit').click(function(){
 	if(!($('#check').prop('checked'))){
 		return;
 	}
 
    if(!(phonevalue&&pwd2value)){
      return;	
    }
   $.post('http://www.wjian.top/shop/api_user.php',{
   	status:'register',
   	username:phonevalue,
   	password:pwd2value,
   },function(re){
   var obj=JSON.parse(re);
   if(obj.code!=0){
    $('#phone').siblings('h6').html('用户名不可用，已注册');
    return;
   };
   alert('注册成功，点击跳转首页登录页面');
   //首页
   window.location.href='/xinxiuli/qianduanyemian/index.jsp';
   });
 }); 
 })();