package com.zyx.service.impl;

import com.zyx.mapper.MsgPushActivityMapper;
import com.zyx.model.MsgPushActivity;
import com.zyx.service.MsgPushActivityService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	/*
	 * 我的发布：根据用户编号user_id（msg_push_user）即activity_initiate_user_id（msg_push_activity）查询数据
	 */
	@Override
	public List<MsgPushActivity> selectActivityById(String activityInitiateUserId) {
		System.out.println("活动表 服务实现类");
		return msgPushActivityMapper.selectActivityById(activityInitiateUserId);
	}

	@Override
	public int addActivity(MsgPushActivity msgPushActivity) {
		// TODO Auto-generated method stub
		return msgPushActivityMapper.addActivity(msgPushActivity);
	}

}
