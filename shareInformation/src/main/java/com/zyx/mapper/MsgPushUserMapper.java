package com.zyx.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zyx.model.MsgPushUser;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Mapper
public interface MsgPushUserMapper extends BaseMapper<MsgPushUser> {
	
	/*
	 * 根据参数Map（用户名，密码，角色）查询用户
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
