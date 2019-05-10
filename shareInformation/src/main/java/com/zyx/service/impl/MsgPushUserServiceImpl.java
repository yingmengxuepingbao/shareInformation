package com.zyx.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zyx.dao.MsgPushUserMapper;
import com.zyx.model.MsgPushUser;
import com.zyx.service.MsgPushUserService;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Service
public class MsgPushUserServiceImpl extends ServiceImpl<MsgPushUserMapper, MsgPushUser> implements MsgPushUserService {

	@Autowired
	private MsgPushUserMapper msgPushUserMapper;
	
	/*repository
	 * 根据参数Map查询用户
	 */
	@Override
	public MsgPushUser queryUserByMap(Map<String,Object> map) {
		System.out.println("进service了");
		return msgPushUserMapper.queryUserByMap(map);
	}

	/*
	 * 根据用户名查询用户
	 */
	@Override
	public MsgPushUser queryUserByName(String userName) {
		// TODO Auto-generated method stub
		return msgPushUserMapper.queryUserByName(userName);
	}

	@Override
	public MsgPushUser selectById(String userId) {
		System.out.println("进service了，userId= "+userId);
		return msgPushUserMapper.selectById(userId);
	}

}
