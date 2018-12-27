package com.jarvis.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author Tamilselvan T Date 21-12-18
 *
 */

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.jarvis.configuration" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {

	@Autowired
	private Environment environment;
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[]{"com.jarvis.model"});
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.DriverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.userName"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		return dataSource; 
	}
	
	
	 private Properties hibernateProperties(){
		 Properties properties = new Properties();
		 properties.put("hibernate.dialect",environment.getRequiredProperty("hibernate.dialect"));
		 properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		 properties.put("hibernate.formal_sql", environment.getRequiredProperty("hibernate.formal_sql"));
		 
		 return properties;
	 }
	 
	 public HibernateTransactionManager transactionManager(SessionFactory factroy){
		 HibernateTransactionManager txnManager = new HibernateTransactionManager();
		 txnManager.setSessionFactory(factroy);
		 
		 return txnManager;
	 }
	
}
