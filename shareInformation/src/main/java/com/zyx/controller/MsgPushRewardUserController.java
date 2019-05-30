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

import com.zyx.model.MsgPushRewardUser;
import com.zyx.service.MsgPushRewardUserService;

/**
 * <p>
 * 用户活动推广奖励记录表 前端控制器
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Controller
@RequestMapping("/msgPushRewardUser")
public class MsgPushRewardUserController {
	@Autowired
	private MsgPushRewardUserService msgPushRewardUserService;
	
	@RequestMapping(value = "/getRewardByOpenId", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getRewardByOpenId(@Valid @RequestBody MsgPushRewardUser msgPushRewardUser){
	 System.out.println("进来了");
	 String openId =msgPushRewardUser.getOpenId();
	 List<MsgPushRewardUser> list =msgPushRewardUserService.getRewardByOpenId(openId);
	 Map<String,Object> returnMap =new HashMap<String,Object>();
	 returnMap.put("list", list);
	 returnMap.put("count", list.size());
	 return returnMap; 
	}
}

