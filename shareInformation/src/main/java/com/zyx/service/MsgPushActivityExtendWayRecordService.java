package com.zyx.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.zyx.model.MsgPushActivityExtendWay;
import com.zyx.model.MsgPushActivityExtendWayRecord;

/**
 * <p>
 * 用户活动推广途径历史记录表 服务类
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
public interface MsgPushActivityExtendWayRecordService extends IService<MsgPushActivityExtendWayRecord> {

	MsgPushActivityExtendWay selectById(String id);
	/**
	 * 根据用户openId,用户活动推广途径历史记录，关联查询用户表，活动推广途径关联表（活动表/推广途径字典表）
	 * @param openId 用户openId
	 * @return
	 */
	List<MsgPushActivityExtendWay> getRecordList(String openId);
}
