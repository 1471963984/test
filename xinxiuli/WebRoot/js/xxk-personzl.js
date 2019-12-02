//获取个人资料
//obj [过滤前数据]//arr [过滤条件，要求为数组]
function filterObj(obj, arr) {
		if (typeof (obj) !== "object" || !Array.isArray(arr)) {
			throw new Error("参数格式不正确")
		}
		const result = {}
		Object.keys(obj).filter((key) => arr.includes(key)).forEach((key) => {
			result[key] = obj[key]
		})
		return result;
	}


(function(){
   var account=$(".info_r").attr("dataccount"); 

  $.ajax({
	  type:"POST",
	  url:'/xinxiuli/personzl',
	  data:{"personzl":account},
	  success:function(re){
     var oobj =filterObj(re, ["users_name","users_nickname","users_phone","users_email","users_addr"]);
     
    $(".info_r>ul>li>.list-about").each(function(i,obj){
       
        if(0==i){
          for(let j in oobj){
       	     if(j=='users_name'){
       	  
        	    $(obj).html(oobj[j]);  		   
        	    	    }
        	     }	
         } 
        
        if(1==i){
            for(let j in oobj){
         	     if(j=='users_nickname'){
          	    $(obj).html(oobj[j]);  		   
          	    	    }
          	     }	
           } 
         
        if(2==i){
            for(let j in oobj){
         	     if(j=='users_phone'){
          	    $(obj).html(oobj[j]);  		   
          	    	    }
          	     }	
           } 
        
        if(3==i){
            for(let j in oobj){
         	     if(j=='users_email'){
          	    $(obj).html(oobj[j]);  		   
          	    	    }
          	     }	
           } 
        
        if(4==i){
            for(let j in oobj){
         	     if(j=='users_addr'){
          	    $(obj).html(oobj[j]);  		   
          	    	    }
          	     }	
           } 
        
     })      
 }
  }); 		
})()



// $(".info_r>ul>li>.list-about").each()
