/*package com.niit.CategoryTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.config.DBConfig;
import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=DBConfig.class)
public class CategoryTest {
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private Category category;
	@Before
	public void setUp() throws Exception {
		
		category=new Category();
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test(expected=Exception.class)
	 @Test
	public void Add()
	{
	  	
		 category.setCategoryId(124);
		 category.setCategoryName("jhj");
		 category.setCategoryDesc("com");
	  	System.out.println(category.getCategoryId()+category.getCategoryName()+category.getCategoryDesc());
		
	  	assertEquals("Success",true,categoryDAO.addCategory(category));
	}
}
*/