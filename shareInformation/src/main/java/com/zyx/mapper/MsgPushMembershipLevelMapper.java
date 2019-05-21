package com.zyx.mapper;

import com.zyx.model.MsgPushMembershipLevel;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 会员等级表 Mapper 接口
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Mapper
public interface MsgPushMembershipLevelMapper extends BaseMapper<MsgPushMembershipLevel> {
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
