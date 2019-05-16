package com.zyx.mapper;

import com.zyx.model.MsgPushAwardReceivingWay;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 奖励领取方式表 Mapper 接口
 * </p>
 *
 * @author yixin123
 * @since 2019-05-16
 */
public interface MsgPushAwardReceivingWayMapper extends BaseMapper<MsgPushAwardReceivingWay> {

	/*
	 * 添加 奖励领取方式
	 */
	public int addWay(MsgPushAwardReceivingWay msgPushAwardReceivingWay);
}
