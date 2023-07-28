package com.example.bike.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.bike.services.BikeService;
import com.example.bike.services.BikeServiceImpl;

@Configuration
@ComponentScan("com.example.bike")
@PropertySource("classpath:application.properties")
public class AppConfig {

	@Autowired
	Environment env;
	
	private final String URL = "spring.datasource.url";
	private final String USER = "spring.datasource.username";
	private final String PASSWORD = "spring.datasource.password";
	private final String DRIVER = "spring.datasource.driverClassName";
	
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(env.getProperty(URL));
		driverManagerDataSource.setUsername(env.getProperty(USER));
		driverManagerDataSource.setPassword(env.getProperty(PASSWORD));
		driverManagerDataSource.setDriverClassName(env.getProperty(DRIVER));
		return driverManagerDataSource;
	}
}
