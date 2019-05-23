package com.zyx.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.zyx.model.MsgPushUser;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
public interface MsgPushUserService extends IService<MsgPushUser> {
	
	/*
	 * 根据参数Map查询用户
	 */
	public MsgPushUser queryUserByMap(Map<String,Object> map);
	
	/*
	 * 根据用户名查询用户
	 */
	public MsgPushUser queryUserByName(String userName);
	
	/*
	 * 根据用户ID查询用户
	 */
	public MsgPushUser selectById(String userId);
	
	/**
	 * 关联查询：根据openId 查询个人信息
	 * @param openId 微信openId
	 * @return MsgPushUser
	 */
	public MsgPushUser getUserByOpenId(String openId);
	
	/**
	 * 更新个人信息
	 * @return
	 */
	public int updateUserById(MsgPushUser msgPushUser);

}
