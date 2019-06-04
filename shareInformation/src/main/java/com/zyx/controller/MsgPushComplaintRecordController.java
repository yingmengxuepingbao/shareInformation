package com.zyx.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyx.model.MsgPushComplaintRecord;
import com.zyx.model.MsgPushComplaintVoucher;
import com.zyx.service.MsgPushComplaintRecordService;

/**
 * <p>
 * 用户投诉记录表 前端控制器
 * </p>
 *
 * @author yixin123
 * @since 2019-05-30
 */
@Controller
@RequestMapping("/msgPushComplaintRecord")
public class MsgPushComplaintRecordController {
	@Autowired
	private MsgPushComplaintRecordService msgPushComplaintRecordService;
	
	/**
	 * 添加投诉记录
	 * @param msgPushComplaintRecord
	 * @return
	 */
	@RequestMapping(value = "/addComplaint", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addComplaint(@Valid @RequestBody MsgPushComplaintRecord msgPushComplaintRecord){
		//将前台的数据转换成list
		String [] arr = msgPushComplaintRecord.getMpcvArr();
		List<MsgPushComplaintVoucher> mpcvList =new ArrayList<MsgPushComplaintVoucher>();
		int number =0;
		if(msgPushComplaintRecord.getMpcvArr().length>0) {
			for(int i=0;i<arr.length;i++) {
				MsgPushComplaintVoucher mpcv = new MsgPushComplaintVoucher();
				mpcv.setComplaintVoucherPicture(arr[i]);
				mpcvList.add(mpcv);
			}
			msgPushComplaintRecord.setMpcvList(mpcvList);
			number = msgPushComplaintRecordService.addComplaint(msgPushComplaintRecord);
		}
		Map<String,Object> returnMap =new HashMap<String,Object>();
		if(number>0) {
			returnMap.put("result", "sussess");
		}
		return returnMap;
	}
	
	/**
	 * 添加投诉记录
	 * @param msgPushComplaintRecord
	 * @return
	 */
	@RequestMapping(value = "/selectComplaint", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> selectComplaint(HttpServletRequest request){
		String openId = request.getParameter("openId");
		List<MsgPushComplaintRecord> list = msgPushComplaintRecordService.getComplaintList(openId);
		Map<String,Object> returnMap =new HashMap<String,Object>();
		 returnMap.put("list", list);
		 returnMap.put("count", list.size());
		return returnMap;
	}	

}

