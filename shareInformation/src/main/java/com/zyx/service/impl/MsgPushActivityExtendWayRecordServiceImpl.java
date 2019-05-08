package com.zyx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zyx.dao.MsgPushActivityExtendWayMapper;
import com.zyx.dao.MsgPushActivityExtendWayRecordMapper;
import com.zyx.model.MsgPushActivityExtendWay;
import com.zyx.model.MsgPushActivityExtendWayRecord;
import com.zyx.service.MsgPushActivityExtendWayRecordService;

/**
 * <p>
 * 用户活动推广途径历史记录表 服务实现类
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Service
public class MsgPushActivityExtendWayRecordServiceImpl extends ServiceImpl<MsgPushActivityExtendWayRecordMapper, MsgPushActivityExtendWayRecord> implements MsgPushActivityExtendWayRecordService {
	@Resource
    private MsgPushActivityExtendWayMapper msgPushActivityExtendWayMapper;
 
	
	@Override
	public MsgPushActivityExtendWay selectById(String id) {
		return msgPushActivityExtendWayMapper.selectById(id);
	}	 
}
