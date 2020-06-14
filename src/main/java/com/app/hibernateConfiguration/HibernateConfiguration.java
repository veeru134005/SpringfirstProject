package com.app.hibernateConfiguration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {

@Bean	
 public DataSource dataSource() {
	 
	 DriverManagerDataSource dataSource=new DriverManagerDataSource();
	 
	 dataSource.setDriverClassName("net.sourceforge.jtds.jdbc.Driver");
	 dataSource.setUrl("jdbc:jtds:sqlserver://localhost:1433;DatabaseName=veeru");
	 dataSource.setUsername("sa");
	 dataSource.setPassword("Teamw0rk1");
	 return dataSource;
 }
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
	
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
	
		//sessionFactory.setAnnotatedClasses(test.class);
		//sessionFactory.setAnnotatedPackages("com.app.testPojo");
		sessionFactory.setPackagesToScan("com.app.entityPojos");
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setHibernateProperties(hibernateProperties());
	
		return sessionFactory;
	
	}
	
	private Properties hibernateProperties() {
	
		Properties properties=new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.hbm2ddl.auto", "create");//hibernate.show_sql
	
		return properties;
	}
	
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		
		HibernateTransactionManager hibernateTransaction=new HibernateTransactionManager();
		
		hibernateTransaction.setSessionFactory(sessionFactory().getObject());
		
		return hibernateTransaction;
	}

	
}
