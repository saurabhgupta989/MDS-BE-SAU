package com.mds.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableCaching
@ComponentScan("com.mds")
public class MdsSpringBootApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(MdsSpringBootApplication.class, args);
	}
}
