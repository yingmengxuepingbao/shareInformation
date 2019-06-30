package com.zyx.controller;


import javax.xml.transform.Result;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyx.util.WeChatUtil;

/**
 * <p>
 * 用户账号微信关联表 前端控制器
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Controller
@RequestMapping("/msgPushUserWxRelationship")
public class MsgPushUserWxRelationshipController {

	private static final long serialVersionUID = 1L;
   // private static Logger logger = LoggerFactory.getLogger(MainController.class);

    /**
     * 登录
     * @param
     */
    @ResponseBody
    @GetMapping(value="/login")
    public Result login(String code) {
        
        // 微信小程序ID
        String appid = "wxabd856ad2fb9b20d";
        // 微信小程序秘钥
        String secret = "987a71db7b51f05fe743558a7b7e84c6";
        
        // 根据小程序传过来的code想这个url发送请求
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
        // 发送请求，返回Json字符串
        String str = WeChatUtil.httpRequest(url, "GET", null);
        System.out.println("Json字符串："+str);
        // 转成Json对象 获取openid
       // JSONObject jsonObject = JSONObject.parseObject(str);
		
        
        // 我们需要的openid，在一个小程序中，openid是唯一的
        //String openid = jsonObject.get("openid").toString();
        
        
        // 然后书写自己的处理逻辑即可
        return null;
    }
	
	/**
	 * 获取openid
	 */
	public String getOpenId() {
		
		return null;
		
	}
}

