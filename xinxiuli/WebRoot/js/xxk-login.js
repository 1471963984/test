//获得地址栏参数值?  cat_id=55&name=xiaoming
function getUrlVal(property){
  //地址栏
  var urlStr = window.location.search.substring(1);
  var re = new RegExp('(^|&)'+ property +'=([^&]*)(&|$)');
  var result = urlStr.match(re);
  if(result == null){return null};
  return result[2];
};

//写cookies
function setCookie(name, value) {
    var Days = 30;
    var exp = new Date();
    exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
}

//读取cookies 
function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    if (arr = document.cookie.match(reg)) return unescape(arr[2]);
    else return null;
}

//删除cookies 
function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null) document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}

 function  autologin(){
	if(getCookie("username")!=null&&getCookie("password")!=null){
		 var fflag=true; 
		 $('#phone2').val(getCookie("username"));
		 $('#pwd1').val(getCookie("password"));
		 $('#phone2').focus(function(){
		 if(fflag){ 
		 $('#pwd1').focus();
		  fflag=false;
		 }
		 
         });
		
	}
 }
 
$(function(){autologin();});
(function(){
	 //验证码 登录手机号
	var phonevalue1 ='';
	var phonevalue2 ='';
    var pwdvalue='';
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
  	 //增加
  	  phonevalue2 ='';
  	 }
 });
 
   // 密码
	 $('#pwd1').blur(function(){
	   var str =$(this).val(); 
	   var sm=/[0-9]+/g;
	   var  st=/[A-z]+/g;
	   if(sm.test(str)&&st.test(str)&&(str.length>5&&str.length<16)){    
		    pwdvalue=str;
            $(this).siblings('h6').html('　');
            $(this).siblings('span').children('img').removeClass('show').addClass('hidden');
	     }else{
        	   $(this).siblings('h6').html('*密码不正确,请重新输入');
        	   $(this).siblings('span').children('img').removeClass('hidden').addClass('show');   	
          pwdvalue ='';
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
 
 $('#checkboxid').prop('checked',true);
  
    //登陆
  $('#loginbtn').click(function(){
	  
	 var checkboxid=$('#checkboxid').prop('checked');
	  
  	 //验证码登陆
  	if(flag){
//	  phonevalue1	
  	}
  	//密码账号等陆
    if(!flag){
    //改
    if(!(phonevalue2&&pwdvalue)){
      alert('密码或账号有误');
     return;     
     }
    var data={username:phonevalue2,password:pwdvalue}
    
    $.post('/xinxiuli/login',
    {rmsg:JSON.stringify(data)},
      function(re){
      if(re.code==1){
    	alert(re.msg); 
         return;
      }	
      
      if(re.code==2){
    	alert(re.msg); 
           return; 
       }	
      if(re.code==0){
    	  
    	if(checkboxid){
    	  setCookie("username",phonevalue2);
    	  setCookie("password",pwdvalue);
    	 
    	}else{
    		delCookie("username");
    		delCookie("password");
    	
    	}  
    	 
    	$('#login').modal('hide');  
    	location.href="/xinxiuli/index.jsp";
    	
      }
      
      })
     }
   });
 })();


