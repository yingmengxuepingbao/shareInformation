//我的发布 activityInitiateUserId:userId
$(function(){ 
	var userId = 1;
	$.ajax({
		  type: 'POST',
		  url: "http://localhost:8080/msgPushActivity/selActAllById",
		  data:{
			  activityInitiateUserId:userId
			  },
		  dataType:"json",
		  success:function (data) {
			var jsonObj = JSON.stringify(data);// 转成JSON格式
			 var result = $.parseJSON(jsonObj);// 转成JSON对象
			 console.log(result);
			 if(result.length>0){//存在数据时，拼接数据
				 var state ="";
				for(var i=0;i<result.length;i++){
					if(result[i].endTime<new Date()){//如果结束时间小于当前时间，状态已过期
						state ="已过期";
					}else{//未过期状态分为：审核通过：0，审核不通过：2，审核中：1
						if(result[i].isVerified==0){
							state ="审核通过";
						}else if(result[i].isVerified==1){
							state ="审核中";
						}else{
							state ="审核不通过";
						}
					}
					var str =  "<tr>"
						+"<td>"
						+"<input type='checkbox' name='ck' id='"+result[i].activityId+"'/>"
						+"</td>"
						+"<td colspan='5'>"
						+"<input type='hidden' value='"+result[i].activityId+"'>"
						+"<p><span>发布时间：</span>"+result[i].createTime+"</p>"
						+"<p><span>活动名称：</span>"+result[i].activityName+"</p>"
						+"<p><span>活动时间：</span>"+result[i].startTime+"-"+result[i].endTime+"</p>"
						+"<p><span>状态：</span>"+state+"</p>"
						+"</td>"
						+"<td><input type='button' name='name' value='查看详情'  onclick='particulars(\""+result[i].activityId+"\")'><br>"
						+"</tr>";
		 		$("#tbody").after(str);
				}
					var v = "<tr>"
						+"<td colspan='7'>"
						+"<input type='radio' id='quanxuan_sign' />" 
						+"<input type='button' id='checkAll' value='全选' onclick='checkAll()'/>"
						+"<input type='button' value='删除'   onclick='del()' />" 
						+"</td>"
						+"</tr>";
				$("#tbody").after(v);
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
//全选
//$("#checkAll").bind("click", function () {
function checkAll(){
    if($(this).attr("checked") == 'checked'){
        $("[name = 'ck']:checkbox").attr("checked", true);
    } else {
        $("[name = 'ck']:checkbox").attr("checked", false);
    }
}
//});
//删除：修改状态
function del(){
	//判断选中哪些数据，进行批量删除/批量更改状态
	
}
//查看详情 
function particulars(activityId){
	//跳转详情页
	
	/*$.ajax({
		  type: 'POST',
		  url: "http://localhost:8080/msgPushActivity/getActById",
		  data:{
			  activityId:activityId
			  },
		  dataType:"json",
		  success:function (data) {
			var jsonObj = JSON.stringify(data);// 转成JSON格式
			 var result = $.parseJSON(jsonObj);// 转成JSON对象
			 console.log(result);
		  }, 
		  error:function () {
	      	window.alert("查询失败");
	    }
		});*/
}
