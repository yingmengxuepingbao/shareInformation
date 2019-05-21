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
	  * 获取活动列表 
	* @param isVerified是否完成审核 0:审核通过，1：审核中，2：审核通过
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
	 * 修改状态并查询列表
	 */
	public List<MsgPushActivity> modifyAndQuery(MsgPushActivity msgPushActivity);
	/*
	 *批量删除：修改  IsEnable 是否禁用 0：禁用，1：启用
	 */
	public void updateIsEnableList(String[] arr);
}
