package com.liuqi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liuqi.entity.UserBean;
import com.liuqi.service.UserService;

@RequestMapping("a")
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public String getLogin(){
		return"login";
	}
	
	@RequestMapping("/login")
	public String checkPassword(UserBean userBean){
		if(null == userBean) return "login";
		if(userService.getPassword(userBean)){
			return "first";
		}
		return"login";
	}
}
