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
	 //验证码 登录手机号
	var phonevalue1 ='';
	var phonevalue2 ='';
	var pwdvalue ='';
	var flag =false;
 $('#phone1').blur(function(){
  	 var str = $(this).val();
  	 var sm =/^1[3456789][0-9]{9}/g;
  	  console.log(str);
  	    var strflag=false;
  	    strflag = str.length==11?true:false; 
  	 
  	 if(sm.test(str)&&(strflag)){
          phonevalue1=str;                       
  	   $(this).siblings('h6').html('　'); 
	   $(this).siblings('span').children('img').removeClass('show').addClass('hidden'); 
  	 }else{
  	 $(this).siblings('h6').html('*请输入正确的手机号码');
  	 $(this).siblings('span').children('img').removeClass('hidden').addClass('show'); 
  	 }
  	 
 });
    //密码登录手机号
  $('#phone2').blur(function(){
  	 var str = $(this).val();
  	 var sm =/^1[3456789][0-9]{9}/g;
  	  var strflag=false;
  	  strflag = str.length==11?true:false;
  	 if(sm.test(str)&&(strflag)){
  	 	phonevalue2=str;
  	   $(this).siblings('h6').html('　'); 
	   $(this).siblings('span').children('img').removeClass('show').addClass('hidden'); 
  	 }else{
  	 
  	 $(this).siblings('h6').html('*请输入正确的手机号码');
  	 $(this).siblings('span').children('img').removeClass('hidden').addClass('show'); 
  	 }
  	 
 });
 
  // 密码
	 $('#pwd1').blur(function(){
	   var str=$(this).val(); 
	   var sm=/[0-9]+/g;
	   var  st=/[A-z]+/g;
	      
	   if(sm.test(str)&&st.test(str)&&(str.length>5&&str.length<9)){    
	    pwdvalue=str;
	  　 $(this).siblings('h6').html('　'); 
	  　 $(this).siblings('span').children('img').removeClass('show').addClass('hidden'); 
	   }else{
	    $(this).siblings('h6').html('*密码不正确,请重新输入');
     	$(this).siblings('span').children('img').removeClass('hidden').addClass('show'); 
	   }
 });
 
   //登录选择
  $('#loginselect').click(function(){
//              
     var secode = $('#security-code').css('display')=='none'?'block':'none';
     $('#security-code').css('display',secode);  
  	 var pacode =$('#password-code').css('display')=='none'?'block':'none';
  	 $('#password-code').css('display',pacode);
      flag = flag==false?true:false;
  });
 
  
    //登陆
  $('#loginbtn').click(function(){
  	 //验证码登陆
  	if(!flag){
//	  phonevalue1	
  	
  	}
  	
  	//密码账号等陆
    if(flag){
//   phonevalue2      		
    console.log(phonevalue2,pwdvalue);   
    if(phonevalue2==''||pwdvalue==''){
    alert('不为空');
     return;     
     }
    $.post('http://www.wjian.top/shop/api_user.php',{
    statu:'login',
    username:phonevalue2,
    password:pwdvalue,
    },function(re){
    var obj=JSON.parse(re);
      if(obj.code==2002){
         alert('用户名不存在');	
         return;
      };
      
      if(obj.code==1001){
      	alert('密码错误');
      	return;
       };
       
     //登陆成功
     alert('登陆成功');      
    //登陆状态
    localStorage.setItem('username',obj.data.username);
    localStorage.setItem('token',obj.data.token);
    
    $('#login').modal('hide');
     checkLogin();
     
//     //求传过来的goods_id
//    var goodsId = getUrlVal('goods_id');
//    if(goodsId){
//      location.href = 'product.html?goods_id='+goodsId;              
//    }else{
//      location.href = 'index.html';         
//    };
      
    })
     }
  });
  
  
})();


 //首页打开,判断用户是否登陆
 function checkLogin(){
   	var userName = localStorage.getItem('username');
   	var token=localStorage.getItem('token');
   	console.log(token);
   //验证
   if(token){
   	console.log('有');	
   // 隐藏 登陆    注册
   //显示登陆等账号
   	}else{
    console.log('无');		
    //显示 登陆    注册	
    //隐藏  登陆等账号     
   	};
   	
   };
 checkLogin();
  
//点击退出
//(function(){
// $('#exit').click(
//	localStorage.removeItem('username');
//	localStorage.removeItem('token');
//	checkLogin();
//})();
