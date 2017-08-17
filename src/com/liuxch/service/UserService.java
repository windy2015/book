package com.liuxch.service;

import java.util.Map;

import com.liuxch.bean.User;
import com.liuxch.dao.UserDao;
import com.liuxch.exception.ParameterException;

public class UserService {

	public User Login(String userName, String password) throws ParameterException{
		
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
			return user;
		}
		
		if(!user.getPassword().equals(password)){
			return null;
		}
		
		return user;
		
	}	
}
