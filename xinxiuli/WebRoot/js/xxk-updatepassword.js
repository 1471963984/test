//更新密码
(function(){
   var account =$(".info_r").attr("pwdaccount");
   console.log(account);
   var  flag=false;
   var  flagnewpass=false;
   var  newpassword="";
   var  newpasswordsecond="";
   
    $("#oldpassword").blur(function(){
    	 var str=$(this).val(); 
    	 var sm=/[0-9]+/g;
    	 var st=/[a-zA-Z]+/g;
    	 if((st.test(str))&&(sm.test(str))&&(str.length>5&&str.length<16)){
    		 $(this).siblings("span").html("　");
    		var data={"account":account,"password":str};
    	   　
    		$.ajax({
    	    type:"POST",
    	    url:"/xinxiuli/Updatepasswordcheck",
    	    data:{"databean":JSON.stringify(data)},
    	    success:function(re){
    	     
    	      if(0==re.code){
    	     $("#oldpassword").siblings("span").html(re.msg);  
    	         flag=true; 
    	      }
    	      
    	      if(1==re.code){
    	     $("#oldpassword").siblings("span").html(re.msg);   
    	      }
    	      
    	    }
    	  }); 
    	 }else{ //  siblings
    	  $(this).siblings("span").html("*密码格式错误");    
    	 }
    });  
    
    //新密码
    $("#newpassword").blur(function(){
     var str=$(this).val(); 
   	 var sm=/[0-9]+/g;
   	 var st=/[a-zA-Z]+/g;
   	if((st.test(str))&&(sm.test(str))&&(str.length>5&&str.length<16)){
   	  $("#newpassword").siblings("span").html("　"); 
      $("#newpassword").siblings("span").html("*密码符合条件"); 
      newpassword=str;
   	 }else{
   	   $("#newpassword").siblings("span").html("*密码格式错误");      	  
   	 } 
    });
    
    //确认密码
    $("#newpasswordsecond").blur(function(){
      var  str=$(this).val(); 
      if(str==newpassword&&str!=""){
     $("#newpasswordsecond").siblings("span").html("*密码确认正确*"); 
        flagnewpass=true; 
        newpasswordsecond=str;   
      }else{
     $("#newpasswordsecond").siblings("span").html("*密码确认错误");  
      }
    });
   //确认
  $("#confirm").click(function(){
	if(!flag){
    alert("旧密码密码错误");
    return;
	}
   if(!flagnewpass){
	  alert("密码确认错误");
	  return;
   } 
    var dataconfirm={"account":account,"newpassword":newpasswordsecond};
    console.log(dataconfirm);
   $.ajax({
	 type:"POST",
	 url:"/xinxiuli/Updatepasswordconfirm",
	 data:{"confirmmsg":JSON.stringify(dataconfirm)},
	 success:function(re){
	   if(0==re.code){
	   alert(re.msg);
	   location.reload();
	   } 
	   
	   if(1==re.code){
		alert(re.msg);
	   } 
	 }
    });
  }); 
  
})()