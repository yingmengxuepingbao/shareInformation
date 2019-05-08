package com.zyx;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 登录页面入口
 * @author admin
 *
 */
@Controller
public class ActionController {
	@RequestMapping(value = "/login",method = RequestMethod.GET)
    public String index(){
		System.out.println("登录");
        return "view/login.html";
    }
}
