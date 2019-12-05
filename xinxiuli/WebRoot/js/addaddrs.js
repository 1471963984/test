//添加地址
   var panduanlist = new Array(5);
(function(){
	var panduan = "";
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
     var testname=/^([\u4e00-\u9fa5]|\w)+$/g; 
     var flag=testname.test(name);  
     
     if(flag&&name.length<9&&name!=null){
    	 nametotal=name;
    	 panduanlist[0]=1;
     }else{
    	 $(this).siblings("span").html("*用户名不符合"); 
    	 //nametotal="";
    	 panduanlist[0] = 2;
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
    	 panduanlist[1]=1;
      }else{
    	$(this).siblings("span").html("*昵称不符合");
    	  //gainnickname=""; 
    		panduanlist[1]=2;
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
    	 panduanlist[2]=1;
    	}else{
     $(this).siblings("span").html("*手机号不正确");  
            //gainphone="";
     		panduanlist[2]=2;
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
        panduanlist[3]=1;
       }else{
    	   $(this).siblings("span").html("*邮箱不正确"); 
    	   //gainemil="";
    	   panduanlist[3] = 2;
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
			 panduanlist[4] = 1;
		 }else{
		 $(this).siblings("span").html("*地址不符合");	
		    //gainaddress="";
		 	panduanlist[4] = 2;
		 }
	   }
  })
    
})();

//点击按钮提交
$("#submitbut").click(function(){
	var u = new Object();
	u.users_name = $('.name').val();
	alert($('.name').val());
	u.users_nickname = $('.sex').val();
	if($('.dist').val()==null){
		var a="";
	}else{
		var a = $('.dist').val();
	}
	u.users_addr = $('.prov').val()+"-"+$('.city').val()+"-"+a+"  "+$('.xiangxiaddrs').val();
	u.users_phone = $('.phone').val();
	u.users_email = $('.e-mail').val();
	var json = JSON.stringify(u);
	var panduan = false;
	for (var i = 0; i < panduanlist.length; i++) {
		if(panduanlist[i]!=2){
			panduan=true;
		}
	}
	if(panduan==true){
	    $.ajax({
			type:"post",
			url:"/xinxiuli/jiaaddrs",
			data:"user="+json,
			success:function(result){
				if(result=="true"){
					alert("添加地址成功");
					location.href="/xinxiuli/loginafter/myaddrs.jsp";
				}	
			}
		});
	}else{
		alert('请检查您填写的信息');
	}
});