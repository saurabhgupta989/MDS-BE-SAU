package com.mds.service;

import java.util.List;

import com.mds.model.Users;

public interface UserService {

	public List<Users> fetchAllUsers();

	public Integer insert(Users user);
}
