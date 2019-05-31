//投诉
$(function(){ 
	var url=location.href; //取得整个地址栏
	var res = parseURL(url);//获取参数值
	$("#activityId").val(res.activityId);
	$("#activityName").val(res.activityName);
	
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
var number= 0;
function compress() { 
	//最多上传五张图片
	var count = $("#count").val();
	if(count<5){
		$("#count").val(Number(count)+Number(1));
		
		var str ="<div class='del_div' id='del"+number+"' style='display:inline-block;margin-left:10px;'>" 
			+"<img class='chahao' id='chahao"+number+"' src='../../img/personalCenter/chahao.png' onclick='delImg(del"+number+")'>" 
			+"<img id='img"+number+"'  src=''  class='myImg' name='complaintVoucherPicture'>"
			+"</div>";
		$("#imgCount").append(str);
	}else{
		return;
	}
    let fileObj = document.getElementById('file').files[0]; //上传文件的对象
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
            number++;
        }
    }
}
//删除凭证图片
function delImg(divNmuber){
    imgCount.removeChild(divNmuber);
    $("#count").val(Number($("#count").val())-Number(1));
    $(".del_div").find(".myImg").prop("src");
    console.log($(".del_div").find(".myImg").prop("src"));
}
/*$.ajax({
	  type: 'POST',
	  url: "http://localhost:8080/msgPushActivityExtendWayRecord/getRecordList",
	  data:data,
	  dataType:"json",
	  contentType: "application/json",
	  success:function (data) {
		var jsonObj = JSON.stringify(data);// 转成JSON格式
		 var result = $.parseJSON(jsonObj);// 转成JSON对象
		 console.log(result);
		 if(result.length>0){//存在数据时，拼接数据
		 }
	  }, 
	  error:function () {
    	window.alert("查询失败");
  }
	});*/