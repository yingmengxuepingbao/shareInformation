package com.zyx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zyx.mapper.MsgPushActivityMapper;
import com.zyx.mapper.MsgPushActivityRuleMapper;
import com.zyx.mapper.MsgPushAwardReceivingWayMapper;
import com.zyx.model.MsgPushActivity;
import com.zyx.service.MsgPushActivityService;

/**
 * <p>
 * 活动表 服务实现类
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Service
public class MsgPushActivityServiceImpl extends ServiceImpl<MsgPushActivityMapper, MsgPushActivity> implements MsgPushActivityService {

	@Autowired
	private MsgPushActivityMapper msgPushActivityMapper;
	@Autowired
	private MsgPushActivityRuleMapper msgPushActivityRuleMapper;
	@Autowired
	private MsgPushAwardReceivingWayMapper msgPushAwardReceivingWayMapper;
	
	/*
	 * 获取UUID
	 */
	@Override
	public String getUUID() {
		return msgPushActivityMapper.getUUID();
	}
	
	/*
	 * 我的发布：根据用户编号user_id（msg_push_user）即activity_initiate_user_id（msg_push_activity）查询数据
	 */
	@Override
	public List<MsgPushActivity> selActAllById(String activityInitiateUserId) {
		return msgPushActivityMapper.selActAllById(activityInitiateUserId);
	}

	/*
	 * 信息发布：添加申请
	 */
	@Override
	public int addActivity(MsgPushActivity msgPushActivity) {
		int  rule= msgPushActivityRuleMapper.addRule(msgPushActivity.getMsgPushActivityRule());
		int  way= msgPushAwardReceivingWayMapper.addWay(msgPushActivity.getMsgPushAwardReceivingWay());
		int  act =msgPushActivityMapper.addActivity(msgPushActivity);
		if(rule > 0 && way > 0 &&act>0) { //如果添加成功返回act 否则返回0
			return  act;
		}
		return 0;
	}
	/*
	  * 获取活动列表 isVerified 是否完成审核 0:审核通过，1：审核中，2：审核通过
	 */
	@Override
	public List<MsgPushActivity> getActivitList(Integer isVerified) {
		return msgPushActivityMapper.getActivitList(isVerified);
	}

	/*
	  * 管理员身份，获取待审核活动列表
	 */
	@Override
	public List<MsgPushActivity> getToauditedActivitList() {
		return msgPushActivityMapper.getToauditedActivitList();
	}

	/*
	 * 根据活动id修改状态
	 */
	@Override
	public int updateIsVerByID(MsgPushActivity msgPushActivity) {
		return msgPushActivityMapper.updateIsVerByID(msgPushActivity);
	}
	/*
	 * 修改状态并查询列表
	 */
	@Override
	public List<MsgPushActivity> modifyAndQuery(MsgPushActivity msgPushActivity) {
		List<MsgPushActivity> list = new ArrayList<MsgPushActivity>();
		int flage =  updateIsVerByID(msgPushActivity);
		System.out.println("flage = "+flage);
		//如果修改成功 查询待审批列表
		if(flage>0) {
			list= getToauditedActivitList();
			System.out.println("修改成功 查询待审批列表 ="+list.size());
		}
		return list;
	}
	/*
	 *批量删除：修改  IsEnable 是否禁用 0：禁用，1：启用
	 */
	@Override
	public void updateIsEnableList(String[] arr) {
		for(int i=0;i<arr.length;i++) {
			updataIsEnableById(arr[i]);//循环修改
		}
	}
	/*
	 * 删除活动：修改  IsEnable 是否禁用 0：禁用，1：启用
	 */
	public int updataIsEnableById(String activityId) {
		return msgPushActivityMapper.updataIsEnableById(activityId);
	}
	/*
	 * 查看详情：根据活动id(activityId)查询信息
	 */
	public MsgPushActivity selectActivityByid(String activityId) {
		return msgPushActivityMapper.selectActivityByid(activityId);
	}
	

}
