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

	public Integer insertUser(User user) {
		Integer isInserted = usersMapper.insertUser(user);
		return isInserted;
	}

	public Integer updateUser(User user) {
		Integer isUpdated = usersMapper.updateUser(user);
		return isUpdated;
	}

	public List<User> fetchAllUsers() {
		List<User> listOfUsers = usersMapper.fetchAllUsers();
		return listOfUsers;
	}

	public List<User> fetchAllUsersWithDogs() {
		List<User> listOfUsers = usersMapper.fetchAllUsersWithDogs();
		return listOfUsers;
	}

	public User retrieveUserById(Integer id) {
		User user = usersMapper.retrieveUserById(id);
		return user;
	}

}
