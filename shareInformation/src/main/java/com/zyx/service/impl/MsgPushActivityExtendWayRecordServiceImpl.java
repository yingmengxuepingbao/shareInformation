package com.zyx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zyx.mapper.MsgPushActivityExtendWayMapper;
import com.zyx.mapper.MsgPushActivityExtendWayRecordMapper;
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
	@Resource
	private MsgPushActivityExtendWayRecordMapper msgPushActivityExtendWayRecordMapper;
	
	@Override
	public MsgPushActivityExtendWay selectById(String id) {
		return msgPushActivityExtendWayMapper.selectById(id);
	}


	/**
	 * 根据用户openId,用户活动推广途径历史记录，关联查询用户表，活动推广途径关联表（活动表/推广途径字典表）
	 * @param openId 用户openId
	 * @return
	 */
	@Override
	public List<MsgPushActivityExtendWay> getRecordList(String openId) {
		return msgPushActivityExtendWayRecordMapper.getRecordList(openId);
	}	
	
}
