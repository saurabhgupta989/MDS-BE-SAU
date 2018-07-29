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
	public Integer saveUser(User user) {
		Integer isInsertOrUpdateStatus;
		if (user.getId() == null) {
			isInsertOrUpdateStatus = userDao.insertUser(user);
		} else {
			isInsertOrUpdateStatus = userDao.updateUser(user);
		}
		return isInsertOrUpdateStatus;
	}

	@Override
	public User retrieveUserById(Integer id) {
		User user = userDao.retrieveUserById(id);
		return user;
	}

	@Override
	public List<User> getAllUsersWitDogDetails() {
		List<User> listOfUsers = userDao.fetchAllUsersWithDogs();
		return listOfUsers;
	}

}
