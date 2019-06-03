package com.zyx.service;

import com.zyx.model.MsgPushComplaintRecord;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 用户投诉记录表 服务类
 * </p>
 *
 * @author yixin123
 * @since 2019-05-30
 */
public interface MsgPushComplaintRecordService extends IService<MsgPushComplaintRecord> {

	/*
	 * 添加投诉信息
	 */
	public int	addComplaint(MsgPushComplaintRecord msgPushComplaintRecord);

}
