package com.askar.sm.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.askar"})
//@ComponentScan("com.askar")
public class StudentAppConfig {
	
	@Bean
	public InternalResourceViewResolver viewReolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	// For JdbcTemplate
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}
	
	// DatSource
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		// set the DB info
		dataSource.setUsername("root");
		dataSource.setPassword("askar");
		dataSource.setUrl("jdbc:mysql://localhost:3306/askar/useSSL-false");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		return dataSource;
		
	}

}
