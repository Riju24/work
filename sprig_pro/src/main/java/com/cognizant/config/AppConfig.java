package com.cognizant.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.cognizant.dao.StudentDao;
import com.cognizant.dao.StudentDaoImpl;
import com.cognizant.model.Student;

@Configuration
public class AppConfig {
	
	@Bean("student")
	public Student student()
	{
		return new Student();
	}
	@Bean("studao")
	public StudentDao stdentDao()
	{
		return new StudentDaoImpl();
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource ds)
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		return jdbcTemplate;
	}
	
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setUrl("jdbc:mysql://localhost:3306/work");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		
		return ds;
	}

}
