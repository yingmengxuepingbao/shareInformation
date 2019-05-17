/*
 * 根据openid获取微信信息，根据个人信息查询权限表；如果是管理员，查询待审批数据；若普通会员，无权限审批。
 */
$(function(){ 
	var openid = "1";
	$.ajax({
		  type: 'POST',
		  url: "http://localhost:8080/msgPushActivity/getActAuditList",
		  data:{
			  openid:openid
			  },
		  dataType:"json",
		  success:function (data) {
			  alert("进来了");
			var jsonObj = JSON.stringify(data);// 转成JSON格式
			 var result = $.parseJSON(jsonObj);// 转成JSON对象
			 console.log(result);
			 if(result.length>0){//存在数据时，拼接数据
				for(var i=0;i<result.length;i++){
					var str =  "<tr>"
						+"<td colspan='5'>"
						+"<p><span>申请时间：</span>"+result[i].createTime+"</p>"
						+"<p><span>活动名称：</span>"+result[i].activityName+"</p>"
						+"<p><span>活动规则：</span>"+result[i].activityRuleName+"</p>"
						+"<p><span>奖品领取方式：</span>"+result[i].receivingWayName+"</p>"
						+"<p><span>信息发布者：</span>"+result[i].userName+"</p>"
						+"<p><span>活动时间：</span>"+result[i].startTime+"-"+result[i].endTime+"</p>"
						+"<p><span>联系电话：</span>"+result[i].phoneNum+"</p>"
						+"</td>"
						+"<td><input type='button' value='审核通过' ><br>"
						+"<input type='button' value='审核不通过'></td>"
						+"</tr>";
		 		$("#tbody").after(str);
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