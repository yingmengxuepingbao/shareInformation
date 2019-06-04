package com.zyx.service.impl;

import java.util.ArrayList;
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
		
		System.out.println("mpcvList = "+msgPushComplaintRecord.getMpcvList());
		//获取投诉凭证相关信息
		List<MsgPushComplaintVoucher> list =msgPushComplaintRecord.getMpcvList();
		int number =0;
		int num = 0;
		if(list.size()>0) {
			//添加投诉信息主表
			number = msgPushComplaintRecordMapper.addComplaint(msgPushComplaintRecord);
			if(number>0) {
				for(int i=0;i<list.size();i++) {//循环获取投诉凭证记录ID
					list.get(i).setComplaintId(UUID);//将用户投诉Id赋值	
					String list_UUID=msgPushComplaintVoucherMapper.getUUID();//获取主键uuid
					list.get(i).setComplaintVoucherId(list_UUID);//id赋值
				}
				num = msgPushComplaintVoucherMapper.addComplaintVoucher(list);
			}
		}
		if(number>0&&num>0) {
			return 1;
		}else {
			return -1;
		}
	}
	/**
	 * 根据微信openid 查询用户id,根据用户id关联查询投诉信息 
	 */
	@Override
	public List<MsgPushComplaintRecord> getComplaintList(String openId) {
		List<MsgPushComplaintRecord> mpcrList =new ArrayList<MsgPushComplaintRecord>();
		//根据用户openId查询用户Id
		MsgPushUserWxRelationship msgPushUserWxRelationship = msgPushUserWxRelationshipMapper.seleUserByOpenId(openId);
		if(msgPushUserWxRelationship!=null) {
			String userId =msgPushUserWxRelationship.getUserId();
			//查询投诉总条数
			int count = msgPushComplaintRecordMapper.selectCountByComplaintUserId(userId);
			if(count>0) {
				//根据用户id查询用户投诉列表
				mpcrList=msgPushComplaintRecordMapper.selectMsgPushComplaintRecord(userId);
				//根据用户id,查询投诉凭证记录列表
				List<MsgPushComplaintVoucher> mpcvList = msgPushComplaintVoucherMapper.selectComplaintVoucherByUserId(userId);
				System.out.println("凭证条数"+mpcvList.size());
				if(mpcrList.size()>0 && mpcvList.size()>0) {
					for (int i = 0; i < mpcrList.size(); i++) {//投诉列表
						List<MsgPushComplaintVoucher> list = new ArrayList<MsgPushComplaintVoucher>();
						for (int j = 0; j < mpcvList.size(); j++) {//投诉凭证列表
							String complaintId = mpcrList.get(i).getComplaintId();//投诉编号
							if(complaintId.equals(mpcvList.get(j).getComplaintId())) {//如果投诉编号相同，将投诉凭证放入投诉列表
								MsgPushComplaintVoucher mpcv = mpcvList.get(i);//获取投诉凭证实体
								list.add(mpcv);
							}
						}
						System.out.println("最终条数"+list.size());
						if(list.size()>0) {
							mpcrList.get(i).setMpcvList(list);
						}
					}
				}
				System.out.println("mpcrList = "+mpcrList);
			}
		}
		return mpcrList;
	}

	
}
