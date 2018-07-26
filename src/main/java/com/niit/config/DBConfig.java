package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.niit")
@EnableTransactionManagement
public class DBConfig {

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource datasobj = new DriverManagerDataSource();
		datasobj.setDriverClassName("org.h2.Driver");
		datasobj.setUrl("jdbc:h2:tcp://localhost/~/test");
		datasobj.setUsername("sa");
		datasobj.setPassword("");
		return datasobj;
	}

	public Properties getHibernateProperties() {
		Properties myproper = new Properties();
		myproper.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		myproper.setProperty("hibernate.show_sql", "true");
		myproper.setProperty("format_sql", "true");
		myproper.setProperty("use_sql_comments", "true");
        myproper.setProperty("hibernate.hbm2ddl.auto", "update");
		return myproper;
	}

	@Bean(name = "sessionFact")
	@Autowired
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sessionF = new LocalSessionFactoryBean();
		sessionF.setDataSource(dataSource);
		sessionF.setHibernateProperties(getHibernateProperties());
		sessionF.setPackagesToScan("com.niit");

		return sessionF;
	}

	@Bean(name = "transactionMyManager")
	@Autowired
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFact) {
		HibernateTransactionManager transactionobj = new HibernateTransactionManager();
		transactionobj.setSessionFactory(sessionFact);
		return transactionobj;
	}
}

/*
 * @Bean(name="dataSource") public DataSource getH2DataSource(){
 * DriverManagerDataSource dataSource = new DriverManagerDataSource();
 * dataSource.setDriverClassName("org.h2.Driver");
 * dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
 * dataSource.setUsername("sa"); dataSource.setPassword("");
 * System.out.println("Data Source Object created"); return dataSource;
 * 
 * }
 * 
 * @Bean(name="sessionFactory")
 * 
 * @Autowired public SessionFactory getSessionFactory(){ Properties properties =
 * new Properties(); properties.put("hibernate.hbm2ddl.auto", "update");
 * properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
 * LocalSessionFactoryBuilder sessionFactoryBuilder = new
 * LocalSessionFactoryBuilder(getH2DataSource());
 * sessionFactoryBuilder.addProperties(properties); SessionFactory
 * sessionFactory = sessionFactoryBuilder.buildSessionFactory();
 * System.out.println("SessionFactory Object created"); return sessionFactory;
 * 
 * } public Properties getHibernateProperties() { Properties myproper=new
 * Properties(); myproper.setProperty("hibernate.dialect",
 * "org.hibernate.dialect.H2Dialect");
 * myproper.setProperty("hibernate.show_sql", "true");
 * myproper.setProperty("hibernate.hbm2ddl.auto", "update"); return myproper; }
 * 
 * @Bean(name="sessionFact")
 * 
 * @Autowired public LocalSessionFactoryBean sessionFactory(DataSource
 * dataSource) { LocalSessionFactoryBean sessionF=new LocalSessionFactoryBean();
 * sessionF.setDataSource(dataSource);
 * sessionF.setHibernateProperties(getHibernateProperties());
 * sessionF.setPackagesToScan("com.niit");
 * 
 * return sessionF; }
 * 
 * @Bean(name="transactionmyManager")
 * 
 * @Autowired public HibernateTransactionManager
 * getHibernateTransactionManager(SessionFactory sessionFact){
 * //System.out.println("Hibernate Transaction Object created"); //return new
 * HibernateTransactionManager(sessionFactory); HibernateTransactionManager
 * transactionobj=new HibernateTransactionManager();
 * transactionobj.setSessionFactory(sessionFact); return transactionobj; }
 * 
 * }
 * 
 */