package com.zyx.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.zyx.model.MsgPushActivity;

/**
 * <p>
 * 活动表 服务类
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
public interface MsgPushActivityService extends IService<MsgPushActivity> {

	/*
	 * 我的发布：根据用户编号user_id（msg_push_user）即activity_initiate_user_id（msg_push_activity）查询数据
	 */
	public 	List<MsgPushActivity> selectActivityById(String activityInitiateUserId) ;
}
