package com.mds.exception;

import java.net.ConnectException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mds.util.Error;

@ControllerAdvice(basePackages = { "com.mds.controller", "com.mds.interceptor" })
@PropertySource("classpath:error.properties")
public class ControllerExceptionHandler {

	@Autowired
	public Environment env;

	@ExceptionHandler({ Exception.class })
	protected ResponseEntity<?> handleEntityNotFound(Exception ex) {
		ex.printStackTrace();
		return sendErrorResponse("E1000", env.getProperty("E1000"));
	}

	@ExceptionHandler({ ConnectException.class, MyBatisSystemException.class })
	protected ResponseEntity<?> handleDBConnectionException(Exception ex) {
		ex.printStackTrace();
		return sendErrorResponse("E1002", env.getProperty("E1002"));
	}

	@ExceptionHandler({ BadSqlGrammarException.class, SQLException.class })
	protected ResponseEntity<?> handleDBException(Exception ex) {
		ex.printStackTrace();
		return sendErrorResponse("E1000", env.getProperty("E1000"));
	}

	@ExceptionHandler({ InvalidDataException.class })
	protected ResponseEntity<?> handleInvalidDataException(Exception ex) {
		ex.printStackTrace();
		return sendErrorResponse("E2104", env.getProperty("E2104"));
	}

	private ResponseEntity<?> sendErrorResponse(String code, String message) {
		Map<Object, Object> resMap = new HashMap<>();

		Error errorResponse = new Error();
		errorResponse.setCode(code);
		errorResponse.setDescription(message);

		List<Error> errorList = new ArrayList<>();
		errorList.add(errorResponse);
		resMap.put("errorList", errorList);

		return new ResponseEntity<Object>(resMap, HttpStatus.OK);
	}

}
