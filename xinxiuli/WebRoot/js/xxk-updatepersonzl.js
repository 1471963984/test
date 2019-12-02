//个人修改
   //
(function(){  
	
    var account = $("div.info_r").attr("datachange");

    //名字
     var nametotal=$("#gainname").val();
   //昵称
     var gainnickname=$("#gainnickname").val(); 
   //手机号
     var gainphone=$("#gainphone").val();
   //邮箱
     var gainemil=$("#gainemil").val();
   //地址
     var gainaddress=$("#gainaddress").val();
     
 $("#gainname").blur(function(){
	 $(this).siblings("span").html(" ");
     var name=$(this).val();     
	if(name==""){
	  nametotal="";  	
	}                
	if(name!=""){
    var testname=/^([\u4e00-\u9fa5]|\w)+$/g; 
    var flag=testname.test(name);
          
    if(flag&&name.length<9){
       nametotal=name;
     }else{
     $(this).siblings("span").html("*用户名不符合"); 
        nametotal="";
     }
	}
 });
   //昵称
   // var gainnickname=""; 
 $("#gainnickname").blur(function(){
	$(this).siblings("span").html(" ");  
    var nickname=$(this).val();
    if(nickname==""){
     gainnickname=""; 	
    } 
    var testnickname=/^([\u4e00-\u9fa5]|\w)+$/g; 
    var flag=testnickname.test(nickname);
    
    if(nickname!=""){
      if(flag&&nickname.length<9){
    	 gainnickname=nickname;
    	 
      }else{
    	$(this).siblings("span").html("*昵称不符合");
    	  gainnickname=""; 
      }    	
    }
  });
   

  //手机号
  //var gainphone="";
  $("#gainphone").blur(function(){
	  $(this).siblings("span").html(" ");
	  var  phone =$(this).val();
     if(phone==""){
       gainphone=phone; 	 
     } 
      var sm =/^1[3456789][0-9]{9}/g;
 	  var strflag=false;
      strflag = phone.length==11?true:false;
     if(phone!=""){
     if(sm.test(phone)&&strflag){
    	 gainphone=phone;   	
    	}else{
     $(this).siblings("span").html("*手机号不正确");  
            gainphone="";
    	} 
     }
  });
  
   //邮箱
   // var gainemil="";
  $("#gainemil").blur(function(){
	$(this).siblings("span").html(" ");
	var emil =$(this).val(); 
    if(emil==""){
       gainemil="";	
    }
     var  testemil=/^\w+@\w+\.(com|cn|com)/g;         
    if(emil!=""){
      if(testemil.test(emil)){
        gainemil=emil;  
       }else{
       $(this).siblings("span").html("*邮箱不正确"); 
        gainemil="";
       }      	
    }
	
  })
      //地址
      // var gainaddress="";
  $("#gainaddress").blur(function(){
	  $(this).siblings("span").html(" ");
	   var address=$(this).val();
	   if(address==""){
		 gainaddress="";   
	   }
	   var testaddress=/^([\u4e00-\u9fa5]|\w|\s)+$/g; 
	   if(address!=""){
		 if(testaddress.test(address)){
			 gainaddress=address;	   
		 }else{
		 $(this).siblings("span").html("*地址不符合");	
		    gainaddress="";
		 }  
	   }
  })
  
  //点击
  $("#savechange").click(function(){
   var dataper={"users_phone":gainphone ,"users_name":nametotal,"users_nickname":gainnickname,"users_addr":gainaddress,"users_email":gainemil};
	//   console.log(dataper);  
   if(confirm("请检查你输入的数据？")){	
	  $.ajax({
		  type:"POST",
		  url:"/xinxiuli/Updatepersonzlservlet",
		  data:{"account":account,"datauser":JSON.stringify(dataper)},
		  success:function(re){
         
            if(0==re.code){
            alert(re.msg);
            //等下 
            location.href="/xinxiuli/loginafter/personzl.jsp"
            }
            if(1==re.code){
             alert(re.msg);	
            }
            
		  }
	 }); 
	  
  } 
});  
 
 
})();