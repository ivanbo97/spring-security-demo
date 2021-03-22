package com.luv2code.springsecurity.demo.config;



import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.luv2code.springsecurity.demo.util.PropertyValueReader;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.luv2code.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

	
	// setup a variable to store the properties
	
	@Autowired
	private Environment env;
	
	// set up a logger for diagnostics
	
	private Logger logger = Logger.getLogger(getClass().getName());
	// define a bean for ViewResolver

	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	// define a bean for our security data source
	@Bean
	public DataSource securityDataSource() {
		
		// create a connection pool
		ComboPooledDataSource securityDataSource
			= new ComboPooledDataSource();
		
		// set the JDBC driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		// log connection properties
		logger.info(">>> jdbc.url=" + env.getProperty("jdbc.driver"));
		logger.info(">>> jdbc.url=" + env.getProperty("jdbc.user"));
		
		// set database connection properties
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool properties
		securityDataSource.setInitialPoolSize(
				PropertyValueReader.getIntProperty("connection.pool.initialPoolSize",env));
		
		securityDataSource.setMinPoolSize(
				PropertyValueReader.getIntProperty("connection.pool.minPoolSize",env));
		
		securityDataSource.setMaxPoolSize(
				PropertyValueReader.getIntProperty("connection.pool.maxPoolSize",env));
		
		securityDataSource.setMaxIdleTime(
				PropertyValueReader.getIntProperty("connection.pool.maxIdleTime",env));
		
		return securityDataSource;
	}
	
	
}









