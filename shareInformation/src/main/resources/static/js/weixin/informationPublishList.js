var openId = 1;
$(function(){ 
$.ajax({
	  type: 'POST',
	  url: "http://localhost:8080/msgPushActivity/getActivitList",
	  data:{openId:openId},
	  dataType:"json",
	  success:function (data) {
		var jsonObj = JSON.stringify(data);// 转成JSON格式
		 var result = $.parseJSON(jsonObj);// 转成JSON对象
		 console.log(result.msgPushUser);
		 console.log(result.list);
		 if(result.list.length>0){//存在数据时，拼接数据
			 $("#userName").val(result.msgPushUser.userName);
			 $("#activityInitiateUserId").val(result.msgPushUser.userId);
			 $("#membershipLevelName").val(result.msgPushUser.membershipLevelName);
			for(var i=0;i<result.list.length;i++){
				var str = "<tr>"
				+"<td colspan='5'>"
				+"<input type='hidden' id='activityId'>"
				+"<p><span>活动名称： </span>"+result.list[i].activityName+"</p>"
				+"<p><span>活动规则： </span>"+result.list[i].activityRuleName+"</p>"
				+"<p><span>奖励内容： </span>"+result.list[i].rewardContent+"</p>"
				+"<p><span>奖品领取方式： </span>"+result.list[i].receivingWayName+"</p>"
				+"<p><span>信息发布者： </span>"+result.list[i].userName+"</p>"
				+"<p><span>活动时间： </span>"+result.list[i].startTime+"-"+result.list[i].endTime+"</p>"
				+"</td>"
				+"<td colspan='2'><input type='button' id='zhuanfa"+i+"' value='转发'></td>"
				+"</tr>";
	 		$("#tbody").after(str);
	 		$("#activityId").val(result.list[i].activityId);//将活动id拼接上，用于转发
			}
		 }else{//不存在数据
			 $("#divData").after("暂无数据！");
		 }
	  }, 
	  error:function () {
      	window.alert("查询失败");
    }
	});
});