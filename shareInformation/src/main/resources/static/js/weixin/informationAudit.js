/*
 * 根据openid获取微信信息，根据个人信息查询权限表；如果是管理员，查询待审批数据；若普通会员，无权限审批。
 */
var openid = "1";//默认获取到openid
$(function(){ 
	$.ajax({
		  type: 'POST',
		  url: "http://localhost:8080/msgPushActivity/getActAuditList",
		  data:{
			  openid:openid
			  },
		  dataType:"json",
		  success:function (data) {
			var jsonObj = JSON.stringify(data);// 转成JSON格式
			 var result = $.parseJSON(jsonObj);// 转成JSON对象
			 console.log(result);
			 if(result.length>0){//存在数据时，拼接数据
				for(var i=0;i<result.length;i++){
					var str =  "<tr>"
						+"<td colspan='5'>"
						+"<input type='hidden' value='"+result[i].activityId+"'>"
						+"<p><span>申请时间：</span>"+result[i].createTime+"</p>"
						+"<p><span>活动名称：</span>"+result[i].activityName+"</p>"
						+"<p><span>活动规则：</span>"+result[i].activityRuleName+"</p>"
						+"<p><span>奖品领取方式：</span>"+result[i].receivingWayName+"</p>"
						+"<p><span>信息发布者：</span>"+result[i].userName+"</p>"
						+"<p><span>活动时间：</span>"+result[i].startTime+"-"+result[i].endTime+"</p>"
						+"<p><span>联系电话：</span>"+result[i].phoneNum+"</p>"
						+"</td>"
						+"<td><input type='button' name='name' value='审核通过'  onclick='auditPass(\""+result[i].activityId+"\",0)'><br>"
						+"<input type='button' name='name' value='审核不通过'  onclick='auditPass(\""+result[i].activityId+"\",2)'></td>"
						+"</tr>";
		 		$("#tbody").after(str);
				}
			 }else{//不存在数据
				 $("#divData").after("暂无数据！");
				/* var str= "<tr align='center'>"
						+"<td colspan='6' >"
						+"<p><span>暂无数据！</span></p>"
						+"</td>"
						+"</tr>";
				 $("#tbody").after(str);*/
			 }
		  }, 
		  error:function () {
	      	window.alert("查询失败");
	    }
		});
});
//审核通过：0/审核不通过：2  activityId 活动编号 
function auditPass(activityId,isVerified){
	var userId="1";//默认获取到userId
	
	$("#sign").val(isVerified);
	$.ajax({
		  type: 'POST',
		  url: "http://localhost:8080/msgPushActivity/updataIsVerByID",
		  data:{
			  activityId:activityId,
			  isVerified:isVerified,
			  updateUserId:userId
			  },
		  dataType:"json",
		  success:function (data) {
			  $('#tbody').html("");
			  $("#divData").html("");
			var jsonObj = JSON.stringify(data);// 转成JSON格式
			 var result = $.parseJSON(jsonObj);// 转成JSON对象
			 console.log(result);
			 alert("操作成功");
			 
			 if(result.length>0){//存在数据时，拼接数据
				 var str =  "<tr>"
						+"<td colspan='5'>"
						+"<input type='hidden' value='"+result[i].activityId+"'>"
						+"<p><span>申请时间：</span>"+result[i].createTime+"</p>"
						+"<p><span>活动名称：</span>"+result[i].activityName+"</p>"
						+"<p><span>活动规则：</span>"+result[i].activityRuleName+"</p>"
						+"<p><span>奖品领取方式：</span>"+result[i].receivingWayName+"</p>"
						+"<p><span>信息发布者：</span>"+result[i].userName+"</p>"
						+"<p><span>活动时间：</span>"+result[i].startTime+"-"+result[i].endTime+"</p>"
						+"<p><span>联系电话：</span>"+result[i].phoneNum+"</p>"
						+"</td>"
						+"<td><input type='button' value='审核通过'  onclick='auditPass(\""+result[i].activityId+"\",0)'><br>"
						+"<input type='button' value='审核不通过'  onclick='auditPass(\""+result[i].activityId+"\",2)'></td>"
						+"</tr>";
		 		$("#tbody").after(str);
			 }else{//不存在数据
				 $("#divData").after("暂无数据！");
					/* var str= "<tr align='center'>"
							+"<td colspan='6' >"
							+"<p><span>暂无数据！</span></p>"
							+"</td>"
							+"</tr>";
					 $("#tbody").after(str);*/
			 }
		  }, 
		  error:function () {
	      	window.alert("查询失败");
	    }
		});
}

