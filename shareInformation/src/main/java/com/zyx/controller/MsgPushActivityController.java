package com.zyx.controller;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zyx.model.MsgPushActivity;
import com.zyx.model.MsgPushActivityRule;
import com.zyx.model.MsgPushAwardReceivingWay;
import com.zyx.model.MsgPushUser;
import com.zyx.service.MsgPushActivityService;
import com.zyx.service.MsgPushUserService;

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
	@Autowired
	private MsgPushUserService msgPushUserService;
	
	/*
	 * 推广信息列表-主页：查询所有活动信息
	 */
	@RequestMapping(value = "/getActivitList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getActivitList(HttpServletRequest request,HttpServletResponse response){
		String openId = request.getParameter("openId");
		//关联查询：根据openId 查询个人信息
		MsgPushUser msgPushUser =msgPushUserService.getUserByOpenId(openId);
		//查询所有审核通过及状态正常的活动信息
		List<MsgPushActivity> list =msgPushActivityService.getActivitList(0);//isVerified是否完成审核 0:审核通过，1：审核中，2：审核通过
		Map<String,Object> returnMap =new HashMap<String,Object>();
		returnMap.put("list", list);
		returnMap.put("msgPushUser", msgPushUser);
		return returnMap;
	}

	/*
	 * 我的发布：根据用户编号user_id（msg_push_user）即activity_initiate_user_id（msg_push_activity）查询数据
	 */
	@RequestMapping(value = "/selActAllById", method = RequestMethod.POST)
	@ResponseBody
	public List<MsgPushActivity> selActivityByUserId(HttpServletRequest request,HttpServletResponse response){
		String activityInitiateUserId =request.getParameter("activityInitiateUserId");
		List<MsgPushActivity> list = msgPushActivityService.selActAllById(activityInitiateUserId);
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
		//添加信息
		int flag = msgPushActivityService.addActivity(msgPushActivity);
		
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
	
	/*
	 *根据活动id修改活动状态 
	 */
	@RequestMapping(value = "/updataIsVerByID", method = RequestMethod.POST)
	@ResponseBody
	public List<MsgPushActivity> updataIsVerByID(HttpServletRequest request,HttpServletResponse response){
		MsgPushActivity msgPushActivity =new MsgPushActivity();
		msgPushActivity.setActivityId(request.getParameter("activityId"));
		msgPushActivity.setIsVerified(Integer.valueOf(request.getParameter("isVerified")));
		msgPushActivity.setUpdateUserId(request.getParameter("updateUserId"));
		//根据id修改MsgPushActivity活动表，并查询待审批列表
		List<MsgPushActivity> list = msgPushActivityService.modifyAndQuery(msgPushActivity);
		return list;
	}
	/*
	 * 删除活动：根据id更改 isEnable 是否禁用 0：禁用，1：启用
	 */
	@RequestMapping(value = "/updataIsEnableByID", method = RequestMethod.POST)//,produces="application/json;charset=utf-8;"
	@ResponseBody
	public Map<String,Object> updataIsEnableByID(@RequestBody String params){//["3","2","1"]
		String str = params.substring(2, params.length()-2);//3","2","1
		String[] arr = str.split("\",\""); // 用","分割
		System.out.println(Arrays.toString(arr));
		try {
			msgPushActivityService.updateIsEnableList(arr);//批量删除
		} catch (Exception e) {
			System.out.println("异常");
		}
		Map<String,Object> returnMap =new HashMap<String,Object>();
		returnMap.put("result", "sussess");
		return returnMap;
	}
	/**
	 * 根据活动id 查询信息发布详情
	 * @param msgPushActivity 活动实体类
	 * @return 返回详情页 viewDetails -msgPushActivity
	 */
	@RequestMapping(value = "/selectActivityByid", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> selectActivityByid(@Valid @RequestBody MsgPushActivity msgPushActivity){
		System.out.println("进来了 "+msgPushActivity.getActivityId());
		//根据活动表id，查询详情
		String activityId =msgPushActivity.getActivityId();
		MsgPushActivity activity = msgPushActivityService.selectActivityByid(activityId);
		
		Map<String,Object> returnMap =new HashMap<String,Object>();
		if(returnMap!=null) {
			returnMap.put("msgPushActivity", activity);
		}
		return returnMap;
	}
}

