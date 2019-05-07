package com.zyx.controller;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
@Controller
@RequestMapping("/msgPushActivityExtendWay")
public class MsgPushActivityExtendWayController {
	 //@Resource
	 @Autowired
	 private MsgPushActivityExtendWayService msgPushActivityExtendWayService;
	 
	   
	 //@PostMapping("/selectById")
	 //@RequestMapping("/selectById")
	 @GetMapping("/selectById")
	 @ResponseBody
	 public MsgPushActivityExtendWay selectById(String id){
		 System.out.println("进来了");
		 msgPushActivityExtendWayService.selectById("1");
		 return null;
	 }
}

