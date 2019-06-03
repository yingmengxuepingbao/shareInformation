package com.zyx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zyx.mapper.MsgPushComplaintRecordMapper;
import com.zyx.mapper.MsgPushComplaintVoucherMapper;
import com.zyx.mapper.MsgPushUserWxRelationshipMapper;
import com.zyx.model.MsgPushComplaintRecord;
import com.zyx.model.MsgPushComplaintVoucher;
import com.zyx.model.MsgPushUserWxRelationship;
import com.zyx.service.MsgPushComplaintRecordService;

/**
 * <p>
 * 用户投诉记录表 服务实现类
 * </p>
 *
 * @author yixin123
 * @since 2019-05-30
 */
@Service
public class MsgPushComplaintRecordServiceImpl extends ServiceImpl<MsgPushComplaintRecordMapper, MsgPushComplaintRecord> implements MsgPushComplaintRecordService {

	@Autowired
	private MsgPushComplaintRecordMapper msgPushComplaintRecordMapper;//用户投诉记录表
	@Autowired
	private MsgPushComplaintVoucherMapper msgPushComplaintVoucherMapper;//投诉凭证记录表
	@Autowired
	private MsgPushUserWxRelationshipMapper msgPushUserWxRelationshipMapper;//
	/*
	 * 添加投诉信息
	 */
	@Override
	public int addComplaint(MsgPushComplaintRecord msgPushComplaintRecord) {
		//根据用户openId查询用户Id
		MsgPushUserWxRelationship msgPushUserWxRelationship = msgPushUserWxRelationshipMapper.seleUserByOpenId(msgPushComplaintRecord.getOpenId());
		String userId =msgPushUserWxRelationship.getUserId();
		//获取uudi 主键
		String UUID = msgPushComplaintRecordMapper.getUUID();
		msgPushComplaintRecord.setComplaintId(UUID);
		msgPushComplaintRecord.setComplaintUserId(userId);
		//获取投诉凭证相关信息
		List<MsgPushComplaintVoucher> list =msgPushComplaintRecord.getMpcvList();
		int number =0;
		int num = 0;
		if(list.size()>0) {
			//添加投诉信息主表
			number = msgPushComplaintRecordMapper.addComplaint(msgPushComplaintRecord);
			for(int i=0;i<list.size();i++) {//循环获取投诉凭证记录ID
				String list_UUID=msgPushComplaintVoucherMapper.getUUID();//获取主键uuid
				list.get(i).setComplaintVoucherId(list_UUID);//id赋值
				list.get(i).setComplaintId(UUID);//将用户投诉Id赋值	
			}
			num = msgPushComplaintVoucherMapper.addComplaintVoucher(list);
		}
		if(number>0&&num>0) {
			return 1;
		}else {
			return -1;
		}
	}

	
}
