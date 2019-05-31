package com.zyx.mapper;

import com.zyx.model.MsgPushComplaintRecord;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 用户投诉记录表 Mapper 接口
 * </p>
 *
 * @author yixin123
 * @since 2019-05-30
 */
public interface MsgPushComplaintRecordMapper extends BaseMapper<MsgPushComplaintRecord> {

	/*
	 * 添加投诉信息
	 */
	public int	addComplaint();
}
