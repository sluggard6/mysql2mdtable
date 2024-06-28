package com.github.m2m.config;

import javax.sql.DataSource;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DBConfig {
	
	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String passwrod;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, passwrod);
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSource;
	}
	
	@Bean
	public VelocityEngine velocityEngine() {
//		Properties prop = new Properties();
//		prop.setProperty(Velocity.ENCODING_DEFAULT, "utf-8");
//		prop.setProperty(Velocity.INPUT_ENCODING, "utf-8");
//		prop.setProperty(Velocity.OUTPUT_ENCODING, "utf-8");
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
	    ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	    ve.setProperty(Velocity.ENCODING_DEFAULT, "utf-8");
	    ve.setProperty(Velocity.INPUT_ENCODING, "utf-8");
	    ve.setProperty(Velocity.OUTPUT_ENCODING, "utf-8");
	    ve.init();
	    return ve;
	}
	
//	@Bean
//    NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) { 
//        return new NamedParameterJdbcTemplate(dataSource);
//    }

}
