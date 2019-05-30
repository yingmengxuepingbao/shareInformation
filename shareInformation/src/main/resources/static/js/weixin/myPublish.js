//我的发布 activityInitiateUserId:userId
$(function(){ 
	var linkbt=document.getElementById("linkbt"); 
	var light=document.getElementById('light'); 
	var fade=document.getElementById('fade'); 
	var closebt=document.getElementById("closebt"); 
	closebt.onclick=function(){ 
		light.style.display='none'; 
		fade.style.display='none'; 
		} 
	
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
						+"<input type='checkbox' id='"+result[i].activityId+"' value='"+result[i].activityId+"'/>"
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
						+"<input type='button' id='checkAll' value='全选'  onclick='checkAll()'/>"
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
//全选/取消
function checkAll(){
	if($("#checkAll").val()=="全选"){//按钮：全选
		$('input:checkbox').each(function() { 
		    if (!$(this).prop('checked')) { //状态：未选中
		    	$(this).prop('checked',true);//选中
		    }
		}); 
		$("input:radio").prop('checked',true);//单选按钮选中
		$("#checkAll").val("取消选中");
	}else{//按钮：取消选中
		$('input:checkbox').each(function() { 
		    if ($(this).prop('checked')) { //状态：选中
		    	$(this).prop('checked',false);//取消选中
		    }
		}); 
		$("input:radio").prop('checked',false);//单选按钮选中取消
		$("#checkAll").val("全选");
	}
}
//删除：修改状态
function del(){
	var map=new Array();//创建数组
	//判断选中哪些数据，进行批量删除/批量更改状态
	$('input:checkbox').each(function() { 
	    if ($(this).prop('checked')) { //状态：选中
	    	var v =$(this).val();
	    	map.push(v);//向数组中追加元素[1,2,3]
	    }
	}); 
	console.log(JSON.stringify(map));
	$.ajax({
		  type: 'POST',
		  url: "http://localhost:8080/msgPushActivity/updataIsEnableByID",
		  data:JSON.stringify(map),
		  contentType:'application/json;charset=utf-8',
		  dataType:"json",
		  success:function (data) {
//			  var jsonObj = JSON.stringify(data);// 转成JSON格式
//			  var result = $.parseJSON(jsonObj);// 转成JSON对象
			  if(data.result=="sussess"){//成功后返回信息推送列表
				  alert("删除成功");
				  window.location.href ="http://localhost:8080/view/weixin/myPublish.html";
			  }else{
				  alert("删除失败");
			  }
		  }, 
		  error:function () {
	      	window.alert("删除异常");
		  }
		}); 
	
}


//查看详情 
function particulars(activityId){
	$('#light_tbody').html("");
	//跳转详情页
	var data = JSON.stringify({"activityId":activityId});
	$.ajax({
		  type: 'POST',
		  url: "http://localhost:8080/msgPushActivity/selectActivityByid",
		  data:data,
		  dataType:"json",
		  contentType: "application/json",
		  success:function (data) {
			/*var jsonObj = JSON.stringify(data);// 转成JSON格式
			 var result = $.parseJSON(jsonObj);// 转成JSON对象
		 	 console.log(result);*/	
			  
			 if(data.msgPushActivity!=null){//存在数据时，拼接数据
				 var str =  "<tr>"
						+"<td colspan='5'>"
						+"<p><span>活动名称：</span>"+data.msgPushActivity.activityName+"</p>"
						+"<p><span>活动规则：</span>"+data.msgPushActivity.activityRuleName+"</p>"
						+"<p><span>奖品领取方式：</span>"+data.msgPushActivity.receivingWayName+"</p>"
						+"<p><span>信息发布者：</span>"+data.msgPushActivity.userName+"</p>"
						+"<p><span>活动时间：</span>"+data.msgPushActivity.startTime+"-"+data.msgPushActivity.endTime+"</p>"
						+"<p><span>联系电话：</span>"+data.msgPushActivity.phoneNum+"</p>"
						+"</td>"
						+"</tr>";
		 		$("#light_tbody").after(str);
				 light.style.display='block'; 
				 fade.style.display='block'; 
			 }
		  }, 
		  error:function () {
	      	window.alert("查询失败");
	    }
		});
}
