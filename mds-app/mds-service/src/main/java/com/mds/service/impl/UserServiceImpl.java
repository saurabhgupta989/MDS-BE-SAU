package com.mds.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mds.dao.UserDao;
import com.mds.model.User;
import com.mds.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> fetchAllUsers() {
		List<User> listOfUsers = userDao.fetchAllUsers();
		return listOfUsers;
	}

	@Override
	public Integer insert(User user) {
		Integer isInserted = userDao.insert(user);
		return isInserted;
	}

	@Override
	public User findUserById(Integer id) {
		User user = userDao.findUserById(id);
		return user;
	}

}
