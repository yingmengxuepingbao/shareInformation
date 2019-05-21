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
	 * 获取UUID
	 */
	public String getUUID();
	/*
	 * 我的发布：根据用户编号user_id（msg_push_user）即activity_initiate_user_id（msg_push_activity）查询数据
	 */
	public 	List<MsgPushActivity> selActAllById(String activityInitiateUserId) ;
	
	/*
	 * 信息发布：添加申请
	 */
	public int addActivity(MsgPushActivity msgPushActivity);
	
	/*
	  * 获取活动列表 isVerified 是否完成审核 0:审核通过，1：审核中，2：审核通过
	 */
	public List<MsgPushActivity> getActivitList(Integer isVerified);
	/*
	  * 管理员身份，获取待审核活动列表
	 */
	public List<MsgPushActivity> getToauditedActivitList();
	/*
	 * 根据活动id修改状态
	 */
	public int updateIsVerByID(MsgPushActivity msgPushActivity);
	
	/*
	 * 删除活动：修改  IsEnable 是否禁用 0：禁用，1：启用
	 */
	public int updataIsEnableById(String activityId);
}
