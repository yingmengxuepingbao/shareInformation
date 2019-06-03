package com.zyx.controller;


import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyx.model.MsgPushComplaintRecord;
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
		System.out.println(msgPushComplaintRecord);
		System.out.println(msgPushComplaintRecord.getMpcvList());
		
		int number = msgPushComplaintRecordService.addComplaint(msgPushComplaintRecord);
		Map<String,Object> returnMap =new HashMap<String,Object>();
		if(number>0) {
			returnMap.put("result", "sussess");
		}
		return returnMap;
	}
}

