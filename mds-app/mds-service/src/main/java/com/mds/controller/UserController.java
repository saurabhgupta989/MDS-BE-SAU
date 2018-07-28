package com.mds.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mds.mapper.UsersMapper;
import com.mds.model.BlogEntry;
import com.mds.model.Users;

@RestController
public class UserController {

	@Autowired
	private UsersMapper usersMapper;

	@GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> index() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "Hello World Success");
		ResponseEntity<Object> response = null;
		response = new ResponseEntity<Object>(map, HttpStatus.OK);
		return response;
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAll() {
		List<Users> listOfUsers = usersMapper.findAll();
		return new ResponseEntity<Object>(listOfUsers, HttpStatus.OK);
	}

	@PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> insert(@RequestBody Users user) {
		Integer isInserted = usersMapper.insert(user);
		if (isInserted > 0) {
			return new ResponseEntity<Object>(user, HttpStatus.OK);

		} else {
			return new ResponseEntity<Object>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tagJoin")
	public List<BlogEntry> getTagJoin() {
		return usersMapper.findTagJoin();
	}
}
