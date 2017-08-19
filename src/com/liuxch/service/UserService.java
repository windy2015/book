package com.liuxch.service;

import java.util.Map;

import com.liuxch.bean.User;
import com.liuxch.dao.UserDao;
import com.liuxch.exception.ParameterException;
import com.liuxch.exception.ServiceException;

public class UserService {

	public User Login(String userName, String password) throws ParameterException, ServiceException{
		
		ParameterException paraException  = new ParameterException();

		if ("".equals(userName) || userName == null) {
			paraException.addErrField("name", "user name can not be null");
		}

		if ("".equals(password) || password == null) {
			paraException.addErrField("pwd", "password can not be null");
		}
		
		Map<String,String> errMap = paraException.getErrMap();
		
		if(!errMap.isEmpty()){
			throw paraException;
		}
		
		UserDao  userDao = new UserDao();		
		User user = userDao.getUserByName(userName);
		if(user==null){
			throw new ServiceException(1000, "用户名或密码错误");
		}
		
		if(!user.getPassword().equals(password)){
			throw new ServiceException(1000, "用户名或密码错误");
		}
		
		return user;
		
	}	
}
