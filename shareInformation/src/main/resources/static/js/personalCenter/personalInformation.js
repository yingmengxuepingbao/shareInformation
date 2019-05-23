//个人中心
var openId = "1";//默认获取到openid
$(function(){ 
	$.ajax({
		  type: 'POST',
		  url: "http://localhost:8080/msgPushUser/getPersonalInformation",
		  data:{
			  openId:openId
			  },
		  dataType:"json",
		  success:function (data) {
			var jsonObj = JSON.stringify(data);// 转成JSON格式
			 var result = $.parseJSON(jsonObj);// 转成JSON对象
			 console.log(result);
			 $('input').prop("readonly",true);
			 $("#membershipLevelName").val(result.membershipLevelName);
			 $("#userId").val(result.userId);
			 $("#userName").val(result.userName);
			 $("#phoneNum").val(result.phoneNum);
			 $("input[name=userSex][value=男]").attr("checked",result.userSex=="男"? true : false);
			 $("input[name=userSex][value=女]").attr("checked",result.userSex=="女"? true : false);	
			 $("#userEmail").val(result.userEmail);
			 $("#userAddress").val(result.userAddress);
			 var addressLength = result.userAddress.length;
			 $("#userAddress").css('width', addressLength*15 + 'px');//将地址长度自适应
			 $("#edit").show();
			 $("#preserve").hide();
		  }, 
		  error:function () {
	      	window.alert("查询失败");
	    }
		});
});
$(document).ready(function(){
	//编辑按钮
	$("#edit").on('click',function(){
		 $("input:not(#membershipLevelName)").prop("readonly",false);//除等级名称外，去除input元素的readonly属性
		 $("input:not(#membershipLevelName)").css("border-width","1");
		 $("input:radio").removeAttr("disabled");
		 $("#preserve").show();
		 $("#edit").hide();
	});
	//保存按钮
	$("#preserve").on('click',function(){
		var membershipLevelName = $("#membershipLevelName").val();
		var userId= $("#userId").val();
		var userName= $("#userName").val();
		var phoneNum= $("#phoneNum").val();
		var userSex = $("input[name=userSex]:checked").val();
		var userEmail= $("#userEmail").val();
		var userAddress= $("#userAddress").val();
		$.ajax({
			  type: 'POST',
			  url: "http://localhost:8080/msgPushUser/updateUserById",
			  data:{
				  membershipLevelName:membershipLevelName,
				  userId:userId,
				  userName:userName,
				  phoneNum:phoneNum,
				  userSex:userSex,
				  userEmail:userEmail,
				  userAddress:userAddress
				  },
			  dataType:"json",
			  success:function (data) {
				/*var jsonObj = JSON.stringify(data);// 转成JSON格式
				 var result = $.parseJSON(jsonObj);// 转成JSON对象
				 console.log(result);*/
				  if(data.result=="sussess"){//成功后返回信息推送列表
					  window.location.href ="http://localhost:8080/view/personalCenter/personalInformation.html"; 
				  }else{
					  alert("添加失败");
				  }
			  }, 
			  error:function () {
		      	window.alert("保存失败");
		    }
			});
	});
});
