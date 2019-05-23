package com.zyx.controller;


import java.util.HashMap;
import java.util.Map;

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
		String openId = request.getParameter("openId");
		//关联查询：根据openId 查询个人信息
		MsgPushUser msgPushUser =msgPushUserService.getUserByOpenId(openId);
		return msgPushUser;
	}
	/**
	 * 更新个人信息
	 * @return
	 */
	@RequestMapping(value = "/updateUserById", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateUserById(HttpServletRequest request,HttpServletResponse response){
		MsgPushUser msgPushUser =new MsgPushUser();
		msgPushUser.setUserId(request.getParameter("userId"));
		msgPushUser.setUserName(request.getParameter("userName"));
		msgPushUser.setPhoneNum(request.getParameter("phoneNum"));
		msgPushUser.setUserSex(request.getParameter("userSex"));
		msgPushUser.setUserEmail(request.getParameter("userEmail"));
		msgPushUser.setUserAddress(request.getParameter("userAddress"));
		int flag = msgPushUserService.updateUserById(msgPushUser);
		Map<String,Object> returnMap =new HashMap<String,Object>();
		if(flag>0) {
			returnMap.put("result", "sussess");
		}
		return returnMap;
	}
}

