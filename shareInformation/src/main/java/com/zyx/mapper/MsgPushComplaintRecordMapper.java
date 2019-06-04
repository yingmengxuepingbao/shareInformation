package com.zyx.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zyx.model.MsgPushComplaintRecord;

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
	 * 获取UUID
	 */
	public String getUUID();
	/*
	 * 添加投诉信息
	 */
	public int	addComplaint(MsgPushComplaintRecord msgPushComplaintRecord);
	/*
	 * 根据投诉用户id查询投诉总条数
	 */
	public int selectCountByComplaintUserId(String complaintUserId);
	/*
	 * 根据用户id查询用户投诉记录
	 */
	public List<MsgPushComplaintRecord> selectMsgPushComplaintRecord(String complaintUserId);
}
