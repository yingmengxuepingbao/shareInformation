package com.zyx.service;

import com.zyx.model.MsgPushRewardUser;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 用户活动推广奖励记录表 服务类
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
public interface MsgPushRewardUserService extends IService<MsgPushRewardUser> {

	/**
	 * 根据微信openId 查询领奖记录
	 */
	public List<MsgPushRewardUser> getRewardByOpenId(String openId);
}
