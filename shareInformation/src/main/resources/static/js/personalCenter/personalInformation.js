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
			 $("#userName").val(result.userName);
			 $("#phoneNum").val(result.phoneNum);
			 $("input[name=userSex][value=男]").attr("checked",result.userSex=="男"? true : false);
			 $("input[name=userSex][value=女]").attr("checked",result.userSex=="女"? true : false);	
			 $("#userEmail").val(result.userEmail);
			 $("#userAddress").val(result.userAddress);
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
		 $("#membershipLevelName").val();
		 $("#userName").val();
		 $("#phoneNum").val();
		 $("input[name=userSex][value=男]").attr("checked",result.userSex=="男"? true : false);
		 $("input[name=userSex][value=女]").attr("checked",result.userSex=="女"? true : false);	
		 $("#userEmail").val();
		 $("#userAddress").val();
	});
});
