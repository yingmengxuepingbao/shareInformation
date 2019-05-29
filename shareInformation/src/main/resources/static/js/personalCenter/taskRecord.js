//任务记录
var openId = "3";//默认获取到openid
$(function(){ 
	//需要上传的用户参数
	
	var data = JSON.stringify({"openId":openId});
	$.ajax({
		  type: 'POST',
		  url: "http://localhost:8080/msgPushActivityExtendWayRecord/getRecordList",
		  data:data,
		  dataType:"json",
		  contentType: "application/json",
		  success:function (data) {
			var jsonObj = JSON.stringify(data);// 转成JSON格式
			var result = $.parseJSON(jsonObj);// 转成JSON对象
			console.log(result);
			if(result.list.length>0){//如果有数据循环
				for(var i=0;i<result.list.length;i++){
					var str="<tr>"
							+"<td>活动名称：</td>"
							+"<td><input type='text' id='activityName' value='"+result.list[i].activityName+"'></td>"
							+"</tr>"
							+"<tr>"
							+"<td>奖励内容：</td>"
							+"<td><input type='text' id='activityReward' value='"+result.list[i].activityReward+"'></td>"
							+"</tr>"
							+"<tr>"
							+"<td>举办人：</td>"
							+"<td><input type='text' id='organizer' value='"+result.list[i].organizer+"'></td>"
							+"</tr>"
							+"<tr>"
							+"<td>推广途径</td>"
							+"<td><input type='text' id='extendWayName' value='"+result.list[i].extendWayName+"'></td>"
							+"</tr>"
							+"<tr>"
							+"<td>任务时间</td>"
							+"<td><input type='text' id='createTime' value='"+result.list[i].createTime+"'></td>"
							+"</tr>"
							+"<tr>"
							+"<td  colspan='3'></td>"
							+"</tr>"
							;
					$("#divData").after(str);
				}
			}else{
				 $("#divData").after("暂无数据！");
			}
		  }, 
		  error:function () {
	      	window.alert("查询失败");
	    }
		});
});