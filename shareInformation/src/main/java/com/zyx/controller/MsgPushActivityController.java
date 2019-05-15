package com.zyx.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyx.model.MsgPushActivity;
import com.zyx.service.MsgPushActivityService;

/**
 * <p>
 * 活动表 前端控制器
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Controller
@RequestMapping("/msgPushActivity")
public class MsgPushActivityController {
	
	@Autowired
	private MsgPushActivityService msgPushActivityService;

	/*
	 * 我的发布：根据用户编号user_id（msg_push_user）即activity_initiate_user_id（msg_push_activity）查询数据
	 */
	@RequestMapping(value = "/selActivityByUserId", method = RequestMethod.POST)
	@ResponseBody
	public List<MsgPushActivity> selActivityByUserId(HttpServletRequest request,HttpServletResponse response){
		System.out.println("Controller");
		String activityInitiateUserId =request.getParameter("activityInitiateUserId");
		System.out.println("activityInitiateUserId="+activityInitiateUserId);
		List<MsgPushActivity> list = msgPushActivityService.selectActivityById(activityInitiateUserId);
		return list;
	}
	/*
	 * 信息发布：添加申请
	 */
	@RequestMapping(value = "/addActivity", method = RequestMethod.POST)
	@ResponseBody
	public String addActivity(HttpServletRequest request,HttpServletResponse response){
		MsgPushActivity msgPushActivity = new MsgPushActivity();
		msgPushActivity.setActivityName(request.getParameter("activityName"));
		msgPushActivity.setActivityInitiateUserId(request.getParameter("activityInitiateUserId"));
		msgPushActivity.setActivityRuleName(request.getParameter("activityRuleName")); 
		msgPushActivity.setRewardContent(request.getParameter("rewardContent")); 
		msgPushActivity.setReceivingWayName(request.getParameter("receivingWayName")); 
		msgPushActivity.setStartTime(request.getParameter("startTime")); 
		msgPushActivity.setEndTime(request.getParameter("endTime"));
		//String userName =request.getParameter("userName");
		//String phoneNum =request.getParameter("phoneNum");
		
		System.out.println("msgPushActivity = "+msgPushActivity);
		int flag = msgPushActivityService.addActivity(msgPushActivity);
		if(flag>0) {
			return "success";
		}else {
			return "fail";
		}
		
	}
}

