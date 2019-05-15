package com.zyx.mapper;

import com.zyx.model.MsgPushActivity;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 活动表 Mapper 接口
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Mapper
public interface MsgPushActivityMapper extends BaseMapper<MsgPushActivity> {

	/*
	 * 我的发布：根据用户编号user_id（msg_push_user）即activity_initiate_user_id（msg_push_activity）查询数据
	 */
	public 	List<MsgPushActivity> selectActivityById(String activityInitiateUserId) ;
	
	/*
	 * 信息发布：添加申请
	 */
	public int addActivity(MsgPushActivity msgPushActivity);
}
