package com.zyx.service;

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
}
