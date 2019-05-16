package com.zyx.service.impl;

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
	public List<MsgPushActivity> selectActivityById(String activityInitiateUserId) {
		System.out.println("活动表 服务实现类");
		return msgPushActivityMapper.selectActivityById(activityInitiateUserId);
	}

	/*
	 * 信息发布：添加申请
	 */
	@Override
	public int addActivity(MsgPushActivity msgPushActivity) {
		System.out.println("ServiceImpl");
		System.out.println("msgPushActivity:"+msgPushActivity);
		System.out.println("MsgPushActivityRule:"+msgPushActivity.getMsgPushActivityRule());
		System.out.println("MsgPushAwardReceivingWay:"+msgPushActivity.getMsgPushAwardReceivingWay());
		int  rule= msgPushActivityRuleMapper.addRule(msgPushActivity.getMsgPushActivityRule());
		int  way= msgPushAwardReceivingWayMapper.addWay(msgPushActivity.getMsgPushAwardReceivingWay());
		int  act =msgPushActivityMapper.addActivity(msgPushActivity);
		if(rule > 0 && way > 0 &&act>0) { //如果添加成功返回act 否则返回0
			return  act;
		}
		return 0;
	}



}
