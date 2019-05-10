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
	 * 根据参数Map查询用户
	 */
	public MsgPushUser queryUserByMap(Map<String,Object> map);
	
	/*
	 * 根据用户名查询用户
	 */
	public MsgPushUser queryUserByName(String userName);
	
	/*
	 * 根据用户名查询用户
	 */
	public MsgPushUser selectById(String userId);

}
