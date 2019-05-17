package com.zyx.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyx.model.MsgPushActivity;
import com.zyx.model.MsgPushActivityRule;
import com.zyx.model.MsgPushAwardReceivingWay;
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
	 * 消息推送列表
	 */
	@RequestMapping(value = "/getActivitList", method = RequestMethod.POST)
	@ResponseBody
	public List<MsgPushActivity> getActivitList(){
		List<MsgPushActivity> list =msgPushActivityService.getActivitList(0);//isVerified是否完成审核 0:审核通过，1：审核中，2：审核通过
		return list;
	}

	/*
	 * 我的发布：根据用户编号user_id（msg_push_user）即activity_initiate_user_id（msg_push_activity）查询数据
	 */
	@RequestMapping(value = "/selActivityByUserId", method = RequestMethod.POST)
	@ResponseBody
	public List<MsgPushActivity> selActivityByUserId(HttpServletRequest request,HttpServletResponse response){
		String activityInitiateUserId =request.getParameter("activityInitiateUserId");
		List<MsgPushActivity> list = msgPushActivityService.selectActivityById(activityInitiateUserId);
		return list;
	}
	/*
	 * 信息发布：添加申请
	 */
	@RequestMapping(value = "/addActivity", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addActivity(HttpServletRequest request,HttpServletResponse response){
		String UUID = msgPushActivityService.getUUID() ;
		System.out.println(UUID);
		MsgPushActivity msgPushActivity = new MsgPushActivity();//活动表
		MsgPushActivityRule msgPushActivityRule =new MsgPushActivityRule(); //活动规则表
		MsgPushAwardReceivingWay msgPushAwardReceivingWay = new MsgPushAwardReceivingWay();//奖励领取方式表
		
		//活动规则表的相关信息
		msgPushActivityRule.setActivityRuleId(UUID);//活动规则编号
		msgPushActivityRule.setActivityRuleName(request.getParameter("activityRuleName"));//活动规则名称
		msgPushActivityRule.setCreateUserId(request.getParameter("activityInitiateUserId"));//创建人ID
		msgPushActivityRule.setIsEnable(1);//是否禁用,0：禁用 1：启用
		//奖励领取方式表
		msgPushAwardReceivingWay.setReceivingWayId(UUID);//奖励领取方式编号
		msgPushAwardReceivingWay.setReceivingWayName(request.getParameter("receivingWayName"));//奖励发放方式
		msgPushAwardReceivingWay.setCreateUserId(request.getParameter("activityInitiateUserId"));//创建人ID
		msgPushAwardReceivingWay.setStartTime(request.getParameter("startTime"));//有效起始时间
		msgPushAwardReceivingWay.setEndTime(request.getParameter("endTime"));//有效截止时间
		//活动表的相关信息
		msgPushActivity.setActivityId(UUID);//活动编号
		msgPushActivity.setActivityName(request.getParameter("activityName"));//活动名称
		msgPushActivity.setActivityInitiateUserId(request.getParameter("activityInitiateUserId"));//活动发起人ID
		msgPushActivity.setActivityRuleId(UUID);// 活动规则编号
		msgPushActivity.setRewardContent(request.getParameter("rewardContent")); //奖励内容
		msgPushActivity.setRewardReceiveMethodId(UUID);//奖励领取方式编号
		msgPushActivity.setStartTime(request.getParameter("startTime")); //活动起始时间
		msgPushActivity.setEndTime(request.getParameter("endTime"));//活动截止时间
		msgPushActivity.setMsgPushActivityRule(msgPushActivityRule);//活动规则表的相关信息
		msgPushActivity.setMsgPushAwardReceivingWay(msgPushAwardReceivingWay);//奖励领取方式表
		
		System.out.println("msgPushActivity = "+msgPushActivity);
		System.out.println("msgPushActivityRule = "+msgPushActivityRule);
		//添加信息
		int flag = msgPushActivityService.addActivity(msgPushActivity);
		System.out.println("flag = "+flag);
		
		Map<String,Object> returnMap =new HashMap<String,Object>();
		if(flag>0) {
			returnMap.put("result", "sussess");
		}
		return returnMap;
	}
	/*
	 * 获取待审核信息列表
	 *  根据openid获取微信信息，根据个人信息查询权限表；
	 *  如果是管理员，查询待审批数据；若普通会员，无权限审批。
	 */
	@RequestMapping(value = "/getActAuditList", method = RequestMethod.POST)
	@ResponseBody
	public List<MsgPushActivity> getActAuditList(HttpServletRequest request,HttpServletResponse response){
		//如果不是管理员，查询自己的待审核列表
		//如果是管理员身份，查询待审核列表
		List<MsgPushActivity> list = msgPushActivityService.getToauditedActivitList();
		return list;
	}
}

