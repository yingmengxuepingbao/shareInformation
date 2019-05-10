package com.zyx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyx.dao.MsgPushActivityExtendWayMapper;
import com.zyx.model.MsgPushActivityExtendWay;
import com.zyx.service.MsgPushActivityExtendWayService;

/**
 * <p>
 * 活动推广途径关联表 服务实现类
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Service
public class MsgPushActivityExtendWayServiceImpl implements MsgPushActivityExtendWayService {

	@Autowired
	private MsgPushActivityExtendWayMapper msgPushActivityExtendWayMapper;
	
	@Override
	public MsgPushActivityExtendWay selectById(String id) {
		System.out.println("今天："+id);
		return msgPushActivityExtendWayMapper.selectById(id);
	}

}
