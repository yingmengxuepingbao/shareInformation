var openId = "3";//默认获取到openid
$(function(){ 
	//需要上传的用户参数
	var data = JSON.stringify({"openId":openId});
	$.ajax({
		  type: 'POST',
		  url: "http://localhost:8080/msgPushRewardUser/getRewardByOpenId",
		  data:data,
		  dataType:"json",
		  contentType: "application/json",
		  success:function (data) {
			var jsonObj = JSON.stringify(data);// 转成JSON格式
			var result = $.parseJSON(jsonObj);// 转成JSON对象
			console.log(result);
			if(result.list.length>0){//如果有数据循环
				$("#count").val(result.count);
				for(var i=0;i<result.list.length;i++){
					var str="<tr>"
							+"<td>活动名称</td>"
							+"<td><input type='text' id='activityName' value='"+result.list[i].activityName+"'></td>"
							+"</tr>"
							+"<tr>"
							+"<td>活动举办人：</td>"
							+"<td><input type='text' id='organizer' value='"+result.list[i].organizer+"'></td>"
							+"</tr>"
							+"<tr>"
							+"<td>奖品内容：</td>"
							+"<td><input type='text' id='rewardContent' value='"+result.list[i].rewardContent+"'></td>"
							+"</tr>"
							+"<tr>"
							+"<td>兑奖人：</td>"
							+"<td><input type='text' id='prizeWinner' value='"+result.list[i].prizeWinner+"'></td>"
							+"</tr>"
							+"<tr>"
							+"<td>领奖时间：</td>"
							+"<td><input type='text' id='createTime' value='"+result.list[i].createTime+"'></td>"
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