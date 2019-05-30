package com.zyx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zyx.mapper.MsgPushRewardUserMapper;
import com.zyx.mapper.MsgPushUserWxRelationshipMapper;
import com.zyx.model.MsgPushRewardUser;
import com.zyx.model.MsgPushUserWxRelationship;
import com.zyx.service.MsgPushRewardUserService;

/**
 * <p>
 * 用户活动推广奖励记录表 服务实现类
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Service
public class MsgPushRewardUserServiceImpl extends ServiceImpl<MsgPushRewardUserMapper, MsgPushRewardUser> implements MsgPushRewardUserService {
	@Autowired
	private MsgPushRewardUserMapper msgPushRewardUserMapper;
	@Autowired
	private MsgPushUserWxRelationshipMapper msgPushUserWxRelationshipMapper;
	
	/**
	 * 根据用户openId查询用户信息
	 * @param openId
	 * @return MsgPushUserWxRelationship
	 */
	public MsgPushUserWxRelationship seleUserByOpenId(String openId) {
		return msgPushUserWxRelationshipMapper.seleUserByOpenId(openId);
		
	}
	/**
	 * 根据用户活动推广奖励记录表的id 查询领奖人
	 */
	public String getPrizeWinnerByid(String id){
		return msgPushRewardUserMapper.getPrizeWinnerByid(id);
	}
	/**
	 * 根据活动表的活动id 查询举办人
	 */
	public String getOrganizerByActivityId(String activityId){
		return msgPushRewardUserMapper.getOrganizerByActivityId(activityId);
	}
	/**
	 * 根据微信openId 查询领奖记录
	 */
	public List<MsgPushRewardUser> getRewardByOpenId(String openId) {
		//根据微信openId 查询领奖记录（除兑奖人）
		List<MsgPushRewardUser> list =msgPushRewardUserMapper.getRewardByOpenId(openId);
		if(list.size()>0) {
			for (MsgPushRewardUser msgPushRewardUser:list) {
				String id = msgPushRewardUser.getId();
				String prizeWinner =getPrizeWinnerByid(id);//根据id查询兑奖人
				msgPushRewardUser.setPrizeWinner(prizeWinner);
			}
		}
		return list;
	}
}
