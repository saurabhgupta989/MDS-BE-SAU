package com.mds.service;

import java.util.List;

import com.mds.model.User;

public interface UserService {

	public List<User> fetchAllUsers();

	public Integer saveUser(User user);

	public User retrieveUserById(Integer id);

	public List<User> getAllUsersWitDogDetails();
}
