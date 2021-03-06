package com.zyx.platLogin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyx.model.MsgPushActivityExtendWay;
import com.zyx.model.MsgPushUser;
import com.zyx.service.MsgPushActivityExtendWayService;
import com.zyx.service.MsgPushUserService;

/**
 * 登录页面入口
 * 
 * @author admin
 *
 */
@Controller
public class ActionController {
	
	@Autowired
	private MsgPushUserService msgPushUserService;
	
	@RequestMapping(value = "/login_commit", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> platLogin(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map =new HashMap<String,Object>();
		Map<String,Object> returnMap =new HashMap<String,Object>();
		System.out.println("登录_提交");
		//获取前台传值
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		String msgPushRoleName = request.getParameter("msgPushRoleName");
		//放入map中
		map.put("userName", userName);
		map.put("userPwd", userPwd);
		map.put("msgPushRoleName", msgPushRoleName);
		System.out.println(userName+"  "+userPwd+" "+msgPushRoleName);
		//查询是否存在
		MsgPushUser msgPushUser = msgPushUserService.queryUserByMap(map);
		if(msgPushUser!=null) {
			System.out.println(msgPushUser.getUserName());
			returnMap.put("result", "sussess");
		}
		return returnMap;
	}
	
	
	 @Autowired
	 private MsgPushActivityExtendWayService msgPushActivityExtendWayService;
	   
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String test() {
		System.out.println("访问到了");
		MsgPushActivityExtendWay msgPushActivityExtendWay =msgPushActivityExtendWayService.selectById("1");
		String activityId = msgPushActivityExtendWay.getActivityId();
		System.out.println("activityId="+activityId);
		return "成功";
	}
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	@ResponseBody
	public String test1() {
		System.out.println("访问到了111");
		MsgPushUser msgPushUser = msgPushUserService.selectById("1");
		String userName = msgPushUser.getUserName();
		System.out.println("userName="+userName);
		return "成功";
	}
	/** 
     * 同时得到两个参数 
     *  
     * @param name 
     *            用户名 
     * @param pwd 
     *            密码 
     * @return 返回结果 
     */  
	
	  @GetMapping(value = "/login/{name}&{pwd}")
	  public String login(@PathVariable String name, @PathVariable String pwd) { 
		if (name.equals("admin") && pwd.equals("admin")) { 
			  return "hello welcome admin"; 
		}else { return
			  "oh sorry user name or password is wrong"; 
		} 
	  }
	 
}
