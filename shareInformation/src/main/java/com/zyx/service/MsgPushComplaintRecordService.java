package com.zyx.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.zyx.model.MsgPushComplaintRecord;

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
	/*
	 *根据微信openid 查询用户id,根据用户id关联查询投诉信息 
	 */
	public List<MsgPushComplaintRecord> getComplaintList(String openId);
}
