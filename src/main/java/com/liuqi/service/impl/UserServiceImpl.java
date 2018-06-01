package com.liuqi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuqi.entity.UserBean;
import com.liuqi.mapper.UserMapper;
import com.liuqi.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	public Boolean getPassword(UserBean userBean){
		if(null == userBean)
			return false;
		UserBean user = userMapper.getPassword(userBean.getUserName());
		if(user.getPassword().equals(userBean.getPassword()))
			return true;
		return false;
	}
}
