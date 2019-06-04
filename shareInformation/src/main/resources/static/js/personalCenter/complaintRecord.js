//投诉记录
var openId = 1;
$(function(){ 
	$.ajax({
		  type: 'POST',
		  url: "http://localhost:8080/msgPushComplaintRecord/selectComplaint",
		  data:{
			  "openId":openId
		  },
		  dataType:"json",
		  success:function (data) {
			var jsonObj = JSON.stringify(data);// 转成JSON格式
			var result = $.parseJSON(jsonObj);// 转成JSON对象
			 console.log(result);
			 if(result.list.length>0){
				 $("#count").val(result.count);
				 for (var i = 0; i < result.list.length; i++) {
				 var str="<tr>"
						+"<td>活动名称：</td>"
						+"<td><input type='text' id='activityName' value='"+result.list[i].activityName+"' readonly /></td>"
						+"</tr>"
						+"<tr>"
						+"<td>活动编号：</td>"
						+"<td><input type='text' id='activityId' value='"+result.list[i].activityId+"' readonly /></td>"
						+"</tr>"
						+"<tr>"
						+"<td>投诉时间：</td>"
						+"<td><input type='text' id='createTime' value='"+result.list[i].createTime+"' readonly /></td>"
						+"</tr>"
						+"<tr>"
						+"<td>投诉理由：</td>"
						+"<td><input type='text' id='complaintReason'  value='"+result.list[i].complaintReason+"'readonly /></td>"
						+"</tr>"
						+"<tr>"
						+"<td>投诉凭证：</td>"
						+"<td><div id='imgCount'> </div></td>"
						+"</tr>";
				 $("#divData").after(str);
					 alert(result.list[i].mpcvList.length);
					 for (var j = 0; j < result.list[i].mpcvList.length; j++) {
						//获取图片路径
						 var str ="<div class='del_div' id='del"+j+"' style='display:inline-block;margin-left:10px;'>" 
							+"<img id='img"+j+"'  src='"+result.list[i].mpcvList[j].complaintVoucherPicture+"'  class='myImg'>"
							+"</div>";
						$("#imgCount").append(str);
					}
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