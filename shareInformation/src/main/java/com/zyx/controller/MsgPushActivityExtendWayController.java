package com.zyx.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zyx.model.MsgPushActivityExtendWay;
import com.zyx.service.MsgPushActivityExtendWayService;

/**
 * <p>
 * 活动推广途径关联表 前端控制器
 * </p>
 *
 * @author yixin
 * @since 2019-05-05
 */
@RestController
@RequestMapping("/msgPushActivityExtendWay")
public class MsgPushActivityExtendWayController {
	 //@Resource
	 @Autowired
	 private MsgPushActivityExtendWayService msgPushActivityExtendWayService;
	   
	 @RequestMapping(value = "/selectById")
	 @ResponseBody
	 public MsgPushActivityExtendWay selectById(String id){		 
		 return msgPushActivityExtendWayService.selectById("1");
	 }
}

