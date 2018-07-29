package com.mds.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mds.mapper.UsersMapper;
import com.mds.model.User;

@Repository
public class UserDao {

	@Autowired
	private UsersMapper usersMapper;

	public List<User> fetchAllUsers() {
		List<User> listOfUsers = usersMapper.fetchAllUsers();
		return listOfUsers;
	}

	public Integer insert(User user) {
		Integer isInserted = usersMapper.insert(user);
		return isInserted;
	}

	public User findUserById(Integer id) {
		User user = usersMapper.findUserById(id);
		return user;
	}

}
