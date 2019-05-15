//获取开始/结束日期
function getTime(idSign) {
	var currYear = (new Date()).getFullYear(); // 获取年
	var currMonth = (new Date()).getMonth()+1; // 获取月
	var currDay = (new Date()).getDate(); // 获取日
	$('#'+idSign+'').mobiscroll().datetime({
	    theme: "android-ics light", //显示样式
	    lang: 'zh',
	    mode: 'scroller',
	    setText: '确定', //确认按钮名称
	    cancelText: "取消",  
	    display: 'modal', //显示方式  'bottom',
	    preset : 'datetime', //日期:年 月 日 时 分
	    timeFormat: 'HH:ii:ss',
	    dateFormat: 'yyyy-mm-dd',
	    timeOrder: 'HHiiss',
	    timeWheels: 'HHiiss',
	   // startDay: currDay,
	   //startMonth: currMonth, // 开始月份
		startYear: currYear, //开始年份
		endYear: currYear + 10, //结束年份
	  onSelect:function(textval,inset){//点击确定按钮
	        var val = new Date(textval).getTime();//选择的时间
	        if(idSign == "endTime"){//如果是结束时间
        	  if($('#'+idSign+'').val() != ''){//结束时间不为空
 	            var starttime = new Date($("#startTime").val()).getTime();//获取开始时间
 	            if(val < starttime){//如果结束时间小于开始时间
 	                $('#endTime').val('');//结束时间为空
 	                $("#endTimeErro").attr("style", "display: block;");//给出提示
 	                api.toast({
 	                    msg: '结束时间不能早于开始时间',
 	                    duration: 2000,
 	                    location: 'bottom'
 	                });
 	
 	            }else{
 	            	$("#endTimeErro").attr("style", "display: none;");//正确隐藏提示
 	            }
 	         }
	        }
	        if(idSign == "startTime"){//开始时间
	        	 if($('#'+idSign+'').val() != ''){//开始时间不为空
	        		 var nowTime = new Date().getTime();
	        		 if(val > nowTime){//开始时间大于当前时间
	        			var endTime = new Date($("#endTime").val()).getTime();//获取结束时间
	 	  	            if(endTime!=''&&endTime!=null){//结束时间不为空
	 		  	            if(val > endTime){//如果开始时间大于结束时间
	 		  	                $('#startTime').val('');//结束时间为空
	 		  	                $("#startTimeErro").attr("style", "display: block;");//给出提示
	 		  	                api.toast({
	 		  	                    msg: '结束时间不能早于开始时间',
	 		  	                    duration: 2000,
	 		  	                    location: 'bottom'
	 		  	                });
	 		  	
	 		  	            }else{
	 		  	            	$("#startTimeErro").attr("style", "display: none;");//正确隐藏提示
	 		  	            	$("#startTimeDa").attr("style", "display: none;");//正确隐藏提示
	 		  	            }
	 	  	            }
	        		 }else{//开始时间小于现在时间
	        			 $('#startTime').val('');//结束时间为空
		  	             $("#startTimeDa").attr("style", "display: block;");//给出提示
	        		 }
	  	           
	  	         }
	        }
	       
	    }, 
	}); 
}
//根据用户id查询用户信息
function getUserById(activityInitiateUserId){
	  $.ajax({
		  type: 'POST',
		  url: "http://localhost:8080/msgPushUser/selUserById",
		  data:{
			  activityInitiateUserId:activityInitiateUserId
			  },
		  dataType:"json",
		  success:function (data) {
			 var jsonObj = JSON.stringify(data);// 转成JSON格式
			 var result = $.parseJSON(jsonObj);// 转成JSON对象
			 console.log(result);
			 $("#userName").val(result.userName);//显示用户名
			 $("#phoneNum").val(result.phoneNum);//显示电话
		  }, 
		  error:function () {
			  window.alert("查询失败");
		  }
	}); 
}
//提交申请
function sub(){
	var activityInitiateUserId = $("#activityInitiateUserId").val();
	var activityName = $("#activityName").val();
	var activityRuleName  = $("#activityRuleName").val();
	var rewardContent = $("#rewardContent").val();
	var receivingWayName = $("#receivingWayName").val();
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	var userName= $("#userName").val();
	var phoneNum= $("#phoneNum").val();
	//活动名称
	if(activityName ==''||activityName==null||activityName=="undefined"){
		$("#activityNameNull").attr("style", "display: block;");
		return false;
	}else{
		$("#activityNameNull").attr("style", "display: none;");
	}
	//活动规则
	if(activityRuleName ==''||activityRuleName==null||activityRuleName=="undefined"){
		$("#activityRuleNameNull").attr("style", "display: block;");
		return false;
	}else{
		$("#activityRuleNameNull").attr("style", "display: none;");
	}
	//奖励内容
	if(rewardContent ==''||rewardContent==null||rewardContent=="undefined"){
		$("#rewardContentNull").attr("style", "display: block;");
		return false;
	}else{
		$("#rewardContentNull").attr("style", "display: none;");
	}
	//领取方式
	if(receivingWayName ==''||receivingWayName==null||receivingWayName=="undefined"){
		$("#receivingWayNameNull").attr("style", "display: block;");
		return false;
	}else{
		$("#receivingWayNameNull").attr("style", "display: none;");
	}
	//开始时间
	if(startTime ==''||startTime==null||startTime=="undefined"){
		$("#startTimeNull").attr("style", "display: block;");
		return false;
	}else{
		$("#startTimeNull").attr("style", "display: none;");
	}
	//结束时间
	if(endTime ==''||endTime==null||endTime=="undefined"){
		$("#endTimeNull").attr("style", "display: block;");
		return false;
	}else{
		$("#endTimeNull").attr("style", "display: none;");
	}
	//联系电话
	if(phoneNum ==''||phoneNum==null||phoneNum=="undefined"){
		$("#phoneNumNull").attr("style", "display: block;");
		return false;
	}else{//校验手机号码是否正确
		var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
        if (!myreg.test($("#phoneNum").val())) {
        	$("#phoneNumNull").attr("style", "display: block;");
            return false;
        } else {
        	$("#phoneNumNull").attr("style", "display: none;");
            return true;
        }
	}
	 $.ajax({
		  type: 'POST',
		  url: "http://localhost:8080/msgPushActivity/addActivity",
		  data:{
			 activityInitiateUserId :activityInitiateUserId,
			 activityName :activityName, 
			 activityRuleName :activityRuleName,
			 rewardContent :rewardContent,
			 receivingWayName :receivingWayName,
			 startTime :startTime,
			 endTime:endTime,
			 userName:userName,
			 phoneNum:phoneNum
			  },
		  dataType:"json",
		  success:function (data) {
			 /*var jsonObj = JSON.stringify(data);// 转成JSON格式
			 var result = $.parseJSON(jsonObj);// 转成JSON对象
			 console.log(result);*/
			  if(data.result=="success"){
				  window.location.href ="http://localhost:8080/view/weixin/myPublish.html"; 
			  }else{
				  alert("添加失败");
			  }
		  }, 
		  error:function () {
			  window.alert("申请失败");
		  }
	}); 
}