package com.zyx.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyx.model.MsgPushUser;
import com.zyx.service.MsgPushUserService;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Controller
@RequestMapping("/msgPushUser")
public class MsgPushUserController {
	@Autowired
	private MsgPushUserService msgPushUserService;
	
	
	@RequestMapping(value = "/selUserById", method = RequestMethod.POST)
	@ResponseBody
	public MsgPushUser selUserById(HttpServletRequest request,HttpServletResponse response) {
		String userId =request.getParameter("activityInitiateUserId");
		//查询用户信息
		MsgPushUser msgPushUser =msgPushUserService.selectById(userId);
		return msgPushUser;
		
	}
	/**
	 * 获取个人信息
	 * @param request
	 * @param response
	 * @return MsgPushUser
	 */
	@RequestMapping(value = "/getPersonalInformation", method = RequestMethod.POST)
	@ResponseBody
	public MsgPushUser getPersonalInformation(HttpServletRequest request,HttpServletResponse response){
		System.out.println("进来了");
		String openId = request.getParameter("openId");
		//关联查询：根据openId 查询个人信息
		MsgPushUser msgPushUser =msgPushUserService.getUserByOpenId(openId);
		System.out.println(msgPushUser);
		return msgPushUser;
	}
}

