package com.mds.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mds.dao.UserDao;
import com.mds.model.Users;
import com.mds.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<Users> fetchAllUsers() {
		List<Users> listOfUsers = userDao.fetchAllUsers();
		return listOfUsers;
	}

	@Override
	public Integer insert(Users user) {
		Integer isInserted = userDao.insert(user);
		return isInserted;
	}

}
