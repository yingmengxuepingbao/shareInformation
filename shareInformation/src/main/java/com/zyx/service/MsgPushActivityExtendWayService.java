package com.zyx.service;

import com.zyx.model.MsgPushActivityExtendWay;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 活动推广途径关联表 服务类
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
public interface MsgPushActivityExtendWayService {

	public MsgPushActivityExtendWay selectById(String id);
}
