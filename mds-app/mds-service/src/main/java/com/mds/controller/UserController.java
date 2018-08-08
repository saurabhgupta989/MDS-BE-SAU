package com.mds.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mds.mapper.UsersMapper;
import com.mds.model.BlogEntry;
import com.mds.model.User;
import com.mds.service.UserService;

@RestController
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UsersMapper usersMapper;

	@Autowired
	private UserService userService;

	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveUser(@RequestBody User user) {

		logger.info("saveUser invoked");
		logger.debug("saveUser invoked");
		Integer status = userService.saveUser(user);

		if (status > 0) {
			return new ResponseEntity<Object>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/allUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAll() {

		logger.info("getAll invoked");
		logger.debug("getAll invoked");
		List<User> listOfUsers = userService.fetchAllUsers();
		return new ResponseEntity<Object>(listOfUsers, HttpStatus.OK);
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllUsersWitDogDetails() {
		logger.info("getAllUsersWitDogDetails invoked");
		logger.debug("getAllUsersWitDogDetails invoked");
		List<User> listOfUsers = userService.getAllUsersWitDogDetails();
		return new ResponseEntity<Object>(listOfUsers, HttpStatus.OK);
	}

	@GetMapping(value = "/retrieveUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> retrieveUserById(@RequestParam Integer id) {

		logger.info("retrieveUserById invoked");
		logger.debug("retrieveUserById invoked");
		User user = userService.retrieveUserById(id);
		return new ResponseEntity<Object>(user, HttpStatus.OK);
	}

	@GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> index() {
		logger.info("index invoked");
		logger.debug("index invoked");
		Map<String, String> map = new HashMap<>();
		map.put("name", "Hello World Success");
		ResponseEntity<Object> response = null;
		response = new ResponseEntity<Object>(map, HttpStatus.OK);
		return response;
	}

	@GetMapping("/tagJoin")
	public List<BlogEntry> getTagJoin() {
		logger.info("getTagJoin invoked");
		logger.debug("getTagJoin invoked");
		return usersMapper.findTagJoin();
	}
}
