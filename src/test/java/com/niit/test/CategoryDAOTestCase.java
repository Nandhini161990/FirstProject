package com.niit.test;


import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.niit.config.DBConfig;
import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

import static org.junit.Assert.*;

import java.util.List;

@SpringJUnitConfig(classes=DBConfig.class) 

public class CategoryDAOTestCase {
	@Autowired
	public static CategoryDAO categ;
	//public Category category;
	
	@BeforeClass
	public static void executeFirst(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		categ = (CategoryDAO)context.getBean("CategoryDAO");
	}
	
@Test
public void addCategoryTest(){
	Category category = new Category();
	//category.setCategoryId(1);
	
	category.setCategoryDesc("Honor Mobile with 8GB and Octa Core Processor");
	category.setCategoryName("Honor");
	System.out.println(category.getCategoryName()+category.getCategoryDesc());
	//categoryDAO.addCategory(category);
	assertTrue("Problem in Adding Category:",categ.addCategory(category));
}
	@Ignore
@Test
public void updateCategoryTest(){
	Category category = categ.getCategory(1);
	category.setCategoryName("Samsung");
	category.setCategoryDesc("Samsung smart mobiles with 4G features");
	assertTrue("Problem in Updating Category:",categ.updateCategory(category));
}
@Ignore
@Test
public void deleteCategoryTest(){
	
	Category category = categ.getCategory(1);
	assertTrue("Problem in Deleting Category:",categ.deleteCategory(category));
	
		
	
}
@Ignore
@Test
public void listCategoriesTest(){
	List<Category> listCategories = categ.listCategories();
	assertTrue("Problem in Listing Category:",listCategories.size()>0);
	for(Category category:listCategories ){
		System.out.print(category.getCategoryId()+":::");
		System.out.print(category.getCategoryName()+":::");
		System.out.print(category.getCategoryDesc()+":::");
	}
}
}

