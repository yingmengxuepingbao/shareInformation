package com.zyx.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zyx.model.MsgPushComplaintVoucher;

/**
 * <p>
 * 投诉凭证记录表 Mapper 接口
 * </p>
 *
 * @author yixin123
 * @since 2019-05-30
 */
public interface MsgPushComplaintVoucherMapper extends BaseMapper<MsgPushComplaintVoucher> {

	/*
	 * 获取UUID
	 */
	public String getUUID();
	/*
	 * 添加投诉信息
	 * @param list
	 * @return
	 */
	public int addComplaintVoucher(List<MsgPushComplaintVoucher> list);
	/*
	 * 根据投诉用户编号，查询投诉凭证
	 * @param complaintUserId
	 * @return
	 */
	public List<MsgPushComplaintVoucher> selectComplaintVoucherByUserId(String complaintUserId);
}
