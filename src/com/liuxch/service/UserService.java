package com.liuxch.service;

import com.liuxch.bean.User;
import com.liuxch.dao.UserDao;

public class UserService {

	public User Login(String userName, String password){
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
