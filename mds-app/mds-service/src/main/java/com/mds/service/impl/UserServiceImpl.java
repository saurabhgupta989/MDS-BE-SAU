package com.mds.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mds.mapper.UsersMapper;
import com.mds.model.Users;
import com.mds.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersMapper usersMapper;

	@Override
	public List<Users> fetchAllUsers() {
		List<Users> listOfUsers = usersMapper.findAll();
		return listOfUsers;
	}

	@Override
	public Integer insert(Users user) {
		Integer isInserted = usersMapper.insert(user);
		return isInserted;
	}

}
