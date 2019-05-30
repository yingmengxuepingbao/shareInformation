//活动详情
$(function(){ 
	 var path = '<%=basePath%>';
	 alert(window.location.search);
	 var flag = window.location.search;
	var activityId = ;
	alert(activityId);
	var data = JSON.stringify({"activityId":activityId});
	$.ajax({
		  type: 'POST',
		  url: "http://localhost:8080/msgPushActivity/selActAllById",
		  data:data,
		  dataType:"json",
		  contentType: "application/json",
		  success:function (data) {
			var jsonObj = JSON.stringify(data);// 转成JSON格式
			 var result = $.parseJSON(jsonObj);// 转成JSON对象
			 console.log(result);
			 if(result.length>0){//存在数据时，拼接数据
				
				
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