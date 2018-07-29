package com.mds.service;

import java.util.List;

import com.mds.model.User;

public interface UserService {

	public List<User> fetchAllUsers();

	public Integer insert(User user);

	public User findUserById(Integer id);
}
