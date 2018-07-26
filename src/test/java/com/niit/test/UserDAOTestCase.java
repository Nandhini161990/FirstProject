package com.niit.test;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Category;
import com.niit.model.UserDetail;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
//@SpringJUnitConfig(classes=DBConfig.class) 

public class UserDAOTestCase {

	public static UserDAO userDAO;
	//private Category category;
	@BeforeClass
	public static void executeFirst(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		 userDAO = (UserDAO)context.getBean("userDAO");
	}
	
	@Ignore
@Test
public void addUserTest(){
	UserDetail userDetail = new UserDetail();
	userDetail.setUsername("nan");
	userDetail.setPassword("19aghtqwe");
	userDetail.setRole("admin");
	//categoryDAO.addCategory(category);
	assertTrue("Problem in Adding User:",userDAO.registerUser(userDetail));
}
	@Ignore
@Test
public void updateUserTest(){
	UserDetail userDetail = userDAO.getUserDetail("nan");
	userDetail.getPassword();
	((UserDetail) userDetail).setUsername("nand");
	((UserDetail) userDetail).setPassword("123fgtyu");
	assertTrue("Problem in Updating User:",userDAO.updateUserDetail((UserDetail)userDetail));
}

@Test
public void listUserDetailsTest(){
	List<UserDetail> listUserDetails = userDAO.listUserDetails();
	//listUserDetails.
	assertTrue("Problem in Listing UserDetails:",listUserDetails.size()>0);

	for(UserDetail userdetail:listUserDetails ){
		System.out.print(userdetail.getUsername()+":::");
		System.out.print(userdetail.getPassword()+":::");
		System.out.print(userdetail.getRole()+":::");
	}
}
}

