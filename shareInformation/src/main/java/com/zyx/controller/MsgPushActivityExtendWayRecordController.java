package com.zyx.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyx.model.MsgPushActivityExtendWay;
import com.zyx.model.MsgPushActivityExtendWayRecord;
import com.zyx.service.MsgPushActivityExtendWayRecordService;

/**
 * <p>
 * 用户活动推广途径历史记录表 前端控制器
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Controller
@RequestMapping("/msgPushActivityExtendWayRecord")
public class MsgPushActivityExtendWayRecordController {
	
	  @Autowired 
	  private MsgPushActivityExtendWayRecordService  msgPushActivityExtendWayRecordService;
	 
	/*
	 * 推广信息列表-主页：查询所有活动信息
	 */
	@RequestMapping(value = "/getRecordList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getRecordList(@Valid @RequestBody MsgPushActivityExtendWayRecord msgPushActivityExtendWayRecord){
	 System.out.println("进来了");
	  String openId =msgPushActivityExtendWayRecord.getOpenId(); 
	  //根据用户openId,用户活动推广途径历史记录，关联查询用户表，活动推广途径关联表（活动表/推广途径字典表）
	  List<MsgPushActivityExtendWay> list =msgPushActivityExtendWayRecordService.getRecordList(openId);
	  Map<String,Object> returnMap =new HashMap<String,Object>(); 
	  returnMap.put("list", list);
	  return returnMap;
	}
}

