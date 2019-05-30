package com.zyx.mapper;

import com.zyx.model.MsgPushRewardUser;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 用户活动推广奖励记录表 Mapper 接口
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Mapper
public interface MsgPushRewardUserMapper extends BaseMapper<MsgPushRewardUser> {

	/**
	 * 根据用户活动推广奖励记录表的id 查询领奖人
	 */
	public String getPrizeWinnerByid(String id);
	/**
	 * 根据活动表的活动id 查询举办人
	 */
	public String getOrganizerByActivityId(String activityId);
	
	/**
	 * 根据微信openId 查询领奖记录（除兑奖人）
	 */
	public List<MsgPushRewardUser> getRewardByOpenId(String openId);
}
