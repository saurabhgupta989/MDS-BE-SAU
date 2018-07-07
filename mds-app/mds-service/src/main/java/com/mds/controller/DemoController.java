package com.mds.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping(value = "/test", produces = "application/json")
	public ResponseEntity<Object> index() {
		Map<String, List<Integer>> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		map.put("name", list);
		ResponseEntity<Object> response = null;
		response = new ResponseEntity<Object>(map, HttpStatus.OK);
		return response;
	}
}
