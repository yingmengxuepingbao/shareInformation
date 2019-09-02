var openId = 1;
$(function(){ 
$.ajax({
	  type: 'POST',
	  url: "http://localhost:8080/msgPushActivity/getActivitList",
	  data:{openId:openId},
	  dataType:"json",
	  success:function (data) {
		var jsonObj = JSON.stringify(data);// 转成JSON格式
		 var result = $.parseJSON(jsonObj);// 转成JSON对象
		 console.log(result.msgPushUser);
		 console.log(result.list);
		 $("#userName").val(result.msgPushUser.userName);
		 $("#activityInitiateUserId").val(result.msgPushUser.userId);
		 $("#membershipLevelName").val(result.msgPushUser.membershipLevelName);
		 if(result.list.length>0){//存在数据时，拼接数据
			for(var i=0;i<result.list.length;i++){
				var str = "<tr>"
				+"<td colspan='5'>"
				+"<input type='hidden' id='activityId' value='"+result.list[i].activityId+"'>"
				+"<p><span>活动名称： </span>"+result.list[i].activityName+"</p>"
				+"<p><span>活动规则： </span>"+result.list[i].activityRuleName+"</p>"
				+"<p><span>奖励内容： </span>"+result.list[i].rewardContent+"</p>"
				+"<p><span>奖品领取方式： </span>"+result.list[i].receivingWayName+"</p>"
				+"<p><span>信息发布者： </span>"+result.list[i].userName+"</p>"
				+"<p><span>活动时间： </span>"+result.list[i].startTime+"-"+result.list[i].endTime+"</p>"
				+"</td>"
				+"<td colspan='2'>"
				+"<input type='button' value='转发' onclick='forward(\""+result.list[i].activityId+"\")'>" 
				+"<input type='button' value='投诉' onclick='complaint(\""+result.list[i].activityId+"\",\""+result.list[i].activityName+"\")'>" 
				+"</td>"
				+"</tr>";
	 		$("#tbody").after(str);
	 		$("#activityId").val(result.list[i].activityId);//将活动id拼接上，用于转发
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
//投诉
function complaint(activityId,activityName){
	window.location.href = "../personalCenter/complaint.html?activityId="+activityId+"&activityName="+activityName+"&openId="+openId;
}

//转发
function forward(activityId){
	alert("活动id="+activityId);
	 //通过ajax，在页面加载的时候获取微信分享接口signature，nonceStr，timestamp 和appId
	  $.ajax({
	    type: 'POST',
	    url: "http://localhost:8080/msgPushActivity/share",
	    dataType: "json",
	    data:"url="+window.location.href,
	    success: function (data) {
	      wx.config({
	        debug: false,
	        appId: data.appId,
	        timestamp: data.timestamp,
	        nonceStr: data.nonceStr,
	        signature: data.signature,
	        jsApiList: ['onMenuShareAppMessage', 'onMenuShareTimeline', 'hideAllNonBaseMenuItem', 'showMenuItems']
	        // 功能列表，我们要使用JS-SDK的什么功能
	      });
	      wx.ready(function () {
	        // 获取“分享给朋友”按钮点击状态及自定义分享内容接口
	        wx.onMenuShareAppMessage({
	          title: "分享自定义标题", // 分享标题
	          desc: "分享自定义描述", // 分享描述
	          link: "http://localhost/weixin/share?openId=1",//分享点击之后的链接
	          imgUrl:'/images/photo/1.jpg', // 分享图标
	          type: 'link', // 分享类型,music、video或link，不填默认为link
	          success: function () {
	            //成功之后的回调
	          }
	        });
	        wx.hideAllNonBaseMenuItem();
	        wx.showMenuItems({
	          menuList: ['menuItem:share:appMessage', 'menuItem:share:timeline'] // 要隐藏的菜单项，只能隐藏“传播类”和“保护类”按钮，所有menu项见附录3
	        });
	        wx.onMenuShareTimeline({
	          title: "分享自定义标题", // 分享标题
	          desc: "分享自定义描述", // 分享描述
	          link: "http://localhost/weixin/share?openId=1",//分享点击之后的链接
	          imgUrl:'/images/photo/1.jpg', // 分享图标
	          type: 'link', // 分享类型,music、video或link，不填默认为link
	          success: function () {
	            //成功之后的回调
	          },
	          cancel: function () {
	            // 用户取消分享后执行的回调函数
	          }
	        });
	      });
	      wx.error(function (res) {
	        //打印错误消息。及把 debug:false,设置为debug:ture就可以直接在网页上看到弹出的错误提示
	      });
	    }
	  })
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*//分享核心js代码
	  //获取随机串
	  var createNonceStr = function() {
	     return Math.random().toString(36).substr(2, 15);
	  };
	     
	  // timestamp
	  var createTimeStamp = function () {
	    return parseInt(new Date().getTime() / 1000) + '';
	  }; 
	 
	  $.ajax({
	        url :'http://localhost:8080/msgPushActivity/getSignature',
	        type: 'post', //HTTP请求类型
	        data: {
	            url:location.href.split('#')[0], //url 如果写的是固定的值的话，分享之后在分享会报错
	            timestamp: createTimeStamp,
	            nonce_str: createNonceStr
	        },
	        timeout: 10000, //超时时间设置为10秒；
	        success: function(data) {
	         
	            //微信初始化
	            wx.config({
	                debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
	                appId: "", // 必填，公众号的唯一标识
	                timestamp: data.timestamp , // 必填，生成签名的时间戳
	                nonceStr: data.nonceStr, // 必填，生成签名的随机串
	                signature: data.signature,// 必填，签名，见附录1
	                jsApiList: ["onMenuShareTimeline","onMenuShareAppMessage","onMenuShareQQ"] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
	            });
	            var openid=$("#openid").html();
	             
	            wx.ready(function(){
	                var sdata = {
	                    imgUrl: "http://jsaxwv.natappfree.cc/share/img/blog/logo.png", // 分享图标
	                    link: "http://yst3qg.natappfree.cc/bootdo/wx/weixinAutoLogin?userId="+openid, 
	                    title: "燕子约一周年庆典", // 分享标题
	                    desc: "分享描述", // 分享描述
	                    success: function () {
	                        alert("分享成功");
	                    },
	                    cancel: function () {
	                        alert("分享失败");
	                    }
	                };
	                wx.onMenuShareAppMessage(sdata);// 发送给朋友
	                //wx.onMenuShareTimeline(sdata);//分享到朋友圈
	            });
	            wx.error(function(res){
	                // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
	                //alert("抱歉，服务器初始化错误。");
	            });
	        },
	        error: function(xhr, type, errorThrown) {
	            //异常处理；
	            console.log(xhr);
	            console.log(type);
	            console.log(errorThrown);
	        }
	    });*/
	
	
}
