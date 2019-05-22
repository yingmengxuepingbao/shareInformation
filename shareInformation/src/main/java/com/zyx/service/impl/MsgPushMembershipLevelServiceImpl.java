package com.zyx.service.impl;

import com.zyx.mapper.MsgPushMembershipLevelMapper;
import com.zyx.model.MsgPushMembershipLevel;
import com.zyx.service.MsgPushMembershipLevelService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员等级表 服务实现类
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Service
public class MsgPushMembershipLevelServiceImpl extends ServiceImpl<MsgPushMembershipLevelMapper, MsgPushMembershipLevel> implements MsgPushMembershipLevelService {
	
	@Autowired
	private MsgPushMembershipLevelMapper msgPushMembershipLevelMapper;
	
	/**
	 * 根据用户ID查询会员等级编号
	 * @param userId
	 * @return
	 */
	@Override
	public String getIdByUserId(String userId) {
		return msgPushMembershipLevelMapper.getIdByUserId(userId);
	}
	/**
	 * 根据会员等级编号查询会员信息
	 * @param membershipLevelId
	 * @return
	 */
	@Override
	public MsgPushMembershipLevel selLevelById(String membershipLevelId) {
		return msgPushMembershipLevelMapper.selLevelById(membershipLevelId);
		
	}
	/**
	 * 根据用户ID查询会员信息
	 * @param userId
	 * @return
	 */
	@Override
	public MsgPushMembershipLevel selLevelByUserId(String userId) {
		return msgPushMembershipLevelMapper.selLevelByUserId(userId);
		
	}
}
