//投诉
$(function(){ 
	var url=location.href; //取得整个地址栏
	var res = parseURL(url);//获取参数值
	$("#activityId").val(res.activityId);
	$("#activityName").val(res.activityName);
	$("#openId").val(res.openId);
	
});
//解析URL
function parseURL(url){
    var url = url.split("?")[1];
    var para = url.split("&");
    var len = para.length;
    var res = {};
    var arr = [];
    for(var i=0;i<len;i++){
        arr = para[i].split("=");
        res[arr[0]] = decodeURI(arr[1]);
    }
    return res;
}
//对图片进行压缩
var number= 0; //用于标识图片
var arrayObj = new Array();　//创建一个数组 	用于存储图片src
var arrayNumber = new Array();　//创建一个数组 存放删除的图片标识
var newArrayObj = new Array();
function compress() { 
	//将提示隐藏
	$("#complaintReasonNameNull").attr("style", "display: none;");
	
	let fileObj = document.getElementById("file").files[0]; //上传文件的对象
	alert("fileObj="+fileObj);
	var dataURL=  window.URL.createObjectURL(fileObj);
	console.log("dataURL = "+dataURL);
	alert("dataURL = "+dataURL);
	arrayObj.push(dataURL);//将图片路径放入数组
	alert(arrayObj);
    if(fileObj !=undefined){//点击确定走/取消退出
		//最多上传五张图片
		var count = $("#count").val();
		if(count<5){
			$("#count").val(Number(count)+Number(1));
			var str ="<div class='del_div' id='del"+number+"' style='display:inline-block;margin-left:10px;'>" 
				+"<img class='chahao' id='chahao"+number+"' src='../../img/personalCenter/chahao.png' onclick='delImg(del"+number+","+number+")'>" 
				+"<img id='img"+number+"'  src=''  class='myImg' name='complaintVoucherPicture'>"
				+"</div>";
			$("#imgCount").append(str);
		}else{
			return;
		}
		//图片缩图
		let reader = new FileReader();
	    reader.readAsDataURL(fileObj);
	    reader.onload = function(e) {
	        let image = new Image(); //新建一个img标签（还没嵌入DOM节点)
	        image.src = e.target.result;
	        image.onload = function() {
	            let canvas = document.createElement('canvas'), 
	            context = canvas.getContext('2d'),
	            imageWidth = image.width / 2,    //压缩后图片的大小
	            imageHeight = image.height / 2,
	            data = '';

	            canvas.width = imageWidth;
	            canvas.height = imageHeight;

	            context.drawImage(image, 0, 0, imageWidth, imageHeight);
	            data = canvas.toDataURL('image/jpeg');
	            //压缩完成 
	            document.getElementById('img'+number).src = data;
	            //arrayObj.push(data);//将图片放入数组
	            number++;
	        }
   
        }
    }
}
//删除凭证图片
function delImg(divNumber,number){
    imgCount.removeChild(divNumber);
    $("#count").val(Number($("#count").val())-Number(1));
    arrayNumber.push(number);//将删除的标识放入数组
}
function sub(){
	var activityId = $("#activityId").val();
	var activityName = $("#activityName").val();
	var complaintReason = $("#complaintReason").val();
	if(complaintReason==null||complaintReason==""||complaintReason==undefined){
		$("#complaintReasonNameNull").attr("style", "display: block;");
		return false;
	}else{
		$("#complaintReasonNameNull").attr("style", "display: none;");
	}
	//循环数组
	var arrvalue;//用于存放取出的数组的值
	for(var i=0;i<arrayNumber.length;i++){
		arrvalue=arrayNumber[i];//数组的索引是从0开始的
		delete arrayObj[arrvalue];
	}
	console.log("arrayObj="+arrayObj);
	for(var i=0;i<arrayObj.length;i++){//循环数组，移除为空的元素
		if(arrayObj[i]!=undefined && arrayObj[i]!="" && arrayObj[i]!=null){
			newArrayObj.push(arrayObj[i]);
		}
	}
	console.log("newArrayObj = "+newArrayObj);
	var openId = $("#openId").val();
	var mpcvArr=newArrayObj;
	alert(newArrayObj);
	if(newArrayObj=="" ||newArrayObj==null|| newArrayObj==undefined){
		$("#complaintVoucherPictureNull").attr("style", "display: block;");
		return false;
	}else{
		$("#complaintVoucherPictureNull").attr("style", "display: none;");
	}
	var data = JSON.stringify({"openId":openId,"activityId":activityId,"activityName":activityName,"complaintReason":complaintReason,"mpcvArr":mpcvArr});
	$.ajax({
	  type: 'POST',
	  url: "http://localhost:8080/msgPushComplaintRecord/addComplaint",
	  data:data,
	  dataType:"json",
	  contentType: "application/json",
	  success:function (data) {
		/*var jsonObj = JSON.stringify(data);// 转成JSON格式
		 var result = $.parseJSON(jsonObj);// 转成JSON对象
		 console.log(result);*/
		 if(data.result=="sussess"){//存在数据时，拼接数据
			 window.alert("添加成功");
		 }else{
			 window.alert("添加失败");
		 }
	  }, 
	  error:function () {
		  window.alert("查询失败");
	  }
	});
} 
