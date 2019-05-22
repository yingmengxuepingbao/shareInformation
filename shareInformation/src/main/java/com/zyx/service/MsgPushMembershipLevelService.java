package com.zyx.service;

import com.zyx.model.MsgPushMembershipLevel;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 会员等级表 服务类
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
public interface MsgPushMembershipLevelService extends IService<MsgPushMembershipLevel> {
	
	/**
	 * 根据用户ID查询会员等级编号
	 * @param userId
	 * @return
	 */
	public String getIdByUserId(String userId);
	/**
	 * 根据会员等级编号查询会员信息
	 * @param membershipLevelId
	 * @return
	 */
	public MsgPushMembershipLevel selLevelById(String membershipLevelId);
	/**
	 * 根据用户ID查询会员信息
	 * @param userId
	 * @return
	 */
	public MsgPushMembershipLevel selLevelByUserId(String userId);

}
