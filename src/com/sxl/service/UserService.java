package com.sxl.service;

import java.sql.SQLException;

import com.sxl.dao.UserDao;

public class UserService {

	public boolean checkUsername(String username) throws SQLException {
		UserDao userDao = new UserDao();
		Long isExit = userDao.checkUsername(username);
		return isExit>0?true:false;
	}

}
