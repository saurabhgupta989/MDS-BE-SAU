package com.mds.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mds.mapper.UsersMapper;
import com.mds.model.Users;

@Repository
public class UserDao {

	@Autowired
	private UsersMapper usersMapper;

	public List<Users> fetchAllUsers() {
		List<Users> listOfUsers = usersMapper.fetchAllUsers();
		return listOfUsers;
	}

	public Integer insert(Users user) {
		Integer isInserted = usersMapper.insert(user);
		return isInserted;
	}

}
