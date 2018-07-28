package com.mds.main;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

import com.mds.mapper.UsersMapper;

/**
 * Hello world!
 *
 */
@MappedTypes(UsersMapper.class)
@MapperScan("com.mds.mapper")
@SpringBootApplication
@EnableCaching
@ComponentScan("com.mds")
public class MdsSpringBootApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(MdsSpringBootApplication.class, args);
	}
}
